package controllers;

import models.BraketestModel;
import views.BraketestPanel;

public class BraketestController {
    
    //upper controller
    private NavigationController upperController;
    
    //MVC
    private BraketestModel model;
    private BraketestPanel view;
    
    //Commands
    
    
    //Builders
    
    //Constructor
    
    public BraketestController(NavigationController upperController) {
        this.upperController = upperController;
                model = new BraketestModel();
        view = new BraketestPanel(this);
        
        
        addListeners();
    }

    
    public void addListeners(){
        
    }

    public BraketestModel getModel() {
        return model;
    }

    public BraketestPanel getView() {
        return view;
    }
    
    
}
