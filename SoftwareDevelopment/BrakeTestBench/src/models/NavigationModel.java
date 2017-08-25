package models;

public class NavigationModel {
        
    //enum type to define current screen
    private ScreenPossibilities currentScreen;
    public enum ScreenPossibilities {
        INITIAL, SERIAL_SETUP
    }
    
    private boolean serialPortSetted;

    public NavigationModel(boolean serialPortSetted) {
        this.serialPortSetted = serialPortSetted;
    }
    
    
    
    //getters and setters;
    public ScreenPossibilities getCurrentScreen() {
        return currentScreen;
    }
    public void setCurrentScreen(ScreenPossibilities currentScreen) {
        this.currentScreen = currentScreen;
    }
    public boolean isSerialPortSetted() {
        return serialPortSetted;
    }
    public void setSerialPortSetted(boolean serialPortSetted) {
        this.serialPortSetted = serialPortSetted;
    }
    
    
}
