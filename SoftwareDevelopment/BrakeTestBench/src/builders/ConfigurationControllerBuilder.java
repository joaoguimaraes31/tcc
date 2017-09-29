package builders;

import controllers.NavigationController;
import controllers.ConfigurationController;

public class ConfigurationControllerBuilder {
    
    //Controllers
    private NavigationController upperController;
    private ConfigurationController controller;
    
    //Constructor
    public ConfigurationControllerBuilder(NavigationController upperController) {
        this.upperController = upperController;
        
        //Create controller instance
        controller = new ConfigurationController(upperController);
    }

    public ConfigurationController getController() {
        return controller;
    }
}
