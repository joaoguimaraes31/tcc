package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.InitialScreenModel;
import views.InitialScreenView;


public class InitialScreenController {
    
    InitialScreenView view = new InitialScreenView();
    InitialScreenModel model = new InitialScreenModel();

    public InitialScreenController(InitialScreenModel model, InitialScreenView view) {
        this.model=model;
        this.view=view;
    }
    
    private ActionListener actionListenerSensorSetupBT;
    private ActionListener actionListenerSensorCalibrationBT;
    private ActionListener actionListenerSerialPortSetupBT;

    
    public void control(){
        
        view.setVisible(true);
        
        //SensorSet
        actionListenerSensorSetupBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {
                  model.setCurrentScreen("SENSOR_SETUP_SCREEN");
                  view.setVisible(false);
              }
        };
        view.getSensorSetupBT().addActionListener(actionListenerSensorSetupBT);
        
        //Calibration
        actionListenerSensorCalibrationBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) { 
                  model.setCurrentScreen("SENSOR_CALIBRATION_SCREEN");
                  view.setVisible(false);
              }
        };
        view.getSensorCalibrationBT().addActionListener(actionListenerSensorSetupBT);
        
        //SerialPortSetup
        actionListenerSerialPortSetupBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {   
                  model.setCurrentScreen("SERIAL_PORT_SETUP_SCREEN");
                  view.setVisible(false);
              }
        };
        view.getSerialPortSetupBT().addActionListener(actionListenerSensorSetupBT);
    }
    
}