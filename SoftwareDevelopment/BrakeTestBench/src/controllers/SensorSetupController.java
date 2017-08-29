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
    private SensorSetupModel model;
    private SensorSetupView view;
    private ActionListener actionListenerReturnBT, actionListenerserialBT, actionListenerExitBT, actionListenerLoadBT, actionListenerSaveBT;
    
    //commands
    private FileFunctions fileFunctions;

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
                //
            }
        };
        view.getLoadFileBT().addActionListener(actionListenerLoadBT);
        
        actionListenerSaveBT = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //
            }
        };
        view.getSaveFileBT().addActionListener(actionListenerSaveBT);
    }

}
