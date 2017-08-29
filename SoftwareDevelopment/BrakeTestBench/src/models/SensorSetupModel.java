/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author joao
 */
public class SensorSetupModel {
    
   //info for configuration files
    private final String[] HEADER = {
        "SENSOR0_TYPE",     //0 - NULL, 1 - Thermocouple, 2 - Load Cell, 3 - CKP, 4 - Accelerometer
        "SENSOR0_CALIBRATION_OFFSET",
        "SENSOR0_CALIBRATION_FACTOR",
        
        "SENSOR1_TYPE",     //0 - NULL, 1 - Thermocouple, 2 - Load Cell, 3 - CKP, 4 - Accelerometer
        "SENSOR1_CALIBRATION_OFFSET",
        "SENSOR1_CALIBRATION_FACTOR",
        
        "SENSOR2_TYPE",     //0 - NULL, 1 - Thermocouple, 2 - Load Cell, 3 - CKP, 4 - Accelerometer
        "SENSOR2_CALIBRATION_OFFSET",
        "SENSOR2_CALIBRATION_FACTOR",
        
        "SENSOR3_TYPE",     //0 - NULL, 1 - Thermocouple, 2 - Load Cell, 3 - CKP, 4 - Accelerometer
        "SENSOR3_CALIBRATION_OFFSET",
        "SENSOR3_CALIBRATION_FACTOR",
        
        "SENSOR4_TYPE",     //0 - NULL, 1 - Thermocouple, 2 - Load Cell, 3 - CKP, 4 - Accelerometer
        "SENSOR4_CALIBRATION_OFFSET",
        "SENSOR4_CALIBRATION_FACTOR",
        
        "SENSOR5_TYPE",     //0 - NULL, 1 - Thermocouple, 2 - Load Cell, 3 - CKP, 4 - Accelerometer
        "SENSOR5_CALIBRATION_OFFSET",
        "SENSOR5_CALIBRATION_FACTOR",
    };
    
    private String[] values = {"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};

    public String[] getHEADER() {
        return HEADER;
    }

    public String[] getValues() {
        return values;
    }
    
    
    
}
