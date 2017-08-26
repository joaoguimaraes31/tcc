package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gnu.io.CommPortIdentifier;
import java.util.HashMap;

import commands.*;
import models.*;
import views.*;

public class SerialPortSetupController {

    //upper controller
    private NavigationController navigationController;

    //MVC
    private SerialPortsSetupModel model;
    private SerialPortSetupView view;
    private SerialPortSetupCommand command;
    private ActionListener actionListenerReturnBT, actionListenerSearchBT,
            actionListenerPortsCB, actionListenerSetBT, actionListenerSensorSetupBT;

    //constructor
    public SerialPortSetupController() {
        model = new SerialPortsSetupModel();
        command = new SerialPortSetupCommand();
    }

    //CRIAR TELA INICIAL E ADCIONAR EVENTOS
    public void createView() {
        view = new SerialPortSetupView();
        command.fillComboBoxWithPortNames(view, model.getPortMap());

        if (navigationController.getModel().isIsSerialPortSet()) {
            view.getSelectedPortLB().setText(model.getSelectedSerialPort());
            view.getSensorSetupBT().setEnabled(true);
        } else {
            view.getSelectedPortLB().setText("none");
            view.getSensorSetupBT().setEnabled(false);
        }

        view.setVisible(true);
        addListeners();
    }

    //addListeners for controlling view and triggers events
    public void addListeners() {
        actionListenerReturnBT = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                view.dispose();
                navigationController.getInitialScreenController().createView(model.getSelectedSerialPort());
            }
        };
        view.getReturnBT().addActionListener(actionListenerReturnBT);

        actionListenerSearchBT = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                command.searchForPorts();
                model.setPortMap(command.getPortMap());
                //function to control view
                command.fillComboBoxWithPortNames(view, model.getPortMap());
                if (model.getPortMap().isEmpty()) {
                    view.getSetBT().setEnabled(false);
                    view.getSensorSetupBT().setEnabled(false);
                    navigationController.getModel().setIsSerialPortSet(false);
                    model.setSelectedSerialPort("none");
                    view.getSelectedPortLB().setText(model.getSelectedSerialPort());
                }
            }
        };
        view.getSearchBT().addActionListener(actionListenerSearchBT);

        actionListenerPortsCB = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                view.getSetBT().setEnabled(true);    
            }
        };
        view.getPortsCB().addActionListener(actionListenerPortsCB);

        actionListenerSetBT = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.setSelectedSerialPort(view.getPortsCB().getSelectedItem().toString());
                navigationController.getModel().setIsSerialPortSet(true);
                view.getSelectedPortLB().setText(model.getSelectedSerialPort());
                view.getSetBT().setEnabled(false);
                view.getSensorSetupBT().setEnabled(true);
            }
        };
        view.getSetBT().addActionListener(actionListenerSetBT);

        actionListenerSensorSetupBT = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                view.dispose();
                navigationController.getSensorSetupController().createView();
            }
        };
        view.getSensorSetupBT().addActionListener(actionListenerSensorSetupBT);
    }

    //getters and setters
    public SerialPortsSetupModel getModel() {
        return model;
    }

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }
}
