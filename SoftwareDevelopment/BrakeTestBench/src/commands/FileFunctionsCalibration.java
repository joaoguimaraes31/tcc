package commands;

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
    private String[][] sensorValues;
    private String header;
    private String calibrationFileName;
    private String[][] values;
    private String[][] tempValues;
    private int headerSize;
    private DateFormat dateFormat;
    private CalibrationModel model;
    private double[][] limitValues;

    public FileFunctionsCalibration(String fileName, FileNameExtensionFilter filter) {
        super(fileName, filter);
    }

    public FileFunctionsCalibration(CalibrationModel model) {
        super(model.getCalibrationFileName(), model.getFilter());
        this.model = model;
        this.descriptors = model.getDescriptors();
        this.sensorValues = model.getSensorValues();
        this.header = model.getHeader();
        this.headerSize = model.getHeaderSize();
        this.calibrationFileName = model.getCalibrationFileName();
        this.values = model.getSensorValues();
        tempValues = values;
        this.dateFormat = new SimpleDateFormat(model.getDateFormat());
        this.limitValues = model.getLimitValues();
    }

    @Override
    public void writingLogic(PrintWriter file) {
        int maxSize = matrixMaxMemberLength(values);
        file.println(header + dateFormat.format(getDate()) + "\n");
        for (int i = 0; i < values[0].length; i++) {
            for (int j = 0; j < descriptors.length; j++) {
                file.print(descriptors[j] + "=" + values[j][i] + ";");
                file.print(spacesString(-values[j][i].length() + maxSize + 3));
            }
            file.println();

        }
        JFrame frame = null;
        JOptionPane.showMessageDialog(frame, "Calibration values written to file sucesfully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void readingLogic(BufferedReader bRead, int numberOfLines) throws IOException {
        if (numberOfLines == (values[0].length + headerSize + 1)) {
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
                        tempValues[j][k - 3] = parts1[1];
                        parametersNumber++;
                    }
                }
                k++;
            }
            checkAcquiredValues(parametersNumber);
        } else {
            JFrame frame = null;
            JOptionPane.showMessageDialog(frame, "Invalid file format 2", "File corrupted", JOptionPane.ERROR_MESSAGE);
            readingFromFile();
        }
    }

    public void checkAcquiredValues(int parametersNumber) {
        boolean fileCorrupted = false;
        if (parametersNumber != values[0].length * values.length) {
            fileCorrupted = true;
        } else {

            for (int i = 2; i < 4; i++) {
                for (int j = 0; j < values[0].length; j++) {//tempValues[2][j]
                    if (isNumeric(tempValues[i][j]) == false) {
                        fileCorrupted = true;
                    } else {
                        double value = Double.parseDouble(tempValues[i][j]);
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
            readingFromFile();
        } else {
            values = tempValues;
            JOptionPane.showMessageDialog(frame, "Calibration values loadded!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
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
}
