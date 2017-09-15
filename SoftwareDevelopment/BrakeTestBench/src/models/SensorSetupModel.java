package models;

public class SensorSetupModel {

    //info for configuration files
    private String[] HEADER = {
        "SENSOR0_TYPE", "SENSOR0_LABEL", "SENSOR0_CALIBRATION_OFFSET", "SENSOR0_CALIBRATION_FACTOR",
        "SENSOR1_TYPE", "SENSOR1_LABEL", "SENSOR1_CALIBRATION_OFFSET", "SENSOR1_CALIBRATION_FACTOR",
        "SENSOR2_TYPE", "SENSOR2_LABEL", "SENSOR2_CALIBRATION_OFFSET", "SENSOR2_CALIBRATION_FACTOR",
        "SENSOR3_TYPE", "SENSOR3_LABEL", "SENSOR3_CALIBRATION_OFFSET", "SENSOR3_CALIBRATION_FACTOR",
        "SENSOR4_TYPE", "SENSOR4_LABEL", "SENSOR4_CALIBRATION_OFFSET", "SENSOR4_CALIBRATION_FACTOR",
        "SENSOR5_TYPE", "SENSOR5_LABEL", "SENSOR5_CALIBRATION_OFFSET", "SENSOR5_CALIBRATION_FACTOR",};

    private String[] values = {
        "NULL", "NULL", "0", "1",
        "NULL", "NULL", "0", "1",
        "NULL", "NULL", "0", "1",
        "NULL", "NULL", "0", "1",
        "NULL", "NULL", "0", "1",
        "NULL", "NULL", "0", "1",};

    private int currentCalibration[] = {0, 0}; //{factor,offset}

    //conversionFormulas
    public float adcReadToVoltage(float read) {
        return read * 5 / 1023;
    }

    public float voltageToCalibrateMeasurement(float voltage, String sensor) {//Not Connected, Thermocouple, Load Cell, Accelerometer,CKP
        float measurement = 0;
        switch (sensor) {
            case "Thermocouple":
                measurement = voltage * 100;
            case "Load Cell":
                measurement = voltage * 100;
            case "Accelerometer":
                measurement = voltage * 100;
            case "CKP":
                measurement = voltage * 100;
        }
        float factor = (100 + currentCalibration[0]) / 100;
        float offset = currentCalibration[1] * measurement / 100;
        measurement = factor * measurement + offset;
        return measurement;
    }

    public String unityOfMeasurement(String sensor) {
        String out = "";
        switch (sensor) {
            case "Thermocouple":
                out = "Temperature (Celcius)";
                break;
            case "Load Cell":
                out = "Force (N)";
                break;
            case "Accelerometer":
                out = "Acceleration (m/(s^2))";
                break;
            case "CKP":
                out = "Speed (m/s)";
                break;
        }
        return out;
    }

    public int[] getCurrentCalibration() {
        return currentCalibration;
    }

    public void setCurrentCalibration(int[] currentCalibration) {
        this.currentCalibration = currentCalibration;
    }

    public String[] getHEADER() {
        return HEADER;
    }

    public String[] getValues() {
        return values;
    }

}
