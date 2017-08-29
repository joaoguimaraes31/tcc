package models;

import java.util.HashMap;

public class SerialPortsSetupModel {
    
    private HashMap portMap;
    private String selectedSerialPort;

    public SerialPortsSetupModel() {
        portMap = new HashMap();
        selectedSerialPort = "none";
    }

    
    //getters and setters
    public HashMap getPortMap() {
        return portMap;
    }

    public void setPortMap(HashMap portMap) {
        this.portMap = portMap;
    }

    public String getSelectedSerialPort() {
        return selectedSerialPort;
    }

    public void setSelectedSerialPort(String selectedSerialPort) {
        this.selectedSerialPort = selectedSerialPort;
    }
}
