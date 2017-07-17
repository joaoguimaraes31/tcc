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
    
    //getters and setters

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public String getPartModel() {
        return partModel;
    }

    public void setPartModel(String partModel) {
        this.partModel = partModel;
    }

    public float getCalibrationOffset() {
        return calibrationOffset;
    }

    public void setCalibrationOffset(float calibrationOffset) {
        this.calibrationOffset = calibrationOffset;
    }

    public float getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(float conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public float getSensorReading() {
        return sensorReading;
    }

    public void setSensorReading(float sensorReading) {
        this.sensorReading = sensorReading;
    }

    public String getUnityOfMeasurement() {
        return unityOfMeasurement;
    }

    public void setUnityOfMeasurement(String unityOfMeasurement) {
        this.unityOfMeasurement = unityOfMeasurement;
    }
    
    
    
}
