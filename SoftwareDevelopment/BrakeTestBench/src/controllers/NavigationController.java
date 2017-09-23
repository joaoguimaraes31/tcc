package controllers;

import builders.*;
import models.NavigationModel;
import views.ApplicationFrame;

public class NavigationController {

    //builders to create subsystems
    private SerialPortSetupControllerBuilder serialPortSetupBuilder;
    private CalibrationControllerBuilder calibrationControllerBuilder;

    //Lower controllers
    private SerialPortSetupController serialPortSetupController;
    private CalibrationController calibrationController;

    //MVC
    private ApplicationFrame view;
    private NavigationModel model;

    public NavigationController() {
        ////MVC
        model = new NavigationModel(false);
        view = new ApplicationFrame();
        

        //Creating Sub-systems
        ///Subsystem serial setup
        serialPortSetupBuilder = new SerialPortSetupControllerBuilder(this);
        serialPortSetupController = serialPortSetupBuilder.getSerialPortSetupController();
        
        ///Subsystem calibration
        calibrationControllerBuilder = new CalibrationControllerBuilder(this);
        calibrationController = calibrationControllerBuilder.getCalibrationController();
        
        
        view.setVisible(true);
    }

    //Getters
    public ApplicationFrame getView() {
        return view;
    }

    public NavigationModel getModel() {
        return model;
    }

}
