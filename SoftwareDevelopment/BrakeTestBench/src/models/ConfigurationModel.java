package models;

import javax.swing.SpinnerNumberModel;

public class ConfigurationModel {

    //Constants
    private final SpinnerNumberModel NUMBER_OF_CYCLES_SPINNER_MODEL = new SpinnerNumberModel(0, 0, 0, 0);
    private final SpinnerNumberModel CYCLES_TIME_SPINNER_MODEL = new SpinnerNumberModel(0, 0, 0, 0);
    private final SpinnerNumberModel UPPER_LIMITS_SPINNER_MODEL = new SpinnerNumberModel(0, 0, 0, 0);
    private final SpinnerNumberModel WAIT_UPPER_SPINNER_MODEL = new SpinnerNumberModel(0, 0, 0, 0);
    private final SpinnerNumberModel LOWER_LIMITS_SPINNER_MODEL = new SpinnerNumberModel(0, 0, 0, 0);
    private final SpinnerNumberModel WAIT_LOWER_SPINNER_MODEL = new SpinnerNumberModel(0, 0, 0, 0);
    private final String TEST_REGULARION_FILE_NAME = "none";
    private final String TEST_CONFIGURATION_FILE_NAME = "none";
    private final String DIRECTORY_NAME = "none";

    //Variables
    private String testRegulationFileName = "none";
    private String testConfigurationFileName = "none";
    private String directoryName = "none";

    private double values[] = {0, 0, 0, 0, 0, 0};

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

    public String getTestRegulationFileName() {
        return testRegulationFileName;
    }

    public String getTestConfigurationFileName() {
        return testConfigurationFileName;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public double[] getValues() {
        return values;
    }

    public void setTestRegulationFileName(String testRegulationFileName) {
        this.testRegulationFileName = testRegulationFileName;
    }

    public void setTestConfigurationFileName(String testConfigurationFileName) {
        this.testConfigurationFileName = testConfigurationFileName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public void setValues(double[] values) {
        this.values = values;
    }

}
