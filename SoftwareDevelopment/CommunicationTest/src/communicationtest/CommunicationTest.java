package communicationtest;

public class CommunicationTest {

    public static void main(String[] args) throws InterruptedException {

        SerialEventController serialEventController = new SerialEventController();
        
        serialEventController.serialPortsController.searchForPorts();
        serialEventController.serialPortsController.connect("/dev/ttyUSB0");
        serialEventController.initListener(serialEventController.serialPortsController.getSerialPort());
        serialEventController.serialOutputWriter.writeData(40, serialEventController.serialPortsController);
        Thread.sleep(3000);
        serialEventController.serialOutputWriter.writeData(41, serialEventController.serialPortsController);
        serialEventController.serialPortsController.disconnect();

    }

}
