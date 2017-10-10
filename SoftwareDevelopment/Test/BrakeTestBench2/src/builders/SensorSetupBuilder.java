package builders;

import controllers.*;

public class SensorSetupBuilder {
    
    NavigationController navigationController;
    SensorSetupController sensorSetupController;
    
    public void createSubsystem(NavigationController navigationController){
        
        this.navigationController=navigationController;
        
        sensorSetupController =  new SensorSetupController();
        
        sensorSetupController.setNavigationController(navigationController);
        
    }

    public SensorSetupController getSensorSetupController() {
        return sensorSetupController;
    } 
}
