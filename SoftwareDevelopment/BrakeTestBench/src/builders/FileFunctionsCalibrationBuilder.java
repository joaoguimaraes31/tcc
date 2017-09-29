package builders;

import commands.FileFunctionsCalibration;
import controllers.CalibrationController;

public class FileFunctionsCalibrationBuilder {
    
    private CalibrationController upperController;
    private FileFunctionsCalibration controller;
    
    public FileFunctionsCalibrationBuilder(CalibrationController upperController) {
        this.upperController=upperController;
        
        controller = new FileFunctionsCalibration(upperController);
        
    }

    public FileFunctionsCalibration getController() {
        return controller;
    } 
}