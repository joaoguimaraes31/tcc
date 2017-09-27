package commands;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.Component;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.TooManyListenersException;
import javax.swing.JOptionPane;

public class Communicator implements SerialPortEventListener {

    private SerialPort serialPort = null;
    OutputStream outStream;
    InputStream inStream;

    String jointData = "";

    private boolean connectionError = false;
    boolean isConnected = false;
    
    //hardware constants
    final short TIMEOUT = 2000;
    final short MASTER_RESET = 43;
    final short START_ACQUISITION_COMMAND = 40;

    private CommPortIdentifier portId;

    public Communicator(CommPortIdentifier portId) {
        this.portId = portId;
    }

    
    
    public void setPortId(CommPortIdentifier portId) {
        this.portId = portId;
    }
    

    public void connect() {
        try {
            //Opening port
            if (portId != null) {
                serialPort = (SerialPort) portId.open("Demo application", TIMEOUT);

                //Msg to user
                Component frame = null;
                JOptionPane.showMessageDialog(frame, "Connection Sucessful!");
                System.out.println("Serial Port: " + serialPort.getName() + " opened sucessfully");
                System.out.println("Connected");

                //Setting connection FLAG
                isConnected = true;

                // Configuring port parameters
                serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                outStream = serialPort.getOutputStream();
                inStream = serialPort.getInputStream();
            } else {
                Component frame = null;
                JOptionPane.showMessageDialog(frame, "Could not connect to desired serial port!" + System.lineSeparator() + "Please check connections.", "Connection ERROR", JOptionPane.ERROR_MESSAGE);

            }
        } catch (PortInUseException e) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Could not connect to desired serial port!" + System.lineSeparator() + "Port already being used.", "Connection ERROR", JOptionPane.ERROR_MESSAGE);
            //System.out.println("Serial port already in use" + e.toString() + ")");
        } catch (Exception e) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Could not connect to desired serial port!" + System.lineSeparator() + "Please check connections.", "Connection ERROR", JOptionPane.ERROR_MESSAGE);
            //System.out.println("Could not connect to desired serial port!" + e.toString() + ")");
        }
    }
    

    public void disconnect() {
        try {
            System.out.println();
            if (!connectionError) {
                writeData(MASTER_RESET);
            }
            connectionError = false;
            serialPort.removeEventListener();
            serialPort.close();
            Component frame = null;
            //JOptionPane.showMessageDialog(frame, "Port disconnection sucessfull!");
            //System.out.println("Serial Port: " + serialPort.getName() + " closed sucessfully");
            isConnected = false;

            //System.out.println("Disconnected");
        } catch (Exception e) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Could not disconnect to serial port!", "Connection ERROR", JOptionPane.ERROR_MESSAGE);
            //System.out.println("Fail to close serial port");
        }
    }

    public void initListener() {
        try {
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (TooManyListenersException e) {

        }
    }

    public void removeListener() {
        serialPort.removeEventListener();
    }

    public void serialEvent(SerialPortEvent evt) {
        if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                byte singleData = (byte) inStream.read();
                if (singleData != 46) {
                    //System.out.print(new String(new byte[] { singleData }));
                    jointData = (new String(new byte[]{singleData})) + jointData;

                } else {

                    System.out.println(jointData);
                    jointData = "";
                    //System.out.println(" ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void writeData(int leftThrottle) {
        try {
            outStream.write(leftThrottle);
            outStream.flush();
        } catch (Exception e) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Could not write to the serial port!", "Connection ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(frame, "Disconnection Eminent!", "Connection Status", JOptionPane.WARNING_MESSAGE);
            connectionError = true;
            disconnect();

        }
    }
    
    public void startAcquisition(){
        if (isConnected){
            writeData(START_ACQUISITION_COMMAND);
        }
    }

    public boolean isConnected() {
        return isConnected;
    }
    
    

}
