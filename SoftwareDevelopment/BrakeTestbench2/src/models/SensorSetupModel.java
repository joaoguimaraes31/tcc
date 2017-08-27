package models;

public class SensorSetupModel {

    private String[] sensorSetupArray = {"Not in use", "Not in use", "Not in use", "Not in use", "Not in use", "Not in use"};
    private String[] sensorModelsArray = {"", "", "", "", "", ""};

    public Sensor sensorInstances(String sensorTypeString, int sensorID, String partModel) {

        Sensor sensor = null;

        switch (sensorTypeString) {
            case "Thermocouple":
                sensor = new Thermocouple(sensorID, partModel, 0, 1);
            case "LoadCell":
                sensor = new LoadCell(sensorID, partModel, 0, 1);
            case "CrankshaftPosition":
                sensor = new CrankshaftPosition(sensorID, partModel, 0, 1);
            case "Accelerometer":
                sensor = new Accelerometer(sensorID, partModel, 0, 1);
            default:
                sensor = null;
        }

        return sensor;
    }

    public String[] getSensorSetupArray() {
        return sensorSetupArray;
    }

    public String[] getSensorModelsArray() {
        return sensorModelsArray;
    }

    public void setSensorSetupArray(String[] sensorSetupArray) {
        this.sensorSetupArray = sensorSetupArray;
    }

    public void setSensorModelsArray(String[] sensorModelsArray) {
        this.sensorModelsArray = sensorModelsArray;
    }

}
