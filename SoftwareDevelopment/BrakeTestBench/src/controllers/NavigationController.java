package controllers;

import builders.*;
import models.*;
import views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.NavigationModel.ScreenPossibilities;

public class NavigationController  {
    
    //MVC PATTERN
    private NavigationModel model;
    
    
    //builders to create subsystems
    private SerialPortSetupBuilder serialPortSetupBuilder;
    private CalibrationBuilder calibrationBuilder;
    private InitialScreenBuilder initialScreenBuilder;
    
    //needed controllers
    SerialPortSetupController serialPortSetupController;
    private CalibrationController calibrationController;
    private InitialScreenController initialScreenController;

    
    public NavigationController() {
        //model setup
        model = new NavigationModel(false);
        
        //Creating Sub-systems
        ///Subsystem serial setup
        serialPortSetupBuilder = new SerialPortSetupBuilder();
        serialPortSetupBuilder.createSubsystem(this);
        serialPortSetupController = serialPortSetupBuilder.getSerialPortSetupController();
        ///subsystem calibration
        calibrationBuilder = new CalibrationBuilder();
        calibrationBuilder.createSubsystem(this);
        calibrationController = calibrationBuilder.getCalibrationController();
        ///initialScreen
        initialScreenBuilder = new InitialScreenBuilder();
        initialScreenBuilder.createSubsystem(this);
        initialScreenController = initialScreenBuilder.getInitialScreenController();
        
        
        //ViewControl
        //model.setCurrentScreen(ScreenPossibilities.INITIAL);
    }   

    public InitialScreenController getInitialScreenController() {
        return initialScreenController;
    }
    
    
         
     
}
