package com.rid.v1.service;

import com.rid.v1.entity.Metrics;
import com.rid.v1.entity.Reading;
import com.rid.v1.entity.Sensor;
import com.rid.v1.repository.ReadingRepository;
import com.rid.v1.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SensorService {


    private final SensorRepository sensorRepository;

    private final ReadingRepository readingRepository;

    public SensorService(SensorRepository sensorRepository, ReadingRepository readingRepository) {
        this.sensorRepository = sensorRepository;
        this.readingRepository = readingRepository;
    }

    public void saveSensor(Sensor sensor){
        sensorRepository.save(sensor);
    }


    public Sensor getSensor(int sensorId){
        Optional<Sensor> sensor =sensorRepository.findById(sensorId);

        if(sensor.isPresent()){
            return sensor.get();
        }else {
            return null;
        }


    }

    public Page<Sensor> getAllSensors(Pageable pageable){
        return sensorRepository.findAll(pageable);
    }

    public Metrics calculateSensorMetrics(int sensorId){


        Optional<Sensor> sensor = sensorRepository.findById(sensorId);
        Pageable pageable = PageRequest.of(0,10);

        if (sensor.isPresent() && readingRepository.existsBySensor( sensor.get() ) ){
            List<Reading> readings = readingRepository.findBySensor(sensor.get());

            double mean=0;

            for(Reading reading:readings ){

                mean += reading.getReadingValue();

            }

            mean /= readings.size();


            List<Reading> maxSensorReadings = readingRepository.findBySensorOrderByReadingValueDesc(sensor.get(),pageable);
            List<Reading> minSensorReadings = readingRepository.findBySensorOrderByReadingValueAsc(sensor.get(),pageable);

            List<Double> maxValues = new ArrayList<>();
            List<Double> minValues = new ArrayList<>();

            for (Reading sensorReading : maxSensorReadings) {
                maxValues.add(sensorReading.getReadingValue());
            }

            for (Reading sensorReading : minSensorReadings) {
                minValues.add(sensorReading.getReadingValue());
            }

            double valuesRange = Collections.max(maxValues) - Collections.min(minValues);

            Metrics metrics = new Metrics(valuesRange,mean,maxValues,minValues);
            return metrics;


        }

        return null;

    }


}
