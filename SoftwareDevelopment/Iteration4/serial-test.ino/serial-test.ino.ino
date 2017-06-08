void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(13,OUTPUT);
  digitalWrite(13,LOW);

}

void loop() {
  Serial.print("h");
  delay(100);

  if (Serial.available()){
    char byteRead = Serial.read();

    if (byteRead==97){
      digitalWrite(13,(digitalRead(13)^1));
      byteRead=0;
    }
  }
  

}
