package controller;

import models.SensorCalibrationModel;
import views.SensorCalibrationView;

public class SensorCalibrationController {

    SensorCalibrationView view = new SensorCalibrationView();
    SensorCalibrationModel model = new SensorCalibrationModel();
    
    public SensorCalibrationController(SensorCalibrationView view, SensorCalibrationModel model) {
        this.view=view;
        this.model=model;
    }
}
