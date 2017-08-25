package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gnu.io.CommPortIdentifier;
import java.util.HashMap;

import commands.*;
import models.*;
import views.*;

public class SerialPortSetupController {
    
    //upper controller
    private NavigationController navigationController;
    
    //MVC
    private SerialPortsSetupModel model;
    private SerialPortSetupView view;
    private SerialPortSetupCommand command;
    private ActionListener actionListenerReturnBT, actionListenerSearchBT, actionListenerPortsCB, actionListenerSetBT;
    
    
    //constructor
    public SerialPortSetupController() {
        model = new SerialPortsSetupModel();
        command = new SerialPortSetupCommand();
    }
    
    //CRIAR TELA INICIAL E ADCIONAR EVENTOS
    public void createView(){
		view = new SerialPortSetupView();
                command.fillComboBoxWithPortNames(view,model.getPortMap());
                
                if (model.getSelectedSerialPort()!=null){
                    view.getSelectedPortLB().setText(model.getSelectedSerialPort());
                }else{
                    view.getSelectedPortLB().setText("none");
                }
                
                if (model.getSelectedSerialPort()==null && model.getPortMap()!=null){
                    view.getSetBT().setEnabled(true);
                }else{
                    view.getSetBT().setEnabled(false);
                }
                
                view.setVisible(true);
                addListeners();
    }
    
    //addListeners for controlling view and triggers events
    public void addListeners(){        
        actionListenerReturnBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                 view.dispose();
                 navigationController.getInitialScreenController().createView(model.getSelectedSerialPort());
              }
        };                
        view.getReturnBT().addActionListener(actionListenerReturnBT);   
        
        actionListenerSearchBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                    System.out.println("SearchBT");
                    command.searchForPorts();
                    model.setPortMap(command.getPortMap());
                    //function to control view
                    command.fillComboBoxWithPortNames(view,model.getPortMap());
                    
                    if (view.getPortsCB().getSelectedItem().toString()!=null){
                        view.getSetBT().setEnabled(true);
                    }else{
                        view.getSetBT().setEnabled(false);
                    }
              }
        };                
        view.getSearchBT().addActionListener(actionListenerSearchBT);  
        

        actionListenerPortsCB = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                    //view.dispose();
                    System.out.println("portsCB");
                    view.getSetBT().setEnabled(true);
              }
        };                
        view.getPortsCB().addActionListener(actionListenerPortsCB);  
       

        actionListenerSetBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                 //view.dispose();
                 System.out.println("setBT");
                 model.setSelectedSerialPort(view.getPortsCB().getSelectedItem().toString());
                 view.getSetBT().setEnabled(false);
                 view.getSelectedPortLB().setText(model.getSelectedSerialPort());
              }
        };                
        view.getSetBT().addActionListener(actionListenerSetBT);
    }  
    
    //getters and setters

    public SerialPortsSetupModel getModel() {
        return model;
    }
    
    
    public void setNavigationController(NavigationController navigationController){
        this.navigationController=navigationController;
    }
    
    

}
