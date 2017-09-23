package models;

public class NavigationModel {
    
    //Parameters
    private boolean isSerialPortSet = false;

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
    
    
}
/*
//enum type to define current screen
    private ScreenPossibilities currentScreen;
    public enum ScreenPossibilities {
        INITIAL, SERIAL_SETUP, CALIBRATION
    }
    
    

    
  
    //getters and setters;
    public ScreenPossibilities getCurrentScreen() {
        return currentScreen;
    }
    public void setCurrentScreen(ScreenPossibilities currentScreen) {
        this.currentScreen = currentScreen;
    }

    public boolean isIsSerialPortSet() {
        return isSerialPortSet;
    }

    public void setIsSerialPortSet(boolean isSerialPortSet) {
        this.isSerialPortSet = isSerialPortSet;
    }
    
    
    
}*/
