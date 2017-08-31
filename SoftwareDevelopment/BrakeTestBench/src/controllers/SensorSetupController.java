package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.*;
import views.*;
import commands.*;

public class SensorSetupController {

    //upper controller
    private NavigationController navigationController;

    //MVC
    private SensorSetupModel model = new SensorSetupModel();
    private SensorSetupView view;
    private ActionListener actionListenerReturnBT, actionListenerserialBT, actionListenerExitBT, actionListenerLoadBT, actionListenerSaveBT,
            actionListenerSetValues;

    //commands
    FileFunctions fileFunctions = new FileFunctions();

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    //CRIAR TELA INICIAL E ADCIONAR EVENTOS
    public void createView() {
        view = new SensorSetupView();
        view.setVisible(true);
        addListeners();

    }

    //addListeners for controlling view and triggers events
    public void addListeners() {
        actionListenerReturnBT = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                view.dispose();
                navigationController.getInitialScreenController().createView(navigationController.getSerialPortSetupController().getModel().getSelectedSerialPort());
            }
        };
        view.getReturnBT().addActionListener(actionListenerReturnBT);

        actionListenerserialBT = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                view.dispose();
                navigationController.getSerialPortSetupController().createView();
            }
        };
        view.getSerialBT().addActionListener(actionListenerserialBT);

        actionListenerExitBT = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        };
        view.getExitBT().addActionListener(actionListenerExitBT);

        actionListenerLoadBT = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

            }
        };
        view.getLoadFileBT().addActionListener(actionListenerLoadBT);

        actionListenerSaveBT = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                acquireFileValues();
                fileFunctions.writtingToFileRoutine(model.getHEADER(), model.getValues());
            }
        };
        view.getSaveFileBT().addActionListener(actionListenerSaveBT);

        actionListenerSetValues = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                acquireFileValues();
                 acquireFileValues();
                if (view.getChannelsCB().getSelectedIndex() == 0) {
                    view.getStartCalibrationBT().setEnabled(false);
                    view.getSensorTypeLB().setText("Sensor Type: none");
                    view.getSensorLabelLB().setText("Sensor Label: none");
                } else {
                    view.getSensorTypeLB().setText("Sensor Type: " + model.getValues()[(view.getChannelsCB().getSelectedIndex() - 1) * 4]);
                    view.getSensorLabelLB().setText("Sensor Label: " + model.getValues()[((view.getChannelsCB().getSelectedIndex() - 1) * 4) + 1]);
                    
                    if (model.getValues()[(view.getChannelsCB().getSelectedIndex() - 1) * 4].equals("Not Connected")){
                        view.getStartCalibrationBT().setEnabled(true);
                    }else{
                        view.getStartCalibrationBT().setEnabled(false);
                    }
                }
            }
        };
        view.getSensor0TypeCB().addActionListener(actionListenerSetValues);
        view.getSensor0TF().addActionListener(actionListenerSetValues);
        view.getSensor1TypeCB().addActionListener(actionListenerSetValues);
        view.getSensor1TF().addActionListener(actionListenerSetValues);
        view.getSensor2TypeCB().addActionListener(actionListenerSetValues);
        view.getSensor2TF().addActionListener(actionListenerSetValues);
        view.getSensor3TypeCB().addActionListener(actionListenerSetValues);
        view.getSensor3TF().addActionListener(actionListenerSetValues);
        view.getSensor4TypeCB().addActionListener(actionListenerSetValues);
        view.getSensor4TF().addActionListener(actionListenerSetValues);
        view.getSensor5TypeCB().addActionListener(actionListenerSetValues);
        view.getSensor5TF().addActionListener(actionListenerSetValues);
        view.getChannelsCB().addActionListener(actionListenerSetValues);

    }

    public void acquireFileValues() {
        model.getValues()[0] = view.getSensor0TypeCB().getSelectedItem().toString();
        String str = "(optional)";
        String result = "NULL";
        
        if (view.getSensor0TF().getText().equals(str)){
            model.getValues()[1]=result;
        }else{
            model.getValues()[1]=view.getSensor0TF().getText();
        }
        

        model.getValues()[4] = view.getSensor1TypeCB().getSelectedItem().toString();
        
        if (view.getSensor1TF().getText().equals(str)){
            model.getValues()[5]=result;
        }else{
            model.getValues()[5]=view.getSensor1TF().getText();
        }
        

        model.getValues()[8] = view.getSensor2TypeCB().getSelectedItem().toString();
        
        if (view.getSensor2TF().getText().equals(str)){
            model.getValues()[9]=result;
        }else{
            model.getValues()[9]=view.getSensor2TF().getText();
        }

        model.getValues()[12] = view.getSensor3TypeCB().getSelectedItem().toString();
        if (view.getSensor3TF().getText().equals(str)){
            model.getValues()[13]=result;
        }else{
            model.getValues()[13]=view.getSensor3TF().getText();
        }

        model.getValues()[16] = view.getSensor4TypeCB().getSelectedItem().toString();
        if (view.getSensor4TF().getText().equals(str)){
            model.getValues()[17]=result;
        }else{
            model.getValues()[17]=view.getSensor4TF().getText();
        }

        model.getValues()[20] = view.getSensor5TypeCB().getSelectedItem().toString();
        if (view.getSensor5TF().getText().equals(str)){
            model.getValues()[21]=result;
        }else{
            model.getValues()[21]=view.getSensor5TF().getText();
        }
    }
}
