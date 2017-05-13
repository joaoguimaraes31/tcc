#include <TimerOne.h>
#include <MsTimer2.h>
#include <math.h>


//Definicoes
#define RESET                 0
#define LED_PIN               13
#define samplingRate         1000000
#define START_ACQ             '+'
#define STOP_ACQ              ','
#define MASTER_RESET          '.'
#define ACQ_LED_BLINK_MS     250
#define SAMPLE_RATE_1K        10000
#define DEBUG                 1

//Variaveis Globais
static boolean enableAcquisition=false;
int samples=0;
short COMMAND_PORTS[]={2,3,4,5};
boolean commandInstruction[]={0,0,0,0};
unsigned long int RATES[]={1000000,100000,10000,SAMPLE_RATE_1K,100,10};
unsigned long int numberSamples = 100;
unsigned long int SAMPLES[]={1,10,100,500,1000,10000};
static float sensorData[]={0,0,0,0,0,0};
unsigned long int sampleRate=SAMPLE_RATE_1K;

//Funcao que configura o timer 1 - Aquisicao
void configureTimer1(){
  Timer1.attachInterrupt(timer1_OISR);
  Timer1.initialize(sampleRate);
  Timer1.stop();
}

//Funcao que configura o timer 2 - Led aquisicao
void configureTimer2() {
  MsTimer2::set(ACQ_LED_BLINK_MS, timer2_OISR); 
}

//Interrupcao pelo timer 1 por overflow
void timer1_OISR(){
  if (samples<numberSamples){
    if(enableAcquisition==true){
      //Lendo dado analogico
    sensorData[0]=sensorData[0]+analogRead(A0);
    sensorData[1]=sensorData[1]+analogRead(A1);
    sensorData[2]=sensorData[2]+analogRead(A2);
    sensorData[3]=sensorData[3]+analogRead(A3);
    sensorData[4]=sensorData[4]+analogRead(A4);
    sensorData[5]=sensorData[5]+analogRead(A5);
  samples++;
    }   
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

//Funcao quando a acquisicao para
void acquisitionStop(){
   Timer1.stop();
   enableAcquisition=false;
   samples=RESET;
   for(int i=0;i<6;i++){
    sensorData[i]=RESET;
   }
}

//Funcao que escreve os resultados da aquisicao na porta serial
void printResults(int * result){    
    Serial.print(result[0]);
    Serial.print(",");
    Serial.print(result[1]);
    Serial.print(",");
    Serial.print(result[2]);
    Serial.print(",");
    Serial.print(result[3]);
    Serial.print(",");
    Serial.print(result[4]);
    Serial.print(",");
    Serial.println(result[5]);
}

//Funcao que printa um cabecalho para debug
void debugStarterMenu(){

Serial.println(F("--------------------------------------------------------------------------------------------------------------------------------------------------\n--------------------------------------------------------------------------------------------------------------------------------------------------\nPrograma para aquisicao de dados analogicos atraves de 6 entradas analogicas usando o chip ATMEGA328p integrado com controle de 4 saidas digitais.\n--------------------------------------------------------------------------------------------------------------------------------------------------\nFeito Por: Joao Guimaraes \nComandos:\n      -Inicar Aquisicao: '+'\n      -Terminar Aquisicao: ','\n      -Mater Reset(Reseta samplingRate, numberOfSamples e comandos digitais para valores padroes): '.'\n      -Set numberOfSamples:\n           -1:         '!'\n           -10:        '\"'\n           -100:       '#'\n           -500:       '$'\n           -1k:        '%'\n           -10k:       '&'\n     -Set numberOfSamples:\n           -1Hz:       'A'\n           -10Hz:      'B'\n           -100Hz:     'C'\n           -1kHz:      'D'\n           -10kHz:     'E'\n           -100kHz:    'F'\n      -Saidas Digitais:\n           -0000:      '`'\n           -0001:      'a'\n           -0010:      'b'\n           -...        ...\n           -1110:      'n'\n           -1111:      'o'\n"));



}
//Funcao setup - inicializada com arduino
void setup(){
  
  Serial.begin(9600);

  #ifdef DEBUG
    debugStarterMenu();
  #endif
  
  pinMode(LED_PIN,OUTPUT);
  for(int i=0;i<sizeof(COMMAND_PORTS);i++){
     pinMode(COMMAND_PORTS[i],OUTPUT);
     digitalWrite(COMMAND_PORTS[i],LOW);
  }
  digitalWrite(LED_PIN,LOW);
  configureTimer1();
  configureTimer2();
  
  //Timer1.restart();
  MsTimer2::start();
}

//Funcao loop - executada continuamente
void loop(){
  //parar o timer quando o numero de amostras for o desejado
  if(samples>=numberSamples){
    Timer1.stop();
    
    static int resultAcq[6];
    for(int counter=0;counter<6;counter++){
      resultAcq[counter] = (int)roundf((sensorData[counter]/numberSamples));    
      sensorData[counter]=RESET;
    }
    samples=RESET;
    Timer1.restart();   //reinciando o timer 

    printResults(resultAcq);
    
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
          //Serial.println(numberSamples);
          //Serial.println(sampleRate);
          Timer1.restart();       
        }            
      }
      break;
      case STOP_ACQ:{
          //Desabilita a aquisicao
          acquisitionStop();
                         
      }
      break;

      case MASTER_RESET:{
        acquisitionStop();
        resetCommandOutput();
        sampleRate=RATES[3];
        numberSamples=SAMPLES[2];
        configureTimer1();      
         
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
            if (byteRead <71){
              sampleRate=RATES[(byteRead-65)];
              Timer1.setPeriod(sampleRate);
              Timer1.stop();
              
            }
          }

          if (byteRead > 32){     //Controle da Number of Samples
            if (byteRead <39){
              numberSamples=SAMPLES[(byteRead - 33)];
            }
          }
        }

      break; 
    }
  }
}
