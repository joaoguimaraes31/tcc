
package models;

public class SensorSetupModel {
    private String[] sensorSetupArray = {"Not in use","Not in use","Not in use","Not in use","Not in use","Not in use"};
    private String[] sensorModelsArray = {"","","","","",""};

    public SensorSetupModel() {
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
