package controllers;

import builders.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;

public class NavigationController {

    //builders to create subsystems
    private SerialPortSetupBuilder serialPortSetupBuilder;

    //needed controllers
    private SerialPortSetupController serialPortSetupController;

    //MVC
    private ApplicationFrame view;
    private ActionListener aLB0, aLB1, aLB2, aLB3, aLB4;

    public NavigationController() {

        //Creating Sub-systems
        ////MVC
        view = new ApplicationFrame();
        view.setVisible(true);

        ///Subsystem serial setup
        serialPortSetupBuilder = new SerialPortSetupBuilder();
        serialPortSetupBuilder.createSubsystem(this);
        serialPortSetupController = serialPortSetupBuilder.getSerialPortSetupController();
    }

   


    
}
