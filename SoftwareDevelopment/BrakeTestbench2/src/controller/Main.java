package controller;

import javax.swing.SwingUtilities;
import models.InitialScreenModel;
import models.Sensor;
import views.InitialScreenView;

public class Main {
    
    public static Sensor[] sensorList = {null,null,null,null,null,null};
    public static String selectedSerialPort = null;
    
    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Main Class Running!");
                
                InitialScreenModel initialScreenModel = new InitialScreenModel();
                InitialScreenView initialScreenView = new InitialScreenView();
                InitialScreenController initialScreenController = new InitialScreenController(initialScreenModel,initialScreenView);
                
                //Disparando tela inicial
                initialScreenController.control();
            }
        });
    }

}
