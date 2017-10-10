package models;

public class NavigationModel {
        
    //enum type to define current screen
    private ScreenPossibilities currentScreen;
    public enum ScreenPossibilities {
        INITIAL, SERIAL_SETUP, CALIBRATION
    }
    
    private boolean isSerialPortSet = false;

    public NavigationModel(boolean isSerialPortSet) {
        this.isSerialPortSet = isSerialPortSet;
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
    
    
    
}
