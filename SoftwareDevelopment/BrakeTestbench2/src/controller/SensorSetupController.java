package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Sensor;
import models.SensorSetupModel;
import views.SensorSetupView;

public class SensorSetupController {
    
    SensorSetupView view = new SensorSetupView();
    SensorSetupModel model = new SensorSetupModel();
    private ActionListener actionListener;
    
    public SensorSetupController(SensorSetupView view, SensorSetupModel model) {
        this.view = view;
        this.model = model;
    }
    
    public void control(){        
        view.setVisible(true);
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  updateModel();
              }
        };                
        view.getSetBT().addActionListener(actionListener);   
    }
    
    public void updateModel(){
        //SensorsType
        String[] analogChannelsSensorsTypes = view.getAnalogChannelsSensorsTypes();
        String[] sensorsModels = view.getSensorsModels();
        
        for(int i=0;i<6;i++){
            Main.sensorList[i]=model.sensorInstances(analogChannelsSensorsTypes[i], i, sensorsModels[i]);                    
        }
    }
}
