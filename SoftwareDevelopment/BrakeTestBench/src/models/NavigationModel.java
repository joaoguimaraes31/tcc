package models;

import gnu.io.CommPortIdentifier;

public class NavigationModel {
    
    //Parameters
    private boolean isSerialPortSet = false;
    private CommPortIdentifier selectedSerialPort=null;

    //Constructor
    public NavigationModel(boolean isSerialPortSet) {
        this.isSerialPortSet = isSerialPortSet;
    }
    
    //Getters and Setters
    public boolean isIsSerialPortSet() {
        return isSerialPortSet;
    }

    public void setIsSerialPortSet(boolean isSerialPortSet) {
        this.isSerialPortSet = isSerialPortSet;
    }
    
    public CommPortIdentifier getSelectedSerialPort() {
        return selectedSerialPort;
    }

    public void setSelectedSerialPort(CommPortIdentifier selectedSerialPort) {
        this.selectedSerialPort = selectedSerialPort;
    }
    
}
