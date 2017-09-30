package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    private ActionListener aLchooseReg, aLDefault, aLchooseOutputDir, aLset;

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
                boolean differ = false;
                if (Integer.parseInt(view.getNumberOfCyclesSpinner().getValue().toString()) != model.getSPINNERS_DEFAULT_VALUE()[0]) {
                    differ = true;
                }
                if (Integer.parseInt(view.getCyclesTimeSpinner().getValue().toString()) != model.getSPINNERS_DEFAULT_VALUE()[1]) {
                    differ = true;
                }
                if (Integer.parseInt(view.getUpperLimitSpinner().getValue().toString()) != model.getSPINNERS_DEFAULT_VALUE()[2]) {
                    differ = true;
                }
                if (Integer.parseInt(view.getWaitUpperTimeSpinner().getValue().toString()) != model.getSPINNERS_DEFAULT_VALUE()[3]) {
                    differ = true;
                }
                if (Integer.parseInt(view.getLowerLimitSpinner().getValue().toString()) != model.getSPINNERS_DEFAULT_VALUE()[4]) {
                    differ = true;
                }
                if (Integer.parseInt(view.getWaitUpperTimeSpinner().getValue().toString()) != model.getSPINNERS_DEFAULT_VALUE()[5]) {
                    differ = true;
                }

                view.getNumberOfCyclesSpinner().setValue(model.getSPINNERS_DEFAULT_VALUE()[0]);
                view.getCyclesTimeSpinner().setValue(model.getSPINNERS_DEFAULT_VALUE()[1]);
                view.getUpperLimitSpinner().setValue(model.getSPINNERS_DEFAULT_VALUE()[2]);
                view.getWaitUpperTimeSpinner().setValue(model.getSPINNERS_DEFAULT_VALUE()[3]);
                view.getLowerLimitSpinner().setValue(model.getSPINNERS_DEFAULT_VALUE()[4]);
                view.getWaitLowerTimeSpinner().setValue(model.getSPINNERS_DEFAULT_VALUE()[5]);

                if (differ) {
                    JFrame frame = null;
                    JOptionPane.showMessageDialog(frame, "Test configuration values set to default!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                }
                view.getConfigurationFileLabel().setText("default");
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

        aLset = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //set calibration data to model
                System.out.println("set");
            }
        };
        view.getSetButton().addActionListener(aLset);
    }

    public ConfigurationModel getModel() {
        return model;
    }

    public ConfigurationPanel getView() {
        return view;
    }

}
