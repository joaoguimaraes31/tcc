# Basic Hardware Implementation For Software Development


## 1. Introduction

On this iteration the critical hardware interface between the microcontroller and the PC setup was developed and implemented.

## 2. Procedure

The hardware was separated in two parts, one for programming the Microcontroller (uploading the code into the device memmory) and another part for establishing a serial connection/communication between the Computer and the Microntroller.


### 2.1. Hardware For Programming Microcontroller

In to upload the code into de Microcontroller a USBasp was used. 

!(USBasp Board)[http://www.learningaboutelectronics.com/images/USBASP.png]

This device is based on a ATMega8 microcontroller and is used to program AVR microcontrollers. Whereas most of the time it is refered just as USB AVR programmer. It is consisted with a 10 pin cable according to layout in the bellow image.

!(USBasp pins)[http://www.learningaboutelectronics.com/images/AVR-programmer-10-pin-cable-pinout.png]

| Pin Name   | Description   	    | Comment  |
| -----------|:--------------------:| -----:|
| MISO       | Master Out Slave In  | This allows the master device (the USBASP) to send data to the slave device (target AVR being programmed). |
| MOSI 	     | Master In Slave Out  |   This allows the slave device (target AVR being programmed) to send information to the master device (the USBASP programmer). |
| SCK        | Serial Clock         |    This is the mutual clock shared between the master and slave device for synchronized communication. |
| Reset      | Target AVR MCU Reset |    The reset pin for the AVR chip being programmed must be put in active low in order for programming to occur.|
| Vcc 	     | Power                |    The master and slave device both need power in order to operate. |
| GND 	     | Common Ground        |    The master and slave device must share a common power ground. for operation. |


### 2.2. Hardware For Reading and Writting Serial Data

In order to implement the serial communication between the computer and the microcontroller it was used a RS232 to TTL converter. RS232 is the pattern of serial connection from a default USB port from a computer while TTL is the pattern for serial connection of the microcontroller. The converter bellow was used for that.

(FTDI)[http://www.huinfinito.com.br/1902-thickbox_default/modulo-conversor-usb-20-p-rs232-ttl-uart-5pinos-cp2102.jpg]

## 2.3. Final Connection

Both devices (RS232 to TTL converter and USBasp) were connected to the microcontroller as the image bellow shows.

(Final Schematic)[schematic.png]

The potentiometer was used to generate a variable analog voltage signal to be read by the serial port. The red LED shows if the protoboard is wired up and the green one was installed for debugging.


### 2.4. Code

The following code was used to test the connection.

```c
int sensorPin = A0;    // select the input pin for the potentiometer
int ledPin = 13;      // select the pin for the LED
int sensorValue = 0;  // variable to store the value coming from the sensor

void setup() {
  // declare the ledPin as an OUTPUT:
  pinMode(ledPin, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  // read the value from the sensor:
  sensorValue = analogRead(sensorPin);

  Serial.println(sensorValue);
  delay(500);

  
}
```

This code prints the value of voltage on the potentiometer output with a value inside the range 0 to 1023 every 500ms, where 0 means 0V and 1023 means 5V on a linear scale.

## 3. Testing

The hardware was mounted on the breadboard and connect on the computer as the image bellow.

!(Circuit Wired)[real_schematic.png]

The reading from the serial monitor varies with the potentiometer angle.

!(Screen Monitor)[serial_monitor.png]

## 4. Conclusion

The code and the hardware were capable of both programming the microcontroller and establishing the serial connection between the microntroller and the computer.
