package controllers;

import commands.SerialPortSetupCommand;
import gnu.io.CommPortIdentifier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.SerialPortSetupModel;
import views.SerialPortSetupPanel;

public class SerialPortSetupController {

    //upper controller
    private NavigationController navigationController;

    //PARAMETERS
    //MVC
    private SerialPortSetupModel model;
    private SerialPortSetupPanel view;
    private SerialPortSetupCommand command;

    //ActionListeners
    private ActionListener aLsearch, aLset;

    //Constructor
    public SerialPortSetupController(NavigationController navigationController) {
        this.navigationController = navigationController;
        //view = navigationController.getView().getSerialPortSetupPanel();
        model = new SerialPortSetupModel();
        view = new SerialPortSetupPanel(this);
        
        command = new SerialPortSetupCommand();

        controlView();
    }

    public void controlView() {
        command.fillComboBoxWithPortNames(view.getPortsCB(), model.getPortMap());
        if (navigationController.getModel().isIsSerialPortSet()) {
            view.getSelectedPortLabel().setText(model.getSelectedSerialPort().getName());
            view.getSetButton().setEnabled(true);
        } else {
            view.getSelectedPortLabel().setText("none");
            view.getSetButton().setEnabled(false);
            navigationController.getModel().setSelectedSerialPort(null);
        }
        addListeners();
    }

    //addListeners for controlling view and triggers events
    public void addListeners() {

        aLsearch = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                command.searchForPorts();
                model.setPortMap(command.getPortMap());
                //function to control view
                command.fillComboBoxWithPortNames(view.getPortsCB(), model.getPortMap());
                if (model.getPortMap().isEmpty()) {
                    view.getSetButton().setEnabled(false);
                    navigationController.getModel().setIsSerialPortSet(false);                      
                    model.setSelectedSerialPort(null);
                    navigationController.getModel().setSelectedSerialPort(model.getSelectedSerialPort());
                    view.getSelectedPortLabel().setText("none");
                }
            }
        };
        view.getSearchButton().addActionListener(aLsearch);

        aLset = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.setSelectedSerialPort((CommPortIdentifier) model.getPortMap().get(view.getPortsCB().getSelectedItem().toString()));
                navigationController.getModel().setIsSerialPortSet(true);
                navigationController.getModel().setSelectedSerialPort(model.getSelectedSerialPort());
                view.getSelectedPortLabel().setText(model.getSelectedSerialPort().getName());
                view.getSetButton().setEnabled(false);
            }
        };
        view.getSetButton().addActionListener(aLset);
    }

    public SerialPortSetupPanel getView() {
        return view;
    }
}
