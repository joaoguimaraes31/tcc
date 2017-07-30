package controller;

import static controller.Main.selectedSerialPort;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import models.SerialPortsSetupModel;
import views.SerialPortsSetupView;

public class SerialPortsSetupController {
    
    SerialPortsSetupModel model = new SerialPortsSetupModel();
    SerialPortsSetupView view = new SerialPortsSetupView();
    SerialPortsFacade serialPortsFacade = new SerialPortsFacade();
    
    private HashMap portMap = new HashMap();
    
    private ActionListener actionListenerSearch;
    private ActionListener actionListenerConnect;
    private ActionListener actionListenerDisconnect;
    
    
    public SerialPortsSetupController(SerialPortsSetupModel model, SerialPortsSetupView view) {
        this.model=model;
        this.view=view;
    }
    
    public void control(){
        //Search for serial ports
        actionListenerSearch = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {        
                  //searching for ports                  
                  serialPortsFacade.searchForPorts();
                  portMap=serialPortsFacade.getPortMap();
                  //function to control view
                  model.fillComboBoxWithPortNames(view,portMap);        
              }
        }; 
        
        //connect
        actionListenerConnect = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {        
                  //connecting
                  serialPortsFacade.connect(view.getPortsCB().getSelectedItem().toString());
                  //function to control view
                  model.updateViewConnection(view,serialPortsFacade);
                  //update main class wih serial port name
                  selectedSerialPort=view.getPortsCB().getSelectedItem().toString();
              }
        };
        
        //disconnect
        actionListenerDisconnect = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {        
                  //disconnecting
                  serialPortsFacade.disconnect();
                  //function to control view 
                  model.updateViewConnection(view,serialPortsFacade);
              }
        };
    }
}