package models;

public class Thermocouple extends Sensor {
    
    //constructor for calibration
    public Thermocouple(int sensorID, float sensorReading) {
        this.sensorType="Thermocouple_"+Integer.toString(sensorID);
        this.sensorReading=sensorReading;
        this.unityOfMeasurement = "°C";
    }
    public Thermocouple(int sensorID, String partModel, float sensorReading) {
        this.sensorType="Thermocouple_"+Integer.toString(sensorID);
        this.partModel=partModel;
        this.sensorReading=sensorReading;
        this.unityOfMeasurement = "°C";
    }
    
    //constructor for calibration
    public Thermocouple(int sensorID, float calibrationOffset, float conversionFactor) {
        this.sensorType="Thermocouple_"+Integer.toString(sensorID);
        this.calibrationOffset=calibrationOffset;
        this.conversionFactor=conversionFactor;
        this.unityOfMeasurement = "°C";
    }    
    public Thermocouple(int sensorID, String partModel, float calibrationOffset, float conversionFactor) {
        this.sensorType="Thermocouple_"+Integer.toString(sensorID);
        this.partModel=partModel;
        this.calibrationOffset=calibrationOffset;
        this.conversionFactor=conversionFactor;
        this.unityOfMeasurement = "°C";
    }
}