package controllers;

//import models.*;

import builders.TestControllerBuilder;

//import views.*;


public class NavigationController {
    
    private TestControllerBuilder testControllerBuilder;
    
    private TestController testController;

    public NavigationController() {
        
        testControllerBuilder = new TestControllerBuilder();
        testControllerBuilder.createSubsystem(this);
        testController = testControllerBuilder.getTestController();
        
        testController.createView();
    }
}
