package commands;

import gnu.io.CommPortIdentifier;
import controllers.SensorSetupController;
import gnu.io.SerialPortEvent;
import java.util.regex.Pattern;
import models.SensorSetupModel;
import views.SensorSetupView;

public class CalibrationCommunicator extends Communicator {

    private SensorSetupController sensorSetupController;
    private ChartOperations voltageChartOp, measurementChartOp;
    private int index = 0;

    public CalibrationCommunicator(CommPortIdentifier portId, SensorSetupController sensorSetupController, ChartOperations voltageChartOp, ChartOperations measurementChartOp) {
        super(portId);
        this.sensorSetupController = sensorSetupController;
        this.voltageChartOp = voltageChartOp;
        this.measurementChartOp = measurementChartOp;
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
                    SensorSetupModel model = sensorSetupController.getModel();
                    SensorSetupView view = sensorSetupController.getView();
                    System.out.printf("%.2f\n", getSensorData());
                    voltageChartOp.updateSeries(getSensorData());
                    String sensor = model.getValues()[(view.getChannelsCB().getSelectedIndex() - 1) * 4];
                    measurementChartOp.updateSeries(model.voltageToCalibrateMeasurement((getSensorData()), sensor));
                    measurementChartOp.setChartTitle(sensor);
                    measurementChartOp.setyAxisLabel(model.unityOfMeasurement(sensor));
                    voltageChartOp.createChart();
                    measurementChartOp.createChart();
                    jointData = "";
                    //System.out.println(" ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void startAcquisition() {
        if (isConnected) {
            index = sensorSetupController.getView().getChannelsCB().getSelectedIndex();
            if (index > 0) {
                index--;
            }
            writeData(START_ACQUISITION_COMMAND);
            voltageChartOp.startTimer();
            measurementChartOp.startTimer();
        }
    }

    public float getSensorData() {
        if (jointData.contains(",")) {

            String[] parts = jointData.split(Pattern.quote(",")); // Split on comma.
            // return Float.parseFloat(parts[index])*5/1023;
            return sensorSetupController.getModel().adcReadToVoltage(Integer.parseInt(parts[index]));
        } else {
            return -1;
        }
    }

}
