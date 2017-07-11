package controller;

import builders.BuilderSensorCalibration;
import models.Sensor;
import models.Thermocouple;
import views.SensorSetup;

public class CalibrationData {

    public SensorSetup sensorSetup = new SensorSetup();
    private BuilderSensorCalibration builderCalibrationData = new BuilderSensorCalibration();
    private Sensor[] sensors = {null, null, null, null, null, null};

    public void createCalibrationInstances(String[] calibrationInfo) {

        for (int i = 0; i < 6; i++) {
            sensors[i]=builderCalibrationData.builderCalibrationData(calibrationInfo[i], i, "generic",0, 1);
        }

    }

    public void showSensorSetup() {
        sensorSetup.setVisible(true);
    }

    public void hideSensorSetup() {
        sensorSetup.setVisible(false);
    }

}
