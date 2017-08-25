package builders;

import controllers.*;

public class CalibrationBuilder {
    
    NavigationController navigationController;
    CalibrationController calibrationController;
    
    public void createSubsystem(NavigationController navigationController){
        
        this.navigationController=navigationController;
        
        calibrationController =  new CalibrationController();
        
        calibrationController.setNavigationController(navigationController);
        
    }

    public CalibrationController getCalibrationController() {
        return calibrationController;
    } 
}
