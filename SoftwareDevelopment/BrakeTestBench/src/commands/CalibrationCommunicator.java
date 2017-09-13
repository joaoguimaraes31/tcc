package commands;

import gnu.io.CommPortIdentifier;
import controllers.SensorSetupController;
import gnu.io.SerialPortEvent;
import java.util.regex.Pattern;

public class CalibrationCommunicator extends Communicator {

    private SensorSetupController sensorSetupController;
    private int index=0;

    public CalibrationCommunicator(CommPortIdentifier portId, SensorSetupController sensorSetupController) {
        super(portId);
        this.sensorSetupController = sensorSetupController;
    }

    @Override
    public void serialEvent(SerialPortEvent evt) {
        if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                byte singleData = (byte) inStream.read();
                if (singleData != 46) {
                    //System.out.print(new String(new byte[] { singleData }));
                    jointData = (new String(new byte[]{singleData})) + jointData;
                } else {
                    //System.out.println(jointData);
                    System.out.println(getSensorData());
                    jointData = "";
                    //System.out.println(" ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    
    @Override
    public void startAcquisition(){
        if (isConnected){
            index=sensorSetupController.getView().getChannelsCB().getSelectedIndex();
            if (index>0){
                index--;
            }
            writeData(START_ACQUISITION_COMMAND);
        }
    }

    public float getSensorData() {
       if (jointData.contains(",")) {
            String[] parts = jointData.split(Pattern.quote(",")); // Split on comma.
            return Integer.parseInt(parts[index])*5/1024;
        } else {
            return -1;
        }
       
    }
    
    

}
