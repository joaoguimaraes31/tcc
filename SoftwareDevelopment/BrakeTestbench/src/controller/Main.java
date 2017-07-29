package controller;

import javax.swing.SwingUtilities;
import models.Sensor;
import views.InitialScreen;

public class Main {
    
    public static Sensor[] sensorList = {null,null,null,null,null,null};
    public 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Main Class Running!");
            }
        });
    }

}
