package commands;

import controllers.ConfigurationController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.ConfigurationModel;


public class FileFunctionsConfiguration extends FileFunctions {

    private ConfigurationController upperController;
    
    private String header;
    private SimpleDateFormat dateFormat;
    private String[]  descriptors;
    
    public FileFunctionsConfiguration(String fileName, FileNameExtensionFilter filter) {
        super(fileName, filter);
    }

    public FileFunctionsConfiguration(ConfigurationController upperController, String fileName, FileNameExtensionFilter filter) {
        super(fileName, filter);
        this.upperController=upperController;
        ConfigurationModel model = this.upperController.getModel();
        this.header=model.getHEADER();
        this.dateFormat=model.getDATE_FORMAT();
        
        this.descriptors=model.getDESCRIPTORS();
    }

    @Override
    public void writingLogic(PrintWriter file) {
        upperController.updateValuesFromView();
        //System.out.println(upperController.getView().getNumberOfCyclesSpinner().getValue().toString());
        String[] configurationValues=doubleArrayToStringArray(upperController.getModel().getValues());
        int maxSize = arrayMaxMemberLength(configurationValues);
        file.println(header + dateFormat.format(getDate()) + "\n");
        for (int i = 0; i < configurationValues.length; i++) {
                file.print(descriptors[i] + "=" + configurationValues[i] + ";");
                file.print(spacesString(-configurationValues[i].length() + maxSize + 3));
            file.println();

        }
        JFrame frame = null;
        JOptionPane.showMessageDialog(frame, "Calibration values written to file sucesfully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void readingLogic(BufferedReader bRead, int numberOfLines) throws IOException {

    }

    public static String[] doubleArrayToStringArray(double[] values) {
        String out[] = {"", "", "", "", "", ""};

        for (int i = 0; i < values.length; i++) {
            out[i] = String.valueOf(values[i]);
        }
        return out;
    }

}
