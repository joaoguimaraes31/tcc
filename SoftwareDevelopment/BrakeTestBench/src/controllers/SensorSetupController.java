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
                
                //fileFunctions.writtingToFileRoutine(model.getHEADER(), model.getValues(),view);
            }
        };
        view.getSaveFileBT().addActionListener(actionListenerSaveBT);
    }
    

    public void acquireFileValues() {
        model.getValues()[0]=view.getSensor0TypeCB().getSelectedItem().toString();
        model.getValues()[1]=view.getSensor0TF().getText();
        
        model.getValues()[4]=view.getSensor0TypeCB().getSelectedItem().toString();
        model.getValues()[5]=view.getSensor0TF().getText();
        
        model.getValues()[8]=view.getSensor0TypeCB().getSelectedItem().toString();
        model.getValues()[9]=view.getSensor0TF().getText();
        
        model.getValues()[10]=view.getSensor0TypeCB().getSelectedItem().toString();
        model.getValues()[11]=view.getSensor0TF().getText();
        
        model.getValues()[14]=view.getSensor0TypeCB().getSelectedItem().toString();
        model.getValues()[15]=view.getSensor0TF().getText();
        
        model.getValues()[18]=view.getSensor0TypeCB().getSelectedItem().toString();
        model.getValues()[19]=view.getSensor0TF().getText();   
    }
}