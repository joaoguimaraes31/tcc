package controllers;

import gnu.io.CommPortIdentifier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.NavigationModel;
import views.*;

public class InitialScreenController {
    
    //upper controller
    private NavigationController navigationController;
    
    //MVC
    private InitialScreenView view;
        //action listeners to control view
        private ActionListener actionListenerSerialSetupBT;
        private ActionListener actionListenerCalibrationMenuBT;
        //private ActionListener actionListenerBrakeTestBT;
        //private ActionListener actionListenerReadmeBT;
        private ActionListener actionListenerExitBT;
        
    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }   
        

    public InitialScreenController() {
        createView(null);
    }
    
    //CRIAR TELA INICIAL E ADCIONAR EVENTOS
    public void createView(CommPortIdentifier selectedSerialPort){
		view = new InitialScreenView();
                             
                
                if (selectedSerialPort != null){
                    view.getSensorSetupBT().setEnabled(true);
                }else{
                    view.getSensorSetupBT().setEnabled(false);
                }
                addListeners();
                view.setVisible(true);   
    }
    
    public void addListeners(){        
        actionListenerSerialSetupBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                 view.dispose();
                 navigationController.getSerialPortSetupController().createView();
                 //model.setCurrentScreen(ScreenPossibilities.SERIAL_SETUP);
              }
        };                
        view.getSerialSetupBT().addActionListener(actionListenerSerialSetupBT); 
        
        actionListenerCalibrationMenuBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                 view.dispose();
                 navigationController.getSensorSetupController().createView();
                 //model.setCurrentScreen(ScreenPossibilities.CALIBRATION);   
              }
        };                
        view.getSensorSetupBT().addActionListener(actionListenerCalibrationMenuBT);
        
        actionListenerExitBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  System.exit(0);
              }
        };                
        view.getExitBT().addActionListener(actionListenerExitBT);
    }  

    public InitialScreenView getView() {
        return view;
    }   
}