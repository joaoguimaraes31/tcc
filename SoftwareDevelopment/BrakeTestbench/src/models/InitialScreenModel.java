package models;



public class InitialScreenModel {

    private String currentScreen = new String();
//        DEFAULT_SCREEN, SENSOR_SETUP_SCREEN,SENSOR_CALIBRATION_SCREEN,SERIAL_PORT_SETUP_SCREEN

    public InitialScreenModel() {
        this.currentScreen = "DEFAULT_SCREEN";
    }
    
    
    
    //getters and setters
    public String getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(String currentScreen) {
        this.currentScreen = currentScreen;
    }
    
}


