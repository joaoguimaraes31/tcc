package builders;

import controllers.*;

public class CalibrationControllerBuilder {

    //Controllers
    private NavigationController upperController;
    private CalibrationController controller;

    public CalibrationControllerBuilder(NavigationController upperController) {
        this.upperController = upperController;
        controller = new CalibrationController(upperController);
    }

    public CalibrationController getController() {
        return controller;
    }

}
