package builders;

import controllers.*;

public class SerialPortSetupBuilder {
    
    NavigationController navigationController;
    SerialPortSetupController serialPortSetupController;
    
    public void createSubsystem(NavigationController navigationController){
        
        this.navigationController=navigationController;
        
        serialPortSetupController =  new SerialPortSetupController();
        
        serialPortSetupController.setNavigationController(navigationController);
        
    }

    public SerialPortSetupController getSerialPortSetupController() {
        return serialPortSetupController;
    }
    
}
