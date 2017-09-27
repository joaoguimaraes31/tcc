package builders;

import controllers.*;

public class CalibrationControllerBuilder {

    //Upper controller
    NavigationController navigationController;

    //Object
    CalibrationController calibrationController;

    public CalibrationControllerBuilder(NavigationController navigationController) {
        this.navigationController = navigationController;

        //Creating CalibrationController Instance
        calibrationController = new CalibrationController(navigationController);
    }

    public CalibrationController getCalibrationController() {
        return calibrationController;
    }

}
