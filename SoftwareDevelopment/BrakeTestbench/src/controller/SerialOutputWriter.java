package controller;

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
