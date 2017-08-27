package controller;

import static controller.Main.selectedSerialPort;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Sensor;
import models.SensorCalibrationModel;
import views.SensorCalibrationView;

public class SensorCalibrationController {

    SensorCalibrationView view = new SensorCalibrationView();
    SensorCalibrationModel model = new SensorCalibrationModel();
    SerialEventHandler serialEventHandler =  new SerialEventHandler();
    
    private ActionListener actionListenerPortsCB;
    private ActionListener actionListenerResetBT;
    private ActionListener actionListenerSetEnable;
    private ActionListener actionListenerSetBT;
    private ActionListener actionListenerStartBT;
    private ActionListener actionListenerStopBT;
    
    Sensor sensor = null;
    
    public SensorCalibrationController(SensorCalibrationView view, SensorCalibrationModel model) {
        this.view=view;
        this.model=model;
        updateView();
    }
    
    public void control(){
        //PORTSselection
        actionListenerPortsCB = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  updateView();
              }
        };                
        view.getChannelCB().addActionListener(actionListenerPortsCB);  
        
        //ResetFunction
        actionListenerResetBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {
                  //view
                  view.getCalibrationOffsetTF().setText("0");
                  view.getConversionFactorTF().setText("1");
                  view.getSetBT().setEnabled(false);
                  
                  //sensorList
                  Main.sensorList[view.getChannelCB().getSelectedIndex()].setCalibrationOffset(0);
                  Main.sensorList[view.getChannelCB().getSelectedIndex()].setConversionFactor(1);
                  
              }
        };                
        view.getResetBT().addActionListener(actionListenerResetBT);  
        
        //SetEnable
        actionListenerSetEnable = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  view.getSetBT().setEnabled(true);
              }
        };                
        view.getCalibrationOffsetTF().addActionListener(actionListenerSetEnable);
        view.getConversionFactorTF().addActionListener(actionListenerSetEnable);
        
        //SetFunction
        actionListenerSetBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  //sensorList
                  Main.sensorList[view.getChannelCB().getSelectedIndex()].setCalibrationOffset(Float.valueOf(view.getCalibrationOffsetTF().getText()));
                  Main.sensorList[view.getChannelCB().getSelectedIndex()].setConversionFactor(Float.valueOf(view.getConversionFactorTF().getText()));
                  view.getSetBT().setEnabled(false);
              }
        };                
        view.getSetBT().addActionListener(actionListenerSetBT);
    
    
        //StartFunction
        actionListenerStartBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  //view
                  view.getSetBT().setEnabled(false);
                  view.getResetBT().setEnabled(false);
                  view.getStartBT().setEnabled(false);
                  view.getConversionFactorTF().setEnabled(false);
                  view.getCalibrationOffsetTF().setEnabled(false);
                  view.getStopBT().setEnabled(true);
                  
                  //data_acquisition
                  serialEventHandler.serialFacade.connect(selectedSerialPort);
                  serialEventHandler.initListener(serialEventHandler.serialFacade.getSerialPort());
                 
                  
              }
        };                
        view.getStartBT().addActionListener(actionListenerStartBT);
    
        //StopFunction
        actionListenerStopBT = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  //view
                  view.getResetBT().setEnabled(true);
                  view.getStartBT().setEnabled(true);
                  view.getConversionFactorTF().setEnabled(true);
                  view.getCalibrationOffsetTF().setEnabled(true);
                  view.getStopBT().setEnabled(false);
                  
                  //data_acquisition
                  serialEventHandler.removeListener(serialEventHandler.serialFacade.getSerialPort());
                  serialEventHandler.serialFacade.disconnect();
              }
        };                
        view.getStartBT().addActionListener(actionListenerStopBT);
    
    }
    
        
    
    public void updateView(){
        int k = view.getChannelCB().getSelectedIndex();
        view.getCalibrationOffsetTF().setText(Float.toString(Main.sensorList[k].getCalibrationOffset()));
        view.getConversionFactorTF().setText(Float.toString(Main.sensorList[k].getConversionFactor()));
        view.getUnityOfMeasurementLB().setText(Main.sensorList[k].getUnityOfMeasurement());
    }
       
}
