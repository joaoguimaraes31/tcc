package builders;

import controllers.*;

public class InitialScreenBuilder {
    
    NavigationController navigationController;
    InitialScreenController initialScreenController;
    
    public void createSubsystem(NavigationController navigationController){
        
        this.navigationController=navigationController;
        
        initialScreenController =  new InitialScreenController();
        
        initialScreenController.setNavigationController(navigationController);
        
    }

    public InitialScreenController getInitialScreenController() {
        return initialScreenController;
    }
    
    
    
}
