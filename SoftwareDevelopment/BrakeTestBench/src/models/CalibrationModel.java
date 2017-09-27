package models;

public class CalibrationModel {
    
    private final float ADC_VOLTAGE_REFERENCE=5;
    private final int ADC_RESOLUTION=1023;
    
    
    
    //Calibration Data
    private float calibrationData[][]={{1,0},{1,0},{1,0},{1,0},{1,0},{1,0}};
    private float currentCalibration[]={1,0};   //factor, offset
    
    
    //conversionFormulas
    public float adcReadToVoltage(float read) {
        return read * ADC_VOLTAGE_REFERENCE /ADC_RESOLUTION;
    }

    public float voltageToCalibrateMeasurement(float voltage, String sensor) {
        float measurement = 0;
        switch (sensor) {
            case "Thermocouple 1":
                measurement = voltage * 100;
            case "Thermocouple 2":
                measurement = voltage * 100;
            case "LoadCell 1":
                measurement = voltage * 100;
            case "LoadCell 2":
                measurement = voltage * 100;
            case "Accelerometer":
                measurement = voltage * 100;
            case "CKP":
                measurement = voltage * 100;
        }
        float factor = currentCalibration[0]/100;
        float offset = (100 + currentCalibration[1]) / 100;
        measurement = factor * measurement + offset;
        return measurement;
    }
    
    public String unityOfMeasurement(String sensor){
        String out = new String("null");
        switch (sensor) {
            case "Thermocouple 1":
                out = "Temperature [C]";
            case "Thermocouple 2":
                out = "Temperature [C]";
            case "LoadCell 1":
                out = "Force [KN]";
            case "LoadCell 2":
                out = "Force [KN]";
            case "Accelerometer":
                out = "Acceleration [m*s^-2]";
            case "CKP":
                out = "Speed [rpm]";
        }
        return out;
    }

    public float[][] getCalibrationData() {
        return calibrationData;
    }

    public float[] getCurrentCalibration() {
        return currentCalibration;
    }
    
    
}
