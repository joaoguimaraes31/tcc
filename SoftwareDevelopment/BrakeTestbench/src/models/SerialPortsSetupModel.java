package models;

import controller.SerialPortsFacade;
import gnu.io.CommPortIdentifier;
import java.util.HashMap;
import views.SerialPortsSetupView;

public class SerialPortsSetupModel {

    public void fillComboBoxWithPortNames(SerialPortsSetupView view, HashMap portMap) {
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
            //Component frame = null;			
            //JOptionPane.showMessageDialog(frame,"No serial ports were found!","ERROR",JOptionPane.ERROR_MESSAGE);

        } else {
            view.getSetBT().setEnabled(true);
        }

    }
}