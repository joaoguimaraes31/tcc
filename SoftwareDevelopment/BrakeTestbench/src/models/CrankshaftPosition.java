package models;

public class CrankshaftPosition  extends Sensor {

    //constructor for calibration
    public CrankshaftPosition(int sensorID, String partModel, float sensorReading) {
        this.sensorType="CrankshaftPosition_"+Integer.toString(sensorID);
        this.partModel=partModel;
        this.sensorReading=sensorReading;
        this.unityOfMeasurement = "Hz";
    }
    
    //constructor for calibration
    public CrankshaftPosition(int sensorID, String partModel, float calibrationOffset, float conversionFactor) {
        this.sensorType="CrankshaftPosition_"+Integer.toString(sensorID);
        this.partModel=partModel;
        this.calibrationOffset=calibrationOffset;
        this.conversionFactor=conversionFactor;
        this.unityOfMeasurement = "Hz";
    }
    
}
