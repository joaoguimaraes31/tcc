package models;

public class Accelerometer extends Sensor {

    //constructor for calibration
    public Accelerometer(int sensorID, String partModel, float sensorReading) {
        this.sensorType="Accelerometer_"+Integer.toString(sensorID);
        this.partModel=partModel;
        this.sensorReading=sensorReading;
        this.unityOfMeasurement = "g";
    }
    
    //constructor for calibration
    public Accelerometer(int sensorID, String partModel, float calibrationOffset, float conversionFactor) {
        this.sensorType="Accelerometer_"+Integer.toString(sensorID);
        this.partModel=partModel;
        this.calibrationOffset=calibrationOffset;
        this.conversionFactor=conversionFactor;
        this.unityOfMeasurement = "g";
    }
    
}