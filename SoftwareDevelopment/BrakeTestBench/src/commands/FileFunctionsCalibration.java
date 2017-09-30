package commands;

import controllers.CalibrationController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.CalibrationModel;

public class FileFunctionsCalibration extends FileFunctions {

    private String[] descriptors;
    private String[][] sensorValues,temp;
    private String header;
    private String calibrationFileName;
    //private float[][] calibrationValues;
    private int headerSize;
    private DateFormat dateFormat;
    private CalibrationController upperController;
    private double[][] limitValues;

    public FileFunctionsCalibration(String fileName, FileNameExtensionFilter filter) {
        super(fileName, filter);
    }

    public FileFunctionsCalibration(CalibrationController upperController) {
        super(upperController.getModel().getCalibrationFileName(), upperController.getModel().getFilter());
        this.upperController=upperController;
        CalibrationModel model = upperController.getModel();
        this.descriptors = model.getDescriptors();
        this.header = model.getHeader();
        this.headerSize = model.getHeaderSize();
        this.calibrationFileName = model.getCalibrationFileName();
        this.dateFormat = new SimpleDateFormat(model.getDateFormat());
        //this.calibrationValues = model.getCalibrationValues();
        this.sensorValues = model.getSENSOR_VALUES();
        this.temp = model.getSENSOR_VALUES();
        this.limitValues = model.getSPINNERS_RANGE();
        model.floatValuesToString(this.sensorValues,model.getCalibrationValues());
    }

    @Override
    public void writingLogic(PrintWriter file) {
        int maxSize = matrixMaxMemberLength(sensorValues);
        file.println(header + dateFormat.format(getDate()) + "\n");
        for (int i = 0; i < sensorValues[0].length; i++) {
            for (int j = 0; j < descriptors.length; j++) {
                file.print(descriptors[j] + "=" + sensorValues[j][i] + ";");
                file.print(spacesString(-sensorValues[j][i].length() + maxSize + 3));
            }
            file.println();

        }
        JFrame frame = null;
        JOptionPane.showMessageDialog(frame, "Calibration values written to file sucesfully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void readingLogic(BufferedReader bRead, int numberOfLines) throws IOException {
        if (numberOfLines == (sensorValues[0].length + headerSize + 1)) {
            String str = "";
            int k = 0;
            int parametersNumber = 0;
            while ((str = bRead.readLine()) != null) {
                //divides into sensor parameters
                if (k > (headerSize)) {
                    String[] parts0 = str.split(";");

                    for (int j = 0; j < (parts0.length - 1); j++) {
                        //separetes parameter description with value
                        String[] parts1 = parts0[j].split("=");
                        temp[j][k - 3] = parts1[1];
                        parametersNumber++;
                    }
                }
                k++;
            }
            checkAcquiredValues(parametersNumber);
        } else {
            JFrame frame = null;
            JOptionPane.showMessageDialog(frame, "Invalid file format 2", "File corrupted", JOptionPane.ERROR_MESSAGE);
            upperController.resetCalibrationValues();
            readingFromFile();
        }
    }

    public void checkAcquiredValues(int parametersNumber) {
        boolean fileCorrupted = false;
        if (parametersNumber != sensorValues[0].length * sensorValues.length) {
            fileCorrupted = true;
        } else {

            for (int i = 2; i < 4; i++) {
                for (int j = 0; j < sensorValues[0].length; j++) {//tempValues[2][j]
                    if (isNumeric(temp[i][j]) == false) {
                        fileCorrupted = true;
                    } else {
                        double value = Double.parseDouble(temp[i][j]);
                        if ((value < limitValues[i - 2][0]) | (value > limitValues[i - 2][1])) {
                            fileCorrupted = true;
                        }
                    }
                }
            }
        }

        JFrame frame = null;
        if (fileCorrupted) {
            JOptionPane.showMessageDialog(frame, "Invalid file format", "File corrupted", JOptionPane.ERROR_MESSAGE);
            upperController.resetCalibrationValues();
            readingFromFile();
        } else {
            CalibrationModel model = upperController.getModel();
            model.stringValuesToFloat(temp, model.getCalibrationValues());
            JOptionPane.showMessageDialog(frame, "Calibration values loadded!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
            upperController.getModel().setSettingsLoadded(true);
            upperController.getView().getLoadedSettingLabel().setText(calibrationFileName);
        }
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void stringValuesToFloat(String[][] values) {

    }

}
