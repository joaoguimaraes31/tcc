//Libraries
#include <TimerOne.h>
#include <MsTimer2.h>
#include <math.h>

//HW DEFINITIONS
//Digital ports
///inputs
#define	ADC_CON_0		2
#define	ADC_CON_1		3
#define	ADC_CON_2		4
#define	ADC_CON_3		6
#define	ADC_CON_4		7
#define	ADC_CON_5		8
///outputs
#define DIG_OUT_PORT_0		9
#define	DIG_OUT_PORT_1		10
#define RELAY_OUT_0		11
#define RELAY_OUT_1		12
#define	ACQ_LED			13

//Analog Ports
#define	PWM_OUT			5


//COMMUNICATIONS DEFINITIONS
#define START_ACQ_BYTE		21
#define	STOP_ACQ_BYTE		22
#define MASTER_RESET_BYTE	23
#define NULL_DIGITAL_BYTE	96
#define MAX_DIGITAL_BYTE	111
#define NULL_SPEED_BYTE		155
#define MAX_SPEED_BYTE		255


//GENERAL DEFINITIONS
#define SET			1
#define RESET			0
#define ACQ_LED_BLINK_MS	250
#define SAMPLE_RATE		10
#define NUMBER_OF_SAMPLES	100


//GLOBAL VARS
static boolean acquisitionEnabled=false;
int samples=RESET;
short DIGITAL_OUT_PORTS[]={DIG_OUT_PORT_0,DIG_OUT_PORT_1,RELAY_OUT_0,RELAY_OUT_1};
short DIGITAL_IN_PORTS[]={ADC_CON_0,ADC_CON_1,ADC_CON_2,ADC_CON_3,ADC_CON_4,ADC_CON_5};

boolean digitalInstruction={RESET,RESET,RESET,RESET};
static float sensorData[]={RESET,RESET,RESET,RESET,RESET,RESET};


//Function to write to digital ports
void digitalOutputControl(){
	for(int i=RESET;i<NUMBER_OF_DIGITAL_PORTS;i++){
		digitalWrite(DIGITAL_OUT_PORTS[i],digitalInstruction[i])
	}
}

//Function to set all digital outputs to low
void resetDigOutputs(){
	for(int i=RESET;i<NUMBER_OF_DIGITAL_PORTS;i++){
		digitalInstruction[i]=RESET;
	}
	digitalOutputControl;
}

//Function to configure Timer 0 - PWM-OUT
void configureTimer0(){
	TCCR0B = (TCCR0B & 0b11111000) | 0x01;
}

//Function to configure Timer 1 - ACQUISITION 
void configureTimer1(){
	Timer1.attachInterrupt(timer1_OISR);
	Timer1.initialize(SAMPLE_RATE);
	Timer1.stop();
}

//Function to configure timer 2 - LED
void configureTimer2() {
	MsTimer2::set(ACQ_LED_BLINK_MS, timer2_OISR); 
}

//Timer 1 overflow interruption routine
void timer1_OISR(){
	if (samples<NUMBER_OF_SAMPLES){
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

//Timer 1 overflow interruption routine
void timer2_OISR(){
	if(enableAcquisition){
		digitalWrite(ACQ_LED_PIN, digitalRead(ACQ_LED_PIN) ^ 1);
	}else{
    		digitalWrite(ACQ_LED_PIN, LOW);
  	}
}

//Function to write adc results in serial port
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
	Serial.print(result[5]);
	Serial.print(".");
}

void IOsetup(){
	pinMode(ACQ_LED_PIN,OUTPUT);

	for(int i=0;i<6;i++){
		if (i<4){
			pinMode(DIGITAL_OUT_PORTS[i],OUTPUT)
		}
		pinMode(DIGITAL_IN_PORTS[i],INPUT);
	}

}

void setup(){
	Serial.begin(9600);
	IOsetup();
	digitalWrite(ACQ_LED_PIN,LOW);

	configureTimer0();
	configureTimer1();
	configureTimer2();
	MsTimer2::start();
}

void loop(){
	if (samples>=NUMBER_OF_SAMPLES){
		Timer1.stop();
		static int resultAcq[6];
	
		for(int k=0;k<6;k++){
			resultAcq[counter] = (int)roundf((sensorData[counter]/NUMBER_OF_SAMPLES));
			sensorData[counter]=RESET;
		}
		samples=RESET;
		Timer1.restart();
		
		printResults(resultAcq);
	}

	if(Serial.available()){
	
	char.byteRead = Serial.read();

	switch(byteRead){
		
		case START_ACQ_BYTE:{
			if (!acquisitionEnabled){
				acquisitionEnabled=true;
				samples=RESET;
				Timer1.restart();
			}
		}
		break;

		case STOP_ACQ_BYTE:{
			acquisitionStop();
		}
		break;

		case MASTER_RESET_BYTE:{
			acquisitionStop();
			resetDigOutputs();
		}
		break;

		default:{
			if (byteRead>=NULL_SPEED_BYTE){
				unsigned char speed_byte = byteRead;
				speed_byte-=NULL_SPEED_BYTE;
				int speed=RESET;
				speed = 1023*speed_byte/(MAX_SPEED_BYTE - NULL_SPEED_BYTE);
				analogWrite(PWM_OUT,speed);
				
			}else if ((byteRead>=NULL_DIGITAL_BYTE) && (byteRead<=MAX_DIGITAL_BYTE)){
				for (int i = 3; i>-1; i--) {
              				digitalInstruction[i]=((byteRead >> i) & 1);
            			}
           			digitalOutputControl();
			}
		}
		break;
	}
}
