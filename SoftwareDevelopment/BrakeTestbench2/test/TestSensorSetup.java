
import controller.SensorSetupController;
import models.SensorSetupModel;
import views.SensorSetupView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class TestSensorSetup {
    
    
 public static void main(String args[]) {
      SensorSetupView sensorSetupView = new SensorSetupView();
    SensorSetupModel sensorSetupModel = new SensorSetupModel();
    SensorSetupController sensorSetupController =  new SensorSetupController(sensorSetupView,sensorSetupModel);
     sensorSetupController.control();
     
 }   
}
