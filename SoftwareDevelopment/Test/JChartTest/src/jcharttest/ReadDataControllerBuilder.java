
package jcharttest;

public class ReadDataControllerBuilder {
    NavigationController navigationController;
    ReadDataController readDataController;
    
    public void createSubsystem(NavigationController navigationController){
        
        this.navigationController=navigationController;
        
        readDataController =  new ReadDataController();
        
        readDataController.setNavigationController(navigationController);
        
    }

    public ReadDataController getReadDataController() {
        return readDataController;
    }
}
