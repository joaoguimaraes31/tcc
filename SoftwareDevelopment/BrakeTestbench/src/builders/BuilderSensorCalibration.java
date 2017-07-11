package builders;

import models.Accelerometer;
import models.CrankshaftPosition;
import models.LoadCell;
import models.Sensor;
import models.Thermocouple;

public class BuilderSensorCalibration {
    
   
    public Sensor builderCalibrationData (String sensorType, int sensorId, String partModel, float calibrationOffset, float conversionFactor){
        
        Sensor sensor = new Sensor();
        
        switch(sensorType){
            case "Thermocouple" :
                sensor = new Thermocouple(sensorId, partModel, calibrationOffset, conversionFactor);
            case "LoadCell" :
                sensor = new LoadCell(sensorId, partModel, calibrationOffset, conversionFactor);
            case "CrankshaftPosition" :
                sensor = new CrankshaftPosition(sensorId, partModel, calibrationOffset, conversionFactor);
            case "Accelerometer" :
                sensor = new Accelerometer(sensorId, partModel, calibrationOffset, conversionFactor);
        }
        return sensor;
    }
    
}