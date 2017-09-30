package models;

import java.text.SimpleDateFormat;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CalibrationModel {

    //CONSTANTS
    private final float ADC_VOLTAGE_REFERENCE = 5;
    private final int ADC_RESOLUTION = 1023;
    private final SpinnerNumberModel FACTOR_SPINNER_MODEL = new SpinnerNumberModel(1, 0.7, 1.3, 0.01);
    private final SpinnerNumberModel OFFSET_SPINNER_MODEL = new SpinnerNumberModel(0, -30, 30, 0.5);
    private final double SPINNERS_RANGE[][] = {{0.7, 1.3}, {-30, 30}};
    private final String SENSOR_VALUES[][] = {{"Thermocouple 1", "Thermocouple 2", "Load Cell 1", "Load Cell 2", "Accelerometer", "CKP"},
    {"Connected", "Connected", "Connected", "Connected", "Connected", "Connected"},
    {"1.0", "1.0", "1.0", "1.0", "1.0", "1.0"},
    {"0.0", "0.0", "0.0", "0.0", "0.0", "0.0",}};

    //Vars
    private float currentCalibration[] = {1, 0};   //factor, offset
    private float previousCalibration[] = {1, 0};   //factor, offset
    private boolean settingsLoadded = false;

    //Strings for file functions
    private final String descriptors[] = {"Sensor", "Status", "Conv.Factor", "Offset"};
    private float calibrationValues[][] = {{1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}};

    private final String header = "Braketestbench Calibration Settings\nDate Modified ";
    private final String calibrationFileName = "BTF-calibration.cfg";
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private final FileNameExtensionFilter filter = new FileNameExtensionFilter("BrakeTestBench Configuration Files (.cfg)", "cfg");
    private int headerSize = 2;

    //conversionFormulas
    public float adcReadToVoltage(int read) {
        return ((float) read * ADC_VOLTAGE_REFERENCE / ADC_RESOLUTION);
    }

    public float voltageToCalibrateMeasurement(float voltage, int index) {
        float measurement = 0;
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

        measurement *= currentCalibration[0];

        measurement += currentCalibration[1];
        return measurement;
    }

    public float readToMeasurement(int read, int index) {
        return voltageToCalibrateMeasurement(adcReadToVoltage(read), index);
    }

    public String unityOfMeasurement(String sensor) {
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

    public void floatValuesToString(String[][] sensorValues, float[][] calibrationValues) {
        for (int i = 0; i < calibrationValues.length; i++) {
            for (int j = 0; j < calibrationValues[0].length; j++) {
                sensorValues[i + 2][j] = String.valueOf(calibrationValues[i][j]);
            }
        }
    }

    public void stringValuesToFloat(String[][] sensorValues, float[][] calibrationValues) {
        for (int i = 0; i < calibrationValues.length; i++) {
            for (int j = 0; j < calibrationValues[0].length; j++) {
                calibrationValues[i][j] = Float.parseFloat(sensorValues[i + 2][j]);
            }
        }
    }

    public String[][] getSENSOR_VALUES() {
        return SENSOR_VALUES;
    }

    public float[] getCurrentCalibration() {
        return currentCalibration;
    }

    public String[] getDescriptors() {
        return descriptors;
    }

    public String getHeader() {
        return header;
    }

    public String getCalibrationFileName() {
        return calibrationFileName;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }
    
    public FileNameExtensionFilter getFilter() {
        return filter;
    }

    public int getHeaderSize() {
        return headerSize;
    }

    public double[][] getSPINNERS_RANGE() {
        return SPINNERS_RANGE;
    }

    public float[][] getCalibrationValues() {
        return calibrationValues;
    }

    public SpinnerNumberModel getFACTOR_SPINNER_MODEL() {
        return FACTOR_SPINNER_MODEL;
    }

    public SpinnerNumberModel getOFFSET_SPINNER_MODEL() {
        return OFFSET_SPINNER_MODEL;
    }

    public float[] getPreviousCalibration() {
        return previousCalibration;
    }

    public boolean isSettingsLoadded() {
        return settingsLoadded;
    }

    public void setCurrentCalibration(float[] currentCalibration) {
        this.currentCalibration = currentCalibration;
    }

    public void setPreviousCalibration(float[] previousCalibration) {
        this.previousCalibration = previousCalibration;
    }

    public void setSettingsLoadded(boolean settingsLoadded) {
        this.settingsLoadded = settingsLoadded;
    }

}
