package controller;

import models.SensorSetupModel;
import views.SensorSetupView;

public class SensorSetupController {
    
    SensorSetupView view = new SensorSetupView();
    SensorSetupModel model = new SensorSetupModel();
    
    public SensorSetupController(SensorSetupView view, SensorSetupModel model) {
        this.view = view;
        this.model = model;
    }
    
}
