package controller;

import builders.BuilderSensorCalibration;
import models.Sensor;

public class CalibrationData {

    private final BuilderSensorCalibration builderCalibrationData = new BuilderSensorCalibration();
    private Sensor[] sensors;

    public CalibrationData() {
        this.sensors = new Sensor[]{null, null, null, null, null, null};
    }

    public void createCalibrationInstances(String[] calibrationInfo, String[] sensorModel, float[] calibrationOffset, float[] conversionFactor) {

        for (int i = 0; i < 6; i++) {
            sensors[i]=builderCalibrationData.builderCalibrationData(calibrationInfo[i], i, sensorModel[i],calibrationOffset[i],conversionFactor[i]);
        }
    }
}
