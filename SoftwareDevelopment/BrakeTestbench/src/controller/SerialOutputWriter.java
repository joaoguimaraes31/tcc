package controller;

public class SerialOutputWriter {

    public void writeData(int serialOutput, SerialPortsFacade serialPortsFacade) {
        try {
            serialPortsFacade.outputStream.write(serialOutput);
            System.out.println(serialOutput);
            serialPortsFacade.outputStream.flush();
        } catch (Exception e) {
            System.out.println("Fail to write data");;

        }
    }
}
