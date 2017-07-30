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
    private ActionListener actionListenerSetPort;
    
    
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
        view.getSearchBT().addActionListener(actionListenerSearch);
        
        //SetPort
        actionListenerSetPort = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {        
                  //set value in main class
                  selectedSerialPort=view.getPortsCB().getSelectedItem().toString();
              }
        };
        view.getSetBT().addActionListener(actionListenerSetPort);
    }
}
        