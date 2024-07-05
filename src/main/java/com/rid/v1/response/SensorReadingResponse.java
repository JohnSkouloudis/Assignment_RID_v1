package com.rid.v1.response;


import com.rid.v1.entity.Metrics;
import com.rid.v1.entity.SensorReadingDTO;


import java.util.List;

public class SensorReadingResponse {

    private List<SensorReadingDTO> sensorReadings;
    private Metrics metrics;

    public SensorReadingResponse(List<SensorReadingDTO> sensorReadings, Metrics metrics) {
        this.sensorReadings = sensorReadings;
        this.metrics = metrics;
    }

    public List<SensorReadingDTO> getSensorReadings() {
        return sensorReadings;
    }

    public void setSensorReadings(List<SensorReadingDTO> sensorReadings) {
        this.sensorReadings = sensorReadings;
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }
}
