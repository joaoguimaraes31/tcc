package controller;

import javax.swing.SwingUtilities;
import views.InitialScreen;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Main Class Running!");
            }
        });
    }

}
