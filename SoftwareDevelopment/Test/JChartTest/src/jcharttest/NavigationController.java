package jcharttest;

public class NavigationController {
    
    private ReadDataControllerBuilder readDataControllerBuilder;
    private ReadDataController readDataController;

    public NavigationController() {
        //create subsystem
        readDataControllerBuilder = new ReadDataControllerBuilder();
        readDataControllerBuilder.createSubsystem(this);
        readDataController = readDataControllerBuilder.getReadDataController();
    }
    
    
}
