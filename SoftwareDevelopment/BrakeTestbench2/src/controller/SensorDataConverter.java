package controller;

import models.Sensor;

public class SensorDataConverter {

    public Sensor sensorAdjustment(int sensorReading, Sensor sensor){      
        sensor.setSensorReading(sensorReading);
        sensor.sensorReadingCalibration();       
        return sensor;
    }
    
    public static int[] stringSensorConverter(String sensorsReadingsString) {
        int i=0;
        int k=0;
        String curReading = "";
        int[] readings = {0,0,0,0,0,0};
        
        while (i<(sensorsReadingsString.length())){
            if (sensorsReadingsString.charAt(i)==',' || sensorsReadingsString.charAt(i)=='.'){
                readings[k]=Integer.parseInt(curReading);
                curReading="";
                k++;
                
            }else{
                curReading+=Character.toString(sensorsReadingsString.charAt(i));
            }
            i++;
        }
        return readings;
    }
}
