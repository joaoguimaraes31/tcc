int sensorPin = A0;    // select the input pin for the potentiometer
int inputPin = 13;      // select the pin for the LED
int sensorValue = 0;  // variable to store the value coming from the sensor

void setup() {
  // declare the ledPin as an OUTPUT:
  pinMode(inputPin, INPUT);
  Serial.begin(9600);
}

void loop() {
  // read the value from the sensor:

  if (digitalRead(inputPin) == HIGH){

  Serial.println("Teste");
  delay(500);
  }

  
}
