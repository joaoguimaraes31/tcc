package controllers;

import builders.FileFunctionsCalibrationBuilder;
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
    private FileFunctions fileFunctions;
    
    //Builders
    private FileFunctionsCalibrationBuilder builder;

    //ActionListeners
    private ActionListener aLstart, aLstop, aLupdate;

    //Constructor
    public CalibrationController(NavigationController navigationController) {
        this.navigationController = navigationController;
        //view = navigationController.getView().getCalibrationPanel();
        model = new CalibrationModel();
        view= new CalibrationPanel(this);
        voltageChartOp = new ChartOperations("Voltage Reading", "Time (ms)", "Voltage", 400, 220, view.getVoltageChartLabel());
        measurementChartOp = new ChartOperations("Measured Value", "Time (s)", "Measurement", 400, 220, view.getMeasurementChartLabel());

        communicator = new CalibrationCommunicator(navigationController.getModel().getSelectedSerialPort(), this, voltageChartOp, measurementChartOp);
        builder = new FileFunctionsCalibrationBuilder(this);
        fileFunctions=builder.getFileFunctions();
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
                    //navigation controller view
                    navigationController.getView().getMenuItemOpenCalibrationFile().setEnabled(false);
                    navigationController.getView().getMenuItemSaveCalibrationFile().setEnabled(false);

                    //geting calibration data from model
                    model.getCurrentCalibration()[0] = Float.parseFloat(model.getSensorValues()[2][view.getSensorComboBox().getSelectedIndex()]);
                    model.getCurrentCalibration()[1] = Float.parseFloat(model.getSensorValues()[3][view.getSensorComboBox().getSelectedIndex()]);

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
                //navigation controller view
                navigationController.getView().getMenuItemOpenCalibrationFile().setEnabled(true);
                navigationController.getView().getMenuItemSaveCalibrationFile().setEnabled(true);

                //LED response
                LedBlinker ledBlinker = new LedBlinker(communicator);
                ledBlinker.Blink(150, 150, 1);

                //set calibration data to model
                model.getSensorValues()[2][view.getSensorComboBox().getSelectedIndex()] = String.valueOf(model.getCurrentCalibration()[0]);
                model.getSensorValues()[3][view.getSensorComboBox().getSelectedIndex()] = String.valueOf(model.getCurrentCalibration()[1]);

                //disconnect and stop "hearing" microcontroller
                communicator.disconnect();
            }
        };
        view.getStopButton().addActionListener(aLstop);

        aLupdate = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //set calibration data to model
                model.getCurrentCalibration()[0] = Float.parseFloat(view.getFactorSpinner().getValue().toString());
                model.getCurrentCalibration()[1] = Float.parseFloat(view.getOffsetSpinner().getValue().toString());

            }
        };
        view.getUpdateButton().addActionListener(aLupdate);
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

    public FileFunctions getFileFunctions() {
        return fileFunctions;
    }
}
