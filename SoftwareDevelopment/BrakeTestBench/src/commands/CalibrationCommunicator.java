package commands;

import controllers.CalibrationController;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPortEvent;
import java.util.regex.Pattern;
import models.CalibrationModel;
import views.CalibrationPanel;

public class CalibrationCommunicator extends Communicator {

    private CalibrationController controller;
    private ChartOperations voltageChartOp, measurementChartOp;
    private int index = 0;
    
    public CalibrationCommunicator(CommPortIdentifier portId, CalibrationController controller, ChartOperations voltageChartOp, ChartOperations measurementChartOp) {
        super(portId);
        this.controller = controller;
        this.voltageChartOp = voltageChartOp;
        this.measurementChartOp = measurementChartOp;
    }

    @Override
    public void serialEvent(SerialPortEvent evt) {
        if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                byte singleData = (byte) inStream.read();
                if (singleData != 46) {
                    jointData = (new String(new byte[]{singleData})) + jointData;
                } else {
                    //System.out.println(jointData);
                    CalibrationModel model = controller.getModel();
                    CalibrationPanel view = controller.getView();
                    //System.out.printf("%.2f\n", getSensorData());
                    voltageChartOp.updateSeries(getSensorData());                                      
                    measurementChartOp.updateSeries(model.voltageToCalibrateMeasurement(getSensorData(), index)); 
                    measurementChartOp.setChartTitle(view.getSensorComboBox().getSelectedItem().toString());
                    measurementChartOp.setyAxisLabel(model.unityOfMeasurement(view.getSensorComboBox().getSelectedItem().toString()));
                    voltageChartOp.createChart();
                    measurementChartOp.createChart();
                    jointData = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void startAcquisition() {
        if (isConnected) {
            writeData(START_ACQUISITION_COMMAND);
            voltageChartOp.startTimer();
            measurementChartOp.startTimer();
        }
    }

    public float getSensorData() {
        if (jointData.contains(",")) {
            String[] parts = jointData.split(Pattern.quote(",")); // Split on comma.
            return controller.getModel().adcReadToVoltage(Integer.parseInt(parts[index]));
        } else {
            return -1;
        }
    }

}
