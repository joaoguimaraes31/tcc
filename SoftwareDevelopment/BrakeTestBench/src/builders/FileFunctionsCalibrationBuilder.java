package builders;

import commands.FileFunctionsCalibration;
import controllers.CalibrationController;

public class FileFunctionsCalibrationBuilder {
    
    FileFunctionsCalibration fileFunctions;
    
    public FileFunctionsCalibrationBuilder(CalibrationController controller) {
        fileFunctions = new FileFunctionsCalibration(controller.getModel());
    }

    public FileFunctionsCalibration getFileFunctions() {
        return fileFunctions;
    } 
}
