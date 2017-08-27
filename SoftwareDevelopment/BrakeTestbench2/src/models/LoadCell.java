package models;

public class LoadCell extends Sensor{

    //constructor for calibration
    public LoadCell(int sensorID, String partModel, float sensorReading) {
        this.sensorType="LoadCell_"+Integer.toString(sensorID);
        this.partModel=partModel;
        this.sensorReading=sensorReading;
        this.unityOfMeasurement = "N";
    }
    
    //constructor for calibration
    public LoadCell(int sensorID, String partModel, float calibrationOffset, float conversionFactor) {
        this.sensorType="LoadCell_"+Integer.toString(sensorID);
        this.partModel=partModel;
        this.calibrationOffset=calibrationOffset;
        this.conversionFactor=conversionFactor;
        this.unityOfMeasurement = "N";
    }
    
}
