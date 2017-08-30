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
        "SENSOR0_TYPE","SENSOR0_LABEL","SENSOR0_CALIBRATION_OFFSET","SENSOR0_CALIBRATION_FACTOR",
        
        "SENSOR1_TYPE","SENSOR1_LABEL","SENSOR1_CALIBRATION_OFFSET","SENSOR1_CALIBRATION_FACTOR",
        
        "SENSOR2_TYPE","SENSOR2_LABEL","SENSOR2_CALIBRATION_OFFSET","SENSOR2_CALIBRATION_FACTOR",
        
        "SENSOR3_TYPE","SENSOR3_LABEL","SENSOR3_CALIBRATION_OFFSET","SENSOR3_CALIBRATION_FACTOR",
        
        "SENSOR4_TYPE","SENSOR4_LABEL","SENSOR4_CALIBRATION_OFFSET","SENSOR4_CALIBRATION_FACTOR",
        
        "SENSOR5_TYPE","SENSOR5_LABEL","SENSOR5_CALIBRATION_OFFSET","SENSOR5_CALIBRATION_FACTOR",
    };
    
    private String[] values={
        "NULL","NULL","NULL","NULL",
       
        "NULL","NULL","NULL","NULL",
        
        "NULL","NULL","NULL","NULL",
        
        "NULL","NULL","NULL","NULL",
        
        "NULL","NULL","NULL","NULL",
        
        "NULL","NULL","NULL","NULL"
    };
    

    public String[] getHEADER() {
        return HEADER;
    }

    public String[] getValues() {
        return values;
    }
}
