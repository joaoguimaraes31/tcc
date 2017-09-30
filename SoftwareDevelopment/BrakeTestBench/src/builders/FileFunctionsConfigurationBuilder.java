package builders;

import commands.FileFunctionsConfiguration;
import controllers.ConfigurationController;
import models.ConfigurationModel;

public class FileFunctionsConfigurationBuilder {
    
    private ConfigurationController upperController;
    private FileFunctionsConfiguration controller;

    public FileFunctionsConfigurationBuilder(ConfigurationController upperController) {
        this.upperController = upperController;
        ConfigurationModel model = upperController.getModel();
        controller = new FileFunctionsConfiguration(upperController,model.getCONFIGURATION_FILE_NAME(),model.getFILTER());
    }

    public FileFunctionsConfiguration getController() {
        return controller;
    } 
}
