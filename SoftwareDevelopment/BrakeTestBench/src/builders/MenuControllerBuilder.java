package builders;

import controllers.MenuController;
import controllers.NavigationController;

public class MenuControllerBuilder {
    //Controllers
    private NavigationController upperController;
    private MenuController controller;

    public MenuControllerBuilder(NavigationController upperController) {
        this.upperController = upperController;
        controller = new MenuController(upperController);
    }

    public MenuController getController() {
        return controller;
    }
}
