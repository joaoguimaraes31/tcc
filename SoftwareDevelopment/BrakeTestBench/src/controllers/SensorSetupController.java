package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;

public class SensorSetupController {
    
    //upper controller
    private NavigationController navigationController;
    
    //MVC
    private SensorSetupView view;
    //private ActionListener actionListenerReturnBT;
    
    public SensorSetupController() {
        createView();        
    }
    
    public void setNavigationController(NavigationController navigationController){
        this.navigationController=navigationController;
    }
    
    
    //CRIAR TELA INICIAL E ADCIONAR EVENTOS
    public void createView(){
		view = new SensorSetupView();
                view.setVisible(true);
                //addListeners();
		//System.out.println("deu certo!");
    }
    /*
    
    //addListeners for controlling view and triggers events
    public void addListeners(){        
        actionListenerReturnBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                 view.dispose();
                 navigationController.createView();
                 navigationController.addListeners();
              }
        };                
        view.getReturnBT().addActionListener(actionListenerReturnBT);   
    }   
*/
}