package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import builders.MenuBarBuilder;

public class MenuController {

    //upper controller
    private NavigationController upperController;

    //Builder
    private MenuBarBuilder menuBarBuilder;

    //MVC
    private JMenuBar view;
    private JMenuItem item;

    //ActionListeners
    private ActionListener aLloadCalibrationFile, aLsaveCalibrationFile, aLexit, aLLoadConfigFile, aLSaveConfigFile;//System.exit(0);

    public MenuController(NavigationController upperController) {
        this.upperController = upperController;
        menuBarBuilder = new MenuBarBuilder();
        view = menuBarBuilder.getMenuBar();
        addListeners();

    }

    public void addListeners() {
        aLexit = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (upperController.getCalibrationController().getCommunicator().isConnected()) {
                    upperController.getCalibrationController().getCommunicator().disconnect();
                }
                System.exit(0);
            }
        };
        menuBarBuilder.getExitMenuItem();

        aLloadCalibrationFile = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //System.out.println("load calibration files");
                upperController.getCalibrationController().getFileFunctions().readingFromFile();

            }
        };
        menuBarBuilder.getLoadCalibrationMenuItem().addActionListener(aLloadCalibrationFile);

        aLsaveCalibrationFile = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //System.out.println("save calibration files");
                upperController.getCalibrationController().getFileFunctions().writtingToFileRoutine();
            }
        };
        menuBarBuilder.getSaveCalibrationMenuItem().addActionListener(aLsaveCalibrationFile);

        aLLoadConfigFile = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //System.out.println("save calibration files");
            }
        };
        menuBarBuilder.getLoadConfigurationMenuItem().addActionListener(aLLoadConfigFile);

        aLSaveConfigFile = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //System.out.println("save calibration files");

            }
        };
        menuBarBuilder.getSaveConfigurationMenuItem().addActionListener(aLSaveConfigFile);
    }

    public JMenuBar getView() {
        return view;
    }

    public MenuBarBuilder getMenuBarBuilder() {
        return menuBarBuilder;
    }
}
