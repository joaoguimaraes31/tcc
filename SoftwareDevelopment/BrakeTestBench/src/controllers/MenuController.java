package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import views.MenuBar;

public class MenuController {
    
    //upper controller
    private NavigationController upperController;
    
    //MVC
    private JMenuBar view;
    
    //ActionListeners
    private ActionListener aLloadCalibrationFile, aLsaveCalibrationFile,aLexit,aLLoadConfigFile,aLSaveConfigFile;//System.exit(0);
    

    public MenuController(NavigationController upperController) {
        this.upperController = upperController;
        view = new MenuBar();
    }

    public JMenuBar getView() {
        return view;
    }
    
    public void addListeners(){
        aLexit= new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
               if (upperController.getCalibrationController().getCommunicator().isConnected()){
                   upperController.getCalibrationController().getCommunicator().disconnect();
               }
               System.exit(0);
            }
        };
        view.getF
        
        aLloadCalibrationFile= new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
              //System.out.println("load calibration files");
              upperController.getCalibrationController().getFileFunctions().readingFromFile();
              
            }
        };
        //view.getMenuItemOpenCalibrationFile().addActionListener(aLloadCalibrationFile);
        
        aLsaveCalibrationFile= new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //System.out.println("save calibration files");
                upperController.getCalibrationController().getFileFunctions().writtingToFileRoutine();
            }
        };
        //view.getMenuItemSaveCalibrationFile().addActionListener(aLsaveCalibrationFile);
        
        aLLoadConfigFile= new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //System.out.println("save calibration files");
            }
        };
        //view.getMenuItemOpenCalibrationFile().addActionListener(aLLoadConfigFile);
        
        aLSaveConfigFile= new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //System.out.println("save calibration files");

            }
        };
        //view.getMenuItemSaveCalibrationFile().addActionListener(aLSaveConfigFile);
    }
    
    
}
