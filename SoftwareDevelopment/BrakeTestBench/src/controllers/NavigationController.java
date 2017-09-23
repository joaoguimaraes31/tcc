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
    private ActionListener aLB0, aLB1, aLB2, aLB3, aLB4,aLexit;

    public NavigationController() {

        //Creating Sub-systems
        ////MVC
        view = new ApplicationFrame();
        view.setVisible(true);
        addListeners();

        ///Subsystem serial setup
        serialPortSetupBuilder = new SerialPortSetupBuilder();
        serialPortSetupBuilder.createSubsystem(this);
        serialPortSetupController = serialPortSetupBuilder.getSerialPortSetupController();
    }

    //addListeners for controlling view and triggers events
    public void addListeners() {
        aLB0 = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                deselectButtonsPannels();
                view.getP1().setVisible(true);
                view.getTB1().setSelected(true);

            }
        };
        view.getTB1().addActionListener(aLB0);
        /*
            aLB1 = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    deselectButtonsPannels();
                    view.getToggleButtons()[1].setSelected(true);
                    view.getPanels()[1].setVisible(true);
                    System.out.println(1);
                }
            };
            view.getToggleButtons()[1].addActionListener(aLB1);*/

        aLB2 = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                deselectButtonsPannels();
                view.getP3().setVisible(true);
                view.getTB3().setSelected(true);
            }
        };
        view.getTB3().addActionListener(aLB2);
        /*
            aLB3 = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    deselectButtonsPannels();
                    view.getToggleButtons()[3].setSelected(true);
                    view.getPanels()[3].setVisible(true);
                    System.out.println(3);
                }
            };
            view.getToggleButtons()[3].addActionListener(aLB3);
            
            aLB4 = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    deselectButtonsPannels();
                    view.getToggleButtons()[4].setSelected(true);
                    view.getPanels()[4].setVisible(true);
                    System.out.println(4);
                }
            };
            view.getToggleButtons()[4].addActionListener(aLB4);
            
         */
        
        aLexit = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    System.exit(0);
                }
            };
            view.getMenuItemExit().addActionListener(aLexit);
    }

    public void deselectButtonsPannels() {
        view.getTB1().setSelected(false);
        view.getTB3().setSelected(false);
        view.getP1().setVisible(false);
        view.getP3().setVisible(false);
    }
    
}
