package commands;

import controllers.ConfigurationController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.ConfigurationModel;

public class FileFunctionsConfiguration extends FileFunctions {

    //MVC
    private ConfigurationController upperController;
    private ConfigurationModel model;

    public FileFunctionsConfiguration(String outputFileName, FileNameExtensionFilter filter) {
        super(outputFileName, filter);
    }

    public FileFunctionsConfiguration(ConfigurationController upperController, String outputFileName, FileNameExtensionFilter filter) {
        super(outputFileName, filter);
        this.upperController = upperController;
        this.model = this.upperController.getModel();
    }

    @Override
    public void writingLogic(PrintWriter file) {
        upperController.updateValuesFromView();
        String[] configurationValues = doubleArrayToStringArray(upperController.getModel().getValues());
        int maxSize = arrayMaxMemberLength(configurationValues);
        file.println(model.getHEADER() + model.getDATE_FORMAT().format(getDate()) + "\n");
        for (int i = 0; i < configurationValues.length; i++) {
            file.print(model.getDESCRIPTORS()[i] + "=" + configurationValues[i] + ";");
            file.print(spacesString(-configurationValues[i].length() + maxSize + 3));
            file.println();

        }
        JFrame frame = null;
        JOptionPane.showMessageDialog(frame, "Calibration values written to file sucesfully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        upperController.getView().getConfigurationFileLabel().setText(outputFilePath+outputFileName);
    }

    @Override
    public void readingLogic(BufferedReader bRead, int numberOfLines) throws IOException {
        String[] temp = doubleArrayToStringArray(model.getValues());
        int headerSize = model.getHEADER_SIZE();
        if (numberOfLines == (model.getValues().length + headerSize + 1)) {
            String str = "";
            int k = 0;
            int parametersNumber = 0;
            while ((str = bRead.readLine()) != null) {
                //divides into sensor parameters
                if (k > headerSize) {
                    String[] parts0 = str.split("=");

                    //separetes parameter description with value
                    String[] parts1 = parts0[1].split(";");
                    temp[k - (headerSize+1)] = parts1[0];
                    parametersNumber++;
                }
                k++;
            }
            checkAcquiredValues(parametersNumber, temp);
        } else {
            JFrame frame = null;
            JOptionPane.showMessageDialog(frame, "Invalid file format", "File corrupted", JOptionPane.ERROR_MESSAGE);
            upperController.resetValues();
            upperController.getModel().setSettingsLoadded(false);
            upperController.getView().getConfigurationFileLabel().setText("none");
            readingFromFile();
        }
    }

    public void checkAcquiredValues(int parametersNumber, String[] temp) {
        boolean fileCorrupted = false;
        if (parametersNumber != model.getValues().length) {
            fileCorrupted = true;
        } else {

            for (int i = 0; i < model.getValues().length; i++) {

                if (isNumeric(temp[i]) == false) {
                    fileCorrupted = true;
                } else {
                    double value = Double.parseDouble(temp[i]);
                    if ((value < model.getSP_MIN()[i]) | (value > model.getSP_MAX()[i])) {
                        fileCorrupted = true;
                    }
                }

            }
        }

        JFrame frame = null;
        if (fileCorrupted) {
            JOptionPane.showMessageDialog(frame, "Invalid file format", "File corrupted", JOptionPane.ERROR_MESSAGE);
            upperController.resetValues();
            upperController.getModel().setSettingsLoadded(false);
            upperController.getView().getConfigurationFileLabel().setText("none");
            readingFromFile();
        } else {
            model.stringValuesToDouble(temp, model.getValues());
            JOptionPane.showMessageDialog(frame, "Calibration values loadded!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
            upperController.updateValuesInView();
            upperController.getModel().setSettingsLoadded(true);
            upperController.getView().getConfigurationFileLabel().setText(inputFileName);
        }
    }

    public static String[] doubleArrayToStringArray(double[] values) {
        String out[] = {"","","","","",""};

        for (int i = 0; i < values.length; i++) {
            out[i] = String.valueOf(values[i]);
        }
        return out;
    }

}
