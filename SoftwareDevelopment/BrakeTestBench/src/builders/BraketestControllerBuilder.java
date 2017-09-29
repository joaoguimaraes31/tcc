package builders;

import controllers.BraketestController;
import controllers.NavigationController;

public class BraketestControllerBuilder {
    
    //Controllers
    private NavigationController upperController;
    private BraketestController controller;

    //Constructor
    public BraketestControllerBuilder(NavigationController upperController) {
        this.upperController = upperController;
        controller = new BraketestController(upperController);
    }

    public BraketestController getController() {
        return controller;
    }
}
