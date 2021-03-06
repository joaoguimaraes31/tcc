package commands;

import gnu.io.CommPortIdentifier;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import views.SerialPortSetupView;

public class SerialPortSetupCommand {

    private HashMap portMap = new HashMap();
    final int TIMEOUT = 2000;
   // private SerialPort serialPort = null;
    OutputStream outputStream = null;
    InputStream inputStream = null;

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

       

    }
    
    public HashMap getPortMap() {
        return portMap;
    }
    
}
