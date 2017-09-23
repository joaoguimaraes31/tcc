package models;

import java.util.HashMap;
import gnu.io.CommPortIdentifier;

public class SerialPortSetupModel {
    
    private HashMap portMap;
    private CommPortIdentifier selectedSerialPort = null;

    public SerialPortSetupModel() {
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
