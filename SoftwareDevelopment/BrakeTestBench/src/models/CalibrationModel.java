package models;

public class CalibrationModel {
    
    private final float ADC_VOLTAGE_REFERENCE=5;
    private final int ADC_RESOLUTION=1023;
    
    
    
    //Calibration Data
    private float calibrationData[][]={{1,0},{1,0},{1,0},{1,0},{1,0},{1,0}};
    private float currentCalibration[]={1,0};   //factor, offset
    
    
    //conversionFormulas
    public float adcReadToVoltage(int read) {
        return ((float) read * ADC_VOLTAGE_REFERENCE /ADC_RESOLUTION);
    }

    public float voltageToCalibrateMeasurement(float voltage, int index) {
        float measurement=0;
        switch (index) {
            case 0:
                measurement = voltage * 100;
            case 1:
                measurement = voltage * 100;
            case 2:
                measurement = voltage * 100;
            case 3:
                measurement = voltage * 100;
            case 4:
                measurement = voltage * 100;
            case 5:
                measurement = voltage * 100;
        }

        measurement*=currentCalibration[0];
        
        measurement+=currentCalibration[1];
        return measurement;
    }
    
    public float readToMeasurement(int read, int index){
        return voltageToCalibrateMeasurement(adcReadToVoltage(read),index);
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
