#include <TimerOne.h>
#include <MsTimer2.h>



//Definicoes
#define RESET                 0
#define LED_PIN               13
#define samplingRate         1000000
#define NUMBER_OF_SAMPLES     5
#define START_ACQ             '!'
#define STOP_ACQ              '"'
#define ACQ_LED_BLINK_MS     250


//Variaveis Globais
boolean enableAcquisition=false;
int samples=0;

//Funcao que configura o timer 1 - Aquisicao
void configureTimer1(){
  Timer1.attachInterrupt(timer1_OISR);
  Timer1.initialize(1000000);
  Timer1.stop();
}

//Funcao que configura o timer 2 - Led aquisicao
void configureTimer2() {
  MsTimer2::set(ACQ_LED_BLINK_MS, timer2_OISR); 
}

//Interrupcao pelo timer 1 por overflow
void timer1_OISR(){
  if(enableAcquisition){
    Serial.println("interrupcao");
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

//Funcao setup - inicializada com arduino
void setup(){
  pinMode(LED_PIN,OUTPUT);
  digitalWrite(LED_PIN,LOW);
  configureTimer1();
  configureTimer2();
  Serial.begin(9600);
  Timer1.restart();
  MsTimer2::start();
}

//Funcao loop - executada continuamente
void loop(){
  //parar o timer quando o numero de amostras for o desejado
  if(samples>=NUMBER_OF_SAMPLES){
    Timer1.stop();
       
    Serial.println("Samples limit");
    samples=RESET;
    Timer1.restart();   //reinciando o timer        
  }

  //Verificado dado da porta serial
  if (Serial.available()){
    
    //Lendo o byte mais recente
    char byteRead = Serial.read();

    switch(byteRead)
    {
      //Recebeu comando iniciar aquisicao
      case START_ACQ:
      {
        if(enableAcquisition==false){
          //Habilita a aquisicao
          enableAcquisition=true;       
        }            
      }
      break;
      case STOP_ACQ:
      {
        if(enableAcquisition==true){
          //Desabilita a aquisicao
          enableAcquisition=false;     
        } 
      }
      break; 
    }
  }
}
