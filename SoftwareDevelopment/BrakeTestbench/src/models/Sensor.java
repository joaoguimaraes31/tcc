package models;

public class Sensor {
    
    protected String sensorType = "";
    protected int sensorId = 0;
    protected String partModel = "";
    protected float calibrationOffset = 0;
    protected float conversionFactor = 1;
    protected float sensorReading=0;
    protected String unityOfMeasurement = "";

    public void sensorReadingCalibration(){
        sensorReading=(sensorReading*conversionFactor)+calibrationOffset;
    }  
    
    public float getCalibrationOffset() {
        return calibrationOffset;
    }

    public float getConversionFactor() {
        return conversionFactor;
    }
    
    public void setSensorReading(float sensorReading){
        this.sensorReading=sensorReading;
    }
    
    
}
