/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communicationtest;

/**
 *
 * @author joao
 */
public class SerialOutputWriter {

    public void writeData(int serialOutput, SerialPortsFacade serialPortsController) {
        try {
            serialPortsController.outputStream.write(serialOutput);
            System.out.println(serialOutput);
            serialPortsController.outputStream.flush();
        } catch (Exception e) {
            System.out.println("Fail to write data");;

        }
    }
}
