package controllers;

import builders.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.NavigationModel;
import views.ApplicationFrame;

public class NavigationController {

    //builders to create subsystems
    private SerialPortSetupControllerBuilder serialPortSetupBuilder;
    private CalibrationControllerBuilder calibrationControllerBuilder;
    private ConfigurationControllerBuilder configurationControllerBuilder;
    private BraketestControllerBuilder braketestControllerBuilder;
    private MenuControllerBuilder menuControllerBuilder;

    //Lower controllers
    private SerialPortSetupController serialPortSetupController;
    private CalibrationController calibrationController;
    private ConfigurationController configurationController;
    private BraketestController braketestController;
    private MenuController menuController;
    
    //MVC
    private ApplicationFrame view;
    private NavigationModel model;
    
    public NavigationController() {

        ///MVC
        model = new NavigationModel(false);

        //Creating Sub-systems
        ///Subsystem Serial Setup
        serialPortSetupBuilder = new SerialPortSetupControllerBuilder(this);
        serialPortSetupController = serialPortSetupBuilder.getController();
        
        ///Subsystem Calibration
        calibrationControllerBuilder = new CalibrationControllerBuilder(this);
        calibrationController = calibrationControllerBuilder.getController();
        
        ///Subsystem Configuration
        configurationControllerBuilder = new ConfigurationControllerBuilder(this);
        configurationController = configurationControllerBuilder.getController();
        
        ///Subsystem Braketest
        braketestControllerBuilder = new BraketestControllerBuilder(this);
        braketestController = braketestControllerBuilder.getController();
        
        ///Subsystem menu
        menuControllerBuilder =  new MenuControllerBuilder(this);
        menuController = menuControllerBuilder.getController();
        
     
        ////MVC
        view = new ApplicationFrame(this);
        
        
        view.setVisible(true);
    }
    
    //Getters
    public ApplicationFrame getView() {
        return view;
    }

    public NavigationModel getModel() {
        return model;
    }

    public SerialPortSetupController getSerialPortSetupController() {
        return serialPortSetupController;
    }

    public CalibrationController getCalibrationController() {
        return calibrationController;
    }

    public ConfigurationController getConfigurationController() {
        return configurationController;
    }

    public BraketestController getBraketestController() {
        return braketestController;
    }

    public MenuController getMenuController() {
        return menuController;
    }
    
    
    
}
