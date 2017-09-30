package models;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ConfigurationModel {

    //Constants
    private final double SP_DEF[] = {0, 0, 0, 0, 0, 0};
    private final double SP_MIN[] = {0, 0, 0, 0, 0, 0};
    private final double SP_MAX[] = {50, 10000, 80, 10, 40, 10};
    private final double SP_STEP[] = {1, 10, 5, 1, 5, 1};
    private final SpinnerNumberModel NUMBER_OF_CYCLES_SPINNER_MODEL = new SpinnerNumberModel(SP_MIN[0], SP_DEF[0], SP_MAX[0], SP_STEP[0]);   //initial,min,max,step
    private final SpinnerNumberModel CYCLES_TIME_SPINNER_MODEL = new SpinnerNumberModel(SP_MIN[1], SP_DEF[1], SP_MAX[1], SP_STEP[1]);
    private final SpinnerNumberModel UPPER_LIMITS_SPINNER_MODEL = new SpinnerNumberModel(SP_MIN[2], SP_DEF[2], SP_MAX[2], SP_STEP[2]);
    private final SpinnerNumberModel WAIT_UPPER_SPINNER_MODEL = new SpinnerNumberModel(SP_MIN[3], SP_DEF[3], SP_MAX[3], SP_STEP[3]);
    private final SpinnerNumberModel LOWER_LIMITS_SPINNER_MODEL = new SpinnerNumberModel(SP_MIN[4], SP_DEF[4], SP_MAX[4], SP_STEP[4]);
    private final SpinnerNumberModel WAIT_LOWER_SPINNER_MODEL = new SpinnerNumberModel(SP_MIN[5], SP_DEF[5], SP_MAX[5], SP_STEP[5]);
    private final String TEST_REGULARION_FILE_NAME = "none";
    private final String TEST_CONFIGURATION_FILE_NAME = "none";
    private final String DIRECTORY_NAME = "none";

    //Writing to file constants
    private final String HEADER = "Braketestbench Configuration Settings\nDate Modified ";
    private final String CALIBRATION_FILE_NAME = "BTF-Settings.cfg";
    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private final FileNameExtensionFilter FILTER = new FileNameExtensionFilter("BrakeTestBench Configuration Files (.cfg)", "cfg");
    private int headerSize = 2;
    private final String DESCRIPTORS[] = {"Number of Cycles", "Time between cycles (ms)", "Upper limit (kph)", "Wait time (s)", "Lower limit (kph)", "Wait time (s)"};

    //Variables
    private boolean settingsLoadded = false;
    private String testConfigurationFileName = "none";
    private Path currentPath = Paths.get("");

    private double values[] = {0, 0, 0, 0, 0, 0};

    public void stringValuesToDouble(String[] sensorValues, double[] doubleValues) {
        for (int i = 0; i < doubleValues.length; i++) {
            doubleValues[i] = Double.parseDouble(sensorValues[i]);

        }
    }

    //Getters and Setters
    public SpinnerNumberModel getNUMBER_OF_CYCLES_SPINNER_MODEL() {
        return NUMBER_OF_CYCLES_SPINNER_MODEL;
    }

    public SpinnerNumberModel getCYCLES_TIME_SPINNER_MODEL() {
        return CYCLES_TIME_SPINNER_MODEL;
    }

    public SpinnerNumberModel getUPPER_LIMITS_SPINNER_MODEL() {
        return UPPER_LIMITS_SPINNER_MODEL;
    }

    public SpinnerNumberModel getWAIT_UPPER_SPINNER_MODEL() {
        return WAIT_UPPER_SPINNER_MODEL;
    }

    public SpinnerNumberModel getLOWER_LIMITS_SPINNER_MODEL() {
        return LOWER_LIMITS_SPINNER_MODEL;
    }

    public SpinnerNumberModel getWAIT_LOWER_SPINNER_MODEL() {
        return WAIT_LOWER_SPINNER_MODEL;
    }

    public String getTEST_REGULARION_FILE_NAME() {
        return TEST_REGULARION_FILE_NAME;
    }

    public String getTEST_CONFIGURATION_FILE_NAME() {
        return TEST_CONFIGURATION_FILE_NAME;
    }

    public String getDIRECTORY_NAME() {
        return DIRECTORY_NAME;
    }

    public String getTestConfigurationFileName() {
        return testConfigurationFileName;
    }

    public double[] getValues() {
        return values;
    }

    public double[] getSP_DEF() {
        return SP_DEF;
    }

    public double[] getSP_MIN() {
        return SP_MIN;
    }

    public double[] getSP_MAX() {
        return SP_MAX;
    }

    public double[] getSP_STEP() {
        return SP_STEP;
    }

    public void setTestConfigurationFileName(String testConfigurationFileName) {
        this.testConfigurationFileName = testConfigurationFileName;
    }

    public void setValues(double values[]) {
        this.values = values;
    }

    public Path getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(Path currentPath) {
        this.currentPath = currentPath;
    }

    public String getHEADER() {
        return HEADER;
    }

    public String getCALIBRATION_FILE_NAME() {
        return CALIBRATION_FILE_NAME;
    }

    public SimpleDateFormat getDATE_FORMAT() {
        return DATE_FORMAT;
    }

    public FileNameExtensionFilter getFILTER() {
        return FILTER;
    }

    public int getHeaderSize() {
        return headerSize;
    }

    public String[] getDESCRIPTORS() {
        return DESCRIPTORS;
    }

    public boolean isSettingsLoadded() {
        return settingsLoadded;
    }

    public void setSettingsLoadded(boolean settingsLoadded) {
        this.settingsLoadded = settingsLoadded;
    }
    
    
}
