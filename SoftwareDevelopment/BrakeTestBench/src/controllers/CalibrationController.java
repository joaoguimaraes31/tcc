package controllers;

import builders.FileFunctionsCalibrationBuilder;
import commands.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    private FileFunctionsCalibrationBuilder fileFunctionsCalibrationBuilder;

    //ActionListeners
    private ActionListener aLstart, aLstop, aLupdate, aLReset,aL;

    //Constructor
    public CalibrationController(NavigationController navigationController) {
        this.navigationController = navigationController;
        model = new CalibrationModel();
        view = new CalibrationPanel(this);
        voltageChartOp = new ChartOperations("Voltage Reading", "Time (ms)", "Voltage", 380, 220, view.getVoltageChartLabel());
        measurementChartOp = new ChartOperations("Measured Value", "Time (s)", "Measurement", 380, 220, view.getMeasurementChartLabel());

        communicator = new CalibrationCommunicator(navigationController.getModel().getSelectedSerialPort(), this, voltageChartOp, measurementChartOp);
        fileFunctionsCalibrationBuilder = new FileFunctionsCalibrationBuilder(this);
        fileFunctions = fileFunctionsCalibrationBuilder.getController();
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
                    navigationController.getView().getMenuBar().get.setEnabled(false);
                    navigationController.getView().getMenuItemSaveCalibrationFile().setEnabled(false);

                    //geting calibration data from model
                    model.getCurrentCalibration()[0] = model.getCalibrationValues()[0][view.getSensorComboBox().getSelectedIndex()];
                    model.getCurrentCalibration()[1] = model.getCalibrationValues()[1][view.getSensorComboBox().getSelectedIndex()];
                    model.setPreviousCalibration(model.getCurrentCalibration());

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

                //disconnect and stop "hearing" microcontroller
                communicator.disconnect();
                checkIfPreviousCalibration();

                //set calibration data to model
                model.getCalibrationValues()[0][view.getSensorComboBox().getSelectedIndex()] = model.getCurrentCalibration()[0];
                model.getCalibrationValues()[1][view.getSensorComboBox().getSelectedIndex()] = model.getCurrentCalibration()[1];

            }
        };
        view.getStopButton().addActionListener(aLstop);

        aLupdate = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //set calibration data to model
                float calibration[] = {Float.parseFloat(view.getFactorSpinner().getValue().toString()), Float.parseFloat(view.getOffsetSpinner().getValue().toString())};
                model.setCurrentCalibration(calibration);

            }
        };
        view.getUpdateButton().addActionListener(aLupdate);

        aLReset = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                resetCalibrationValues();
            }
        };
        view.getResetButton().addActionListener(aLReset);
    }

    public void resetCalibrationValues() {
        model.setSettingsLoadded(false);
        view.getLoadedSettingLabel().setText("default");
        float values[] = {1, 0};
        boolean differ = false;

        for (int i = 0; i < model.getCalibrationValues().length; i++) {
            for (int j = 0; j < model.getCalibrationValues()[0].length; j++) {
                if (values[i] != model.getCalibrationValues()[i][j]) {
                    differ = true;
                }
            }
        }

        view.getFactorSpinner().setValue(values[0]);
        view.getOffsetSpinner().setValue(values[1]);
        model.setCurrentCalibration(values);
        model.setPreviousCalibration(values);

        if (differ) {

            for (int i = 0; i < model.getCalibrationValues().length; i++) {
                for (int j = 0; j < model.getCalibrationValues()[0].length; j++) {
                    model.getCalibrationValues()[i][j] = values[i];
                }
            }
            JFrame frame = null;
            JOptionPane.showMessageDialog(frame, "Calibration values reset to default", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void checkIfPreviousCalibration() {
        JFrame frame = null;

        if (model.getCurrentCalibration() != model.getPreviousCalibration()) {
            Object[] options = {"Yes",
                "No"};
            int n = JOptionPane.showOptionDialog(frame,
                    "Calibration values differ from the previous ones, are you sure you want to change them?",
                    "Calibration different settings",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);

            if (n == 1) {
                model.setCurrentCalibration(model.getPreviousCalibration());
                view.getFactorSpinner().setValue(model.getCurrentCalibration()[0]);
                view.getOffsetSpinner().setValue(model.getCurrentCalibration()[1]);
            } else {
                model.setPreviousCalibration(model.getCurrentCalibration());
            }
        }
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
