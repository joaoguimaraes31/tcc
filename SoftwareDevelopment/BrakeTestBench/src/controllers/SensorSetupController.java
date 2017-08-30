package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.*;
import views.*;
import commands.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;

public class SensorSetupController {

    //upper controller
    private NavigationController navigationController;

    //MVC
    private SensorSetupModel model = new SensorSetupModel();
    private SensorSetupView view;
    private ActionListener actionListenerReturnBT, actionListenerserialBT, actionListenerExitBT, actionListenerLoadBT, actionListenerSaveBT;

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
    }

    public void acquireFileValues() {
        model.getValues()[0] = view.getSensor0TypeCB().getSelectedItem().toString();
        model.getValues()[1] = view.getSensor0TF().getText();
        
        model.getValues()[4] = view.getSensor1TypeCB().getSelectedItem().toString();
        model.getValues()[5] = view.getSensor1TF().getText();
        
        model.getValues()[8] = view.getSensor2TypeCB().getSelectedItem().toString();
        model.getValues()[9] = view.getSensor2TF().getText();
        
        model.getValues()[12] = view.getSensor3TypeCB().getSelectedItem().toString();
        model.getValues()[16] = view.getSensor3TF().getText(); 
        
        model.getValues()[16] = view.getSensor4TypeCB().getSelectedItem().toString();
        model.getValues()[17] = view.getSensor4TF().getText();
        
        model.getValues()[20] = view.getSensor5TypeCB().getSelectedItem().toString();
        model.getValues()[21] = view.getSensor5TF().getText();
    }
}
