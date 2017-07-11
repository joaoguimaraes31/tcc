package controller;

import models.Sensor;

public class SensorDataConverter {

    public Sensor sensorAdjustment(int sensorReading, Sensor sensor){      
        sensor.setSensorReading(sensorReading);
        sensor.sensorReadingCalibration();       
        return sensor;
    }
}
