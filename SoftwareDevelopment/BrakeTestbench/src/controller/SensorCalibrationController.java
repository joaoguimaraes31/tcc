package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Sensor;
import models.SensorCalibrationModel;
import views.SensorCalibrationView;

public class SensorCalibrationController {

    SensorCalibrationView view = new SensorCalibrationView();
    SensorCalibrationModel model = new SensorCalibrationModel();
    private ActionListener actionListener;
    private ActionListener actionListener1;
    private ActionListener actionListener2;
    Sensor sensor = null;
    
    public SensorCalibrationController(SensorCalibrationView view, SensorCalibrationModel model) {
        this.view=view;
        this.model=model;
    }
    
    public void control(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  updateModel();
              }
        };                
        view.getSetBT().addActionListener(actionListener);   
    }
    
    
}


/*

    public void contol(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  updateModel();
              }
        };                
        view.getSetBT().addActionListener(actionListener);   
    }
*/
