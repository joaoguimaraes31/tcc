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

    //Lower controllers
    private SerialPortSetupController serialPortSetupController;
    private CalibrationController calibrationController;

    //MVC
    private ApplicationFrame view;
    private NavigationModel model;
    
    //ActionListeners
    private ActionListener aLloadCalibrationFile, aLsaveCalibrationFile,aLexit;//System.exit(0);

    public NavigationController() {

        ///MVC
        model = new NavigationModel(false);

        //Creating Sub-systems
        ///Subsystem serial setup
        serialPortSetupBuilder = new SerialPortSetupControllerBuilder(this);
        serialPortSetupController = serialPortSetupBuilder.getSerialPortSetupController();
        
        ///Subsystem calibration
        calibrationControllerBuilder = new CalibrationControllerBuilder(this);
        calibrationController = calibrationControllerBuilder.getCalibrationController();
        
        ////MVC
        view = new ApplicationFrame(this);
        
        
        view.setVisible(true);
        addListeners();
    }
    
    public void addListeners(){
        aLexit= new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
               if (calibrationController.getCommunicator().isConnected()){
                   calibrationController.getCommunicator().disconnect();
               }
               System.exit(0);
            }
        };
        view.getMenuItemExit().addActionListener(aLexit);
        
        aLloadCalibrationFile= new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
              // System.out.println("load calibration files");
              calibrationController.getFileFunctions().readingFromFile();
            }
        };
        view.getMenuItemOpenCalibrationFile().addActionListener(aLloadCalibrationFile);
        
        aLsaveCalibrationFile= new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //System.out.println("save calibration files");
                calibrationController.getFileFunctions().writtingToFileRoutine();
            }
        };
        view.getMenuItemSaveCalibrationFile().addActionListener(aLsaveCalibrationFile);
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
    
    
}
