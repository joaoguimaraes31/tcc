package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;

public class InitialScreenController {
    
    //upper controller
    private NavigationController navigationController;
    
    //MVC
    private InitialView view;
        //action listeners to control view
        private ActionListener actionListenerSerialSetupBT;

    public InitialScreenController() {
        createView();
    }

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }
    
    
    //CRIAR TELA INICIAL E ADCIONAR EVENTOS
    public void createView(){
		view = new InitialView();
                view.setVisible(true);
                addListeners();
		//System.out.println("deu certo!");
    }
    
    public void addListeners(){        
        actionListenerSerialSetupBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                 view.dispose();
                 navigationController.serialPortSetupController.createView();
                 //model.setCurrentScreen(ScreenPossibilities.SERIAL_SETUP);
              }
        };                
        view.getSerialSetupBT().addActionListener(actionListenerSerialSetupBT);   
    }  
}
