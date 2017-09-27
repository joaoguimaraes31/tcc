package builders;

import controllers.*;

public class SerialPortSetupControllerBuilder {

    //Upper controller
    NavigationController navigationController;

    //Object instance
    SerialPortSetupController serialPortSetupController;

    public SerialPortSetupControllerBuilder(NavigationController navigationController) {
        this.navigationController = navigationController;
        
        //Creating SerialPortSetupController instance with view reference
        serialPortSetupController = new SerialPortSetupController(navigationController);
    }

    //Getter
    public SerialPortSetupController getSerialPortSetupController() {
        return serialPortSetupController;
    }

}
