package commands;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import views.SerialPortSetupView;

public class SerialPortSetupCommand {

    private HashMap portMap = new HashMap();
    final int TIMEOUT = 2000;
    private SerialPort serialPort = null;
    OutputStream outputStream = null;
    InputStream inputStream = null;
    private boolean isConnected = false;

    //Method for searching for serial ports and filling a HashMap with then
    public void searchForPorts() {
        Enumeration ports = CommPortIdentifier.getPortIdentifiers();
        portMap.clear();

        while (ports.hasMoreElements()) {
            CommPortIdentifier curPort = (CommPortIdentifier) ports.nextElement();

            //get only serial ports
            if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                portMap.put(curPort.getName(), curPort);
            }
        }
    }
    
    //Method for connecting to desired serial port
    public void connect(String selectedPort) {
        try {
            CommPortIdentifier portId = (CommPortIdentifier) portMap.get(selectedPort);
            //Opening port
            if (portId != null) {
                serialPort = (SerialPort) portId.open("Demo application", TIMEOUT);

                // Configuring port parameters
                serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                System.out.println("Serial Port: " + serialPort.getName() + " opened sucessfully");
                System.out.println("Connected");

                outputStream = serialPort.getOutputStream();
                inputStream = serialPort.getInputStream();
                isConnected = true;
            } else {
                System.out.println("Could not connect to desired serial port!");
                isConnected = false;
            }
        } catch (PortInUseException e) {
            System.out.println("Serial port already in use" + e.toString() + ")");
            isConnected = false;
        } catch (Exception e) {
            System.out.println("Could not connect to desired serial port!" + e.toString() + ")");
            isConnected = false;
        }
    }
    
    //Method for disconnecting from a seriap port
    public void disconnect() {
        try {
            System.out.println();

            serialPort.removeEventListener();
            serialPort.close();
            System.out.println("Serial Port: " + serialPort.getName() + " closed sucessfully");
        } catch (Exception e) {
            System.out.println("Fail to close serial port");
        }
    }
    
    public void fillComboBoxWithPortNames(SerialPortSetupView view, HashMap portMap) {
        view.getPortsCB().removeAllItems();

        String[] portNames = new String[portMap.size()];

        int i = 0;
        for (Object port : portMap.values().toArray()) {
            portNames[i] = ((CommPortIdentifier) port).getName();
            i++;
        }

        String[] portMapValues = portNames;

        for (int k = 0; k < portMapValues.length; k++) {
            view.getPortsCB().addItem(portMapValues[k]);
        }

        if (view.getPortsCB().getSelectedItem() == null) {
            view.getSetBT().setEnabled(false);

        } else {
            view.getSetBT().setEnabled(true);
        }

    }
    
    public void portsEnableEvents(SerialPortSetupView view){
        if (view.getPortsCB().getSelectedItem()!=null){
            view.getSetBT().setEnabled(true);
            view.getPortsCB().setEnabled(true);
        }else{
            view.getSetBT().setEnabled(false);
            view.getPortsCB().setEnabled(false);
            System.out.println("no serial port");
        }
    }
    
    public SerialPort getSerialPort() {
        return serialPort;
    }

    public HashMap getPortMap() {
        return portMap;
    }

    public boolean isIsConnected() {
        return isConnected;
    }
    
    
}
