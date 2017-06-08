/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxtxarduino;

/**
 *
 * @author joao
 */
public class RxTxArduino {

    /**
     * @param args the command line arguments
     */
    private static final int SAMPLES_TO_READ = 2;
    
    
    public static void main(String[] args) {
        
        Communicator communicator = new Communicator();
	communicator.connect();
	communicator.initListener(SAMPLES_TO_READ);
        
        communicator.disconnect();
/*
         String libPathProperty = System.getProperty("java.library.path");
        System.out.println(libPathProperty);*/
    }
    
}
