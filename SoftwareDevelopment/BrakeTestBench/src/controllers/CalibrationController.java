package controllers;

import commands.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.CalibrationModel;
import views.CalibrationPanel;

public class CalibrationController {

    //upper controller
    private NavigationController navigationController;

    //MVC
    private CalibrationModel model;
    private CalibrationPanel view;

    //Commands
    private CalibrationCommunicator communicator;
    private ChartOperations voltageChartOp, measurementChartOp;

    //ActionListeners
    private ActionListener aLstart, aLstop;

    //Constructor
    public CalibrationController(NavigationController navigationController) {
        this.navigationController = navigationController;
        view = navigationController.getView().getCalibrationPanel();
        view.setController(this);
        model = new CalibrationModel();
        voltageChartOp = new ChartOperations("Voltage Reading", "Time (ms)", "Voltage", 400, 220, view.getVoltageChartLabel());
        measurementChartOp = new ChartOperations("Measured Value", "Time (s)", "Measurement", 400, 220, view.getMeasurementChartLabel());
        
        communicator = new CalibrationCommunicator(navigationController.getModel().getSelectedSerialPort(),this, voltageChartOp, measurementChartOp);
        addListeners();
    }


    public void addListeners() {
        aLstart = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                communicator.setPortId(navigationController.getModel().getSelectedSerialPort());
                //Try to connect
                communicator.connect();
                
                //If sucessful
                if (communicator.isConnected()) {
                    //geting calibration data from model
                    model.getCurrentCalibration()[0] = model.getCalibrationData()[view.getSensorComboBox().getSelectedIndex()][0];
                    model.getCurrentCalibration()[1] = model.getCalibrationData()[view.getSensorComboBox().getSelectedIndex()][1];
                    
                    //LED response
                    LedBlinker ledBlinker = new LedBlinker(communicator);
                    ledBlinker.Blink(150, 150, 2);
                    
                    //starting acquisition and waiting for samples
                    communicator.startAcquisition();
                    communicator.initListener();
                }
            }
        };
        view.getStartButton().addActionListener(aLstart);

        aLstop = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //LED response
                LedBlinker ledBlinker = new LedBlinker(communicator);
                ledBlinker.Blink(150, 150, 1);
                
                //set calibration data to model
                model.getCalibrationData()[view.getSensorComboBox().getSelectedIndex()][0] = model.getCurrentCalibration()[0];
                model.getCalibrationData()[view.getSensorComboBox().getSelectedIndex()][1] = model.getCurrentCalibration()[1];
                
                //disconnect and stop "hearing" microcontroller
                communicator.disconnect();
            }
        };
        view.getStopButton().addActionListener(aLstop);
    }

    public CalibrationModel getModel() {
        return model;
    }

    public CalibrationPanel getView() {
        return view;
    }

    public CalibrationCommunicator getCommunicator() {
        return communicator;
    }

}
