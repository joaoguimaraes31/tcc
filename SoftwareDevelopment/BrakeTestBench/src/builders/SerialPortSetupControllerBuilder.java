package builders;

import controllers.*;

public class SerialPortSetupControllerBuilder {

    //Controllers
    NavigationController upperController;
    SerialPortSetupController controller;

    public SerialPortSetupControllerBuilder(NavigationController upperController) {
        this.upperController = upperController;
        
        //Creating SerialPortSetupController instance with view reference
        controller = new SerialPortSetupController(upperController);
    }

    //Getter
    public SerialPortSetupController getController() {
        return controller;
    }

}
