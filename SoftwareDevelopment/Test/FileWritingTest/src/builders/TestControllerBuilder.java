package builders;

import controllers.NavigationController;
import controllers.TestController;

public class TestControllerBuilder {

    NavigationController navigationController;
    TestController testController;
    
    public void createSubsystem(NavigationController navigationController){
        
        this.navigationController=navigationController;
        
        testController =  new TestController();
        
        testController.setNavigationController(navigationController);
        
    }

    public TestController getTestController() {
        return testController;
    }    
    
}
