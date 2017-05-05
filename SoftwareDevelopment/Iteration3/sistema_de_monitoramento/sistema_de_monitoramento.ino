#include <TimerOne.h>

#include "TimerOne.h"


//Definicoes
#define RESET                 0
#define LED_PIN               13
#define samplingRate         1000000
#define NUMBER_OF_SAMPLES     5
#define START_ACQ             '!'
#define STOP_ACQ              '"'


//Variaveis Globais
boolean enableAcquisition=false;
int samples=0;

//Funcao que configura o timer 1 - Aquisicao
void configureTimer1(){
  Timer1.attachInterrupt(timer1_OISR);
  Timer1.initialize(1000000);
  Timer1.stop();
}

//Interrupcao pelo timer 1 por overflow
void timer1_OISR(){
  if(enableAcquisition){
    Serial.println("interrupcao");
    samples++;
  }
}

//Funcao setup - inicializada com arduino
void setup(){
  configureTimer1();
  Serial.begin(9600);
  Timer1.restart();
  enableAcquisition=true;
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
}
