package controllers;

import builders.*;
import models.*;
import views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.NavigationModel.ScreenPossibilities;

public class NavigationController {

    //MVC PATTERN
    private NavigationModel model;

    //builders to create subsystems
    private SerialPortSetupBuilder serialPortSetupBuilder;
    private SensorSetupBuilder sensorSetupBuilder;
    private InitialScreenBuilder initialScreenBuilder;

    //needed controllers
    private SerialPortSetupController serialPortSetupController;
    private SensorSetupController sensorSetupController;
    private InitialScreenController initialScreenController;

    public NavigationController() {
        //model setup
        model = new NavigationModel(false);

        //Creating Sub-systems
        ///Subsystem serial setup
        serialPortSetupBuilder = new SerialPortSetupBuilder();
        serialPortSetupBuilder.createSubsystem(this);
        serialPortSetupController = serialPortSetupBuilder.getSerialPortSetupController();
        ///subsystem calibration
        sensorSetupBuilder = new SensorSetupBuilder();
        sensorSetupBuilder.createSubsystem(this);
        sensorSetupController = sensorSetupBuilder.getSensorSetupController();
        ///initialScreen
        initialScreenBuilder = new InitialScreenBuilder();
        initialScreenBuilder.createSubsystem(this);
        initialScreenController = initialScreenBuilder.getInitialScreenController();

        //ViewControl
        //model.setCurrentScreen(ScreenPossibilities.INITIAL);
    }

    public InitialScreenController getInitialScreenController() {
        return initialScreenController;
    }

    public SerialPortSetupController getSerialPortSetupController() {
        return serialPortSetupController;
    }

    public SensorSetupController getSensorSetupController() {
        return sensorSetupController;
    }

    public NavigationModel getModel() {
        return model;
    }

    public void setModel(NavigationModel model) {
        this.model = model;
    }

}
