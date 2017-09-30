package controllers;

import builders.FileFunctionsConfigurationBuilder;
import commands.FileFunctionsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
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
    private FileFunctionsConfiguration fileFunctions;

    //Builders
    private FileFunctionsConfigurationBuilder builder;

    //ActionListeners
    private ActionListener aLchooseReg, aLDefault, aLchooseOutputDir, aLdefaultDir;

    //Constructor
    public ConfigurationController(NavigationController upperController) {
        this.upperController = upperController;
        model = new ConfigurationModel();
        view = new ConfigurationPanel(this);

        builder = new FileFunctionsConfigurationBuilder(this);
        fileFunctions = builder.getController();
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
                if (Integer.parseInt(view.getNumberOfCyclesSpinner().getValue().toString()) != model.getSP_DEF()[0]) {
                    differ = true;
                }
                if (Integer.parseInt(view.getCyclesTimeSpinner().getValue().toString()) != model.getSP_DEF()[1]) {
                    differ = true;
                }
                if (Integer.parseInt(view.getUpperLimitSpinner().getValue().toString()) != model.getSP_DEF()[2]) {
                    differ = true;
                }
                if (Integer.parseInt(view.getWaitUpperTimeSpinner().getValue().toString()) != model.getSP_DEF()[3]) {
                    differ = true;
                }
                if (Integer.parseInt(view.getLowerLimitSpinner().getValue().toString()) != model.getSP_DEF()[4]) {
                    differ = true;
                }
                if (Integer.parseInt(view.getWaitUpperTimeSpinner().getValue().toString()) != model.getSP_DEF()[5]) {
                    differ = true;
                }

                resetValuesInView();
                updateValuesFromView();

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
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Select Output files Directory");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    model.setCurrentPath(chooser.getCurrentDirectory().toPath());
                    if (chooser.getCurrentDirectory().toPath() != upperController.getModel().getDEFAULT_DIR()) {
                        view.getDirectoryLabel().setText(model.getCurrentPath().toAbsolutePath().toString());
                    }
                }
            }
        };
        view.getChooseOutputButton().addActionListener(aLchooseOutputDir);

        aLdefaultDir = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.setCurrentPath(upperController.getModel().getDEFAULT_DIR());
                view.getDirectoryLabel().setText("default");
            }
        };
        view.getDefaultOutputButton().addActionListener(aLdefaultDir);

    }

    public void updateValuesFromView() {
        double configurationValues[] = {Double.parseDouble(view.getNumberOfCyclesSpinner().getValue().toString()),
            Double.parseDouble(view.getCyclesTimeSpinner().getValue().toString()),
            Double.parseDouble(view.getUpperLimitSpinner().getValue().toString()),
            Double.parseDouble(view.getWaitUpperTimeSpinner().getValue().toString()),
            Double.parseDouble(view.getLowerLimitSpinner().getValue().toString()),
            Double.parseDouble(view.getWaitLowerTimeSpinner().getValue().toString())};
        
        model.setValues(configurationValues);
    }

    public void updateValuesInView() {

    }

    public void resetValuesInView() {

    }

    ///Getters and Setters
    public ConfigurationModel getModel() {
        return model;
    }

    public ConfigurationPanel getView() {
        return view;
    }

    public FileFunctionsConfiguration getFileFunctions() {
        return fileFunctions;
    }

}
