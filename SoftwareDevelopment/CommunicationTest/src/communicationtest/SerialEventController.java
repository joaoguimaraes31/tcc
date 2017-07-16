package communicationtest;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.TooManyListenersException;

public class SerialEventController implements SerialPortEventListener {   
    SerialPortsFacade serialPortsController = new SerialPortsFacade();
    SerialOutputWriter serialOutputWriter = new SerialOutputWriter();
    String jointData = "";
    
    public void initListener(SerialPort serialPort) {
        try {
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (TooManyListenersException e) {

        }
    }

    public void removeListener(SerialPort serialPort) {
        serialPort.removeEventListener();
    }

    public void serialEvent(SerialPortEvent evt) {
        if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) { 
            try {    
                byte singleData = (byte) serialPortsController.inputStream.read();
                if (singleData != 46) {
                    //System.out.print(new String(new byte[] { singleData }));
                    jointData = (new String(new byte[]{singleData})) + jointData;
                } else {
                    //Fim da linha
                    System.out.println(jointData);
                    jointData = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
