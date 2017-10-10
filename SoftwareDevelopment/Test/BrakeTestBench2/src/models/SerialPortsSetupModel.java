package models;

import java.util.HashMap;
import gnu.io.CommPortIdentifier;

public class SerialPortsSetupModel {
    
    private HashMap portMap;
    private CommPortIdentifier selectedSerialPort = null;

    public SerialPortsSetupModel() {
        portMap = new HashMap();
    }

    
    //getters and setters
    public HashMap getPortMap() {
        return portMap;
    }

    public void setPortMap(HashMap portMap) {
        this.portMap = portMap;
    }

    public CommPortIdentifier getSelectedSerialPort() {
        return selectedSerialPort;
    }

    public void setSelectedSerialPort(CommPortIdentifier selectedSerialPort) {
        this.selectedSerialPort = selectedSerialPort;
    }

    
}
