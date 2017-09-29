package controllers;

import models.ConfigurationModel;
import views.ConfigurationPanel;

public class ConfigurationController {
    
    //upper controller
    private NavigationController upperController;
    
    //MVC
    private ConfigurationModel model;
    private ConfigurationPanel view;
    
    //Commands
    
    
    //Builders
    
    //Constructor
    public ConfigurationController(NavigationController upperController) {
        this.upperController = upperController;
        model = new ConfigurationModel();
        view = new ConfigurationPanel(this);
        
        
        addListeners();
    }
    
    public void addListeners(){
        
    }

    public ConfigurationModel getModel() {
        return model;
    }

    public ConfigurationPanel getView() {
        return view;
    }
    
    
    
    
}
