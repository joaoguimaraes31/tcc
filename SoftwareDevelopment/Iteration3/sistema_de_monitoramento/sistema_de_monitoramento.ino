#include <TimerOne.h>
#include <MsTimer2.h>
#include <math.h>


//Definicoes
#define RESET                 0
#define LED_PIN               13
#define samplingRate         1000000
#define NUMBER_OF_SAMPLES     100
#define START_ACQ             '!'
#define STOP_ACQ              '"'
#define MASTER_RESET          '#'
#define ACQ_LED_BLINK_MS     250


//Variaveis Globais
boolean enableAcquisition=false;
int samples=0;
short COMMAND_PORTS[]={2,3,4,5};
boolean commandInstruction[4]={0,0,0,0};
unsigned long int RATES[]={1000000,100000,10000,1000,100,10,1};
int numberSamples = 100;
int SAMPLES[]={1,10,100,500,1000};

//Funcao que configura o timer 1 - Aquisicao
void configureTimer1(){
  Timer1.attachInterrupt(timer1_OISR);
  Timer1.initialize(1000);
  Timer1.stop();
}

//Funcao que configura o timer 2 - Led aquisicao
void configureTimer2() {
  MsTimer2::set(ACQ_LED_BLINK_MS, timer2_OISR); 
}

//Interrupcao pelo timer 1 por overflow
void timer1_OISR(){
  if (samples<numberSamples){
  //Serial.println("ISR");
  samples++;
  }
}

//Interrupcao pelo timer 2 por overflow
void timer2_OISR(){
  if(enableAcquisition){
    digitalWrite(LED_PIN, digitalRead(LED_PIN) ^ 1);
  }else{
    digitalWrite(LED_PIN, LOW);
  }
}

//FUNCAO QUE CONTROLA OS COMANDOS/SAIDAS-DIGITAIS
void commandOutput(){
  for(int i=0;i<sizeof(COMMAND_PORTS);i++){
    if(commandInstruction[i]){
      digitalWrite(COMMAND_PORTS[i],HIGH);
    }else{
      digitalWrite(COMMAND_PORTS[i],LOW);
    }
  }
}

//Funcao que "reseta" os comandos/saidas digitais
void resetCommandOutput(){
  for(int i=0;i<sizeof(COMMAND_PORTS);i++){
    commandInstruction[i]=0;
  }
  commandOutput();
}

//Funcao setup - inicializada com arduino
void setup(){
  pinMode(LED_PIN,OUTPUT);
  for(int i=0;i<sizeof(COMMAND_PORTS);i++){
     pinMode(COMMAND_PORTS[i],OUTPUT);
     digitalWrite(COMMAND_PORTS[i],LOW);
  }
  digitalWrite(LED_PIN,LOW);
  configureTimer1();
  configureTimer2();
  Serial.begin(9600);
  //Timer1.restart();
  MsTimer2::start();
}

//Funcao loop - executada continuamente
void loop(){
  //parar o timer quando o numero de amostras for o desejado
  if(samples>=numberSamples){
    Timer1.stop();
    Serial.println(samples);
    Serial.println("Event for Samples limit");
    samples=RESET;
    delay(2000);
    Timer1.restart();   //reinciando o timer        
  }

  //Verificado dado da porta serial
  if (Serial.available()){
    
    //Lendo o byte mais recente
    char byteRead = Serial.read();

    switch(byteRead) {
      
      //Recebeu comando iniciar aquisicao
      case START_ACQ:{
        if(enableAcquisition==false){
          //Habilita a aquisicao
          enableAcquisition=true;
          samples=RESET;
          Timer1.restart();       
        }            
      }
      break;
      case STOP_ACQ:{
        if(enableAcquisition==true){
          //Desabilita a aquisicao
          enableAcquisition=false;
          Timer1.stop();               
        } 
      }
      break;

      case MASTER_RESET:{
        Timer1.setPeriod(RATES[(0)]);
        Timer1.stop();
        enableAcquisition=false;
        samples=RESET;
        resetCommandOutput();
         
      }
      break;
      
      default:{
        if (byteRead > 95){       //Controle dos comandos
          if (byteRead < 112){
            for (int i = 3; i>-1; i--) {
              commandInstruction[i]=((byteRead >> i) & 1);
            }
            commandOutput();
          }
        }
      }
      if(enableAcquisition==false){
          if (byteRead > 64){     //Controle da Sampling Rate (default 1KHz)
            if (byteRead <72){
              Timer1.setPeriod(RATES[(byteRead-65)]);
              Timer1.stop();
              
            }
          }

          if (byteRead > 47){     //Controle da Number of Samples
            if (byteRead <53){
              numberSamples=SAMPLES[(byteRead - 48)]; 
            }
          }
        }

      break; 
    }
  }
}
