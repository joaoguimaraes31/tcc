package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ConfigurationModel;
import views.ConfigurationPanel;

public class ConfigurationController {

    //upper controller
    private NavigationController upperController;

    //MVC
    private ConfigurationModel model;
    private ConfigurationPanel view;

    //Commands
    //Builders
    //ActionListeners
    private ActionListener aLchooseReg, aLDefault, aLchooseOutputDir;

    //Constructor
    public ConfigurationController(NavigationController upperController) {
        this.upperController = upperController;
        model = new ConfigurationModel();
        view = new ConfigurationPanel(this);

        addListeners();
    }

    public void addListeners() {
        aLchooseReg = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //set calibration data to model
                System.out.println("Choose Regulations");
            }
        };
        view.getChooseRegulationButton().addActionListener(aLchooseReg);

        aLDefault = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //set calibration data to model
                System.out.println("Default");
            }
        };
        view.getConfigurationDefaultButton().addActionListener(aLDefault);

        aLchooseOutputDir = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //set calibration data to model
                System.out.println("output dir");
            }
        };
        view.getChooseOutputButton().addActionListener(aLchooseOutputDir);
    }

    public ConfigurationModel getModel() {
        return model;
    }

    public ConfigurationPanel getView() {
        return view;
    }

}
