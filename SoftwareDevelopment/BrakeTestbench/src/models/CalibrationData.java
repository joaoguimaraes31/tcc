package models;

public class CalibrationData {
    
    Sensor[] sensorSetup;

    public CalibrationData() {
    }
    
    public CalibrationData(Sensor sensor0, Sensor sensor1, Sensor sensor2, Sensor sensor3, Sensor sensor4, Sensor sensor5) {
        this.sensorSetup[0]=sensor0;
        this.sensorSetup[1]=sensor1;
        this.sensorSetup[2]=sensor2;
        this.sensorSetup[3]=sensor3;
        this.sensorSetup[4]=sensor4;
        this.sensorSetup[5]=sensor5;
    }

}
