package models;

import gnu.io.CommPortIdentifier;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NavigationModel {
    
    //Parameters
    private boolean isSerialPortSet = false;
    private CommPortIdentifier selectedSerialPort=null;
    private final Path DEFAULT_PATH = Paths.get("");
    private final String DEFAULT_DIR = System.getProperty("user.dir");

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

    public Path getDEFAULT_PATH() {
        return DEFAULT_PATH;
    }

    public String getDEFAULT_DIR() {
        return DEFAULT_DIR;
    }
    
    
    
}
