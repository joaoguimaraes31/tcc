package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        createView();
    }


    
    
    //CRIAR TELA INICIAL E ADCIONAR EVENTOS
    public void createView(){
		view = new InitialScreenView();
                view.setVisible(true);                
                addListeners();
    }
    
    
    public void createView(String selectedSerialPort){
		createView();
                if (selectedSerialPort != null){
                    view.getCalibrationMenuBT().setEnabled(true);
                }else{
                    view.getCalibrationMenuBT().setEnabled(false);
                }
    }
    
    public void addListeners(){        
        actionListenerSerialSetupBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                 view.dispose();
                 navigationController.serialPortSetupController.createView();
                 //model.setCurrentScreen(ScreenPossibilities.SERIAL_SETUP);
              }
        };                
        view.getSerialSetupBT().addActionListener(actionListenerSerialSetupBT); 
        
        actionListenerCalibrationMenuBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                 view.dispose();
                 navigationController.calibrationController.createView();
                 //model.setCurrentScreen(ScreenPossibilities.CALIBRATION);   
              }
        };                
        view.getCalibrationMenuBT().addActionListener(actionListenerCalibrationMenuBT);
        
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
