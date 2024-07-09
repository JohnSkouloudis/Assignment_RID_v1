package com.rid.v1.controller;

import com.rid.v1.entity.Metrics;
import com.rid.v1.entity.SensorReading;
import com.rid.v1.repository.SensorReadingRepository;
import com.rid.v1.response.MessageResponse;
import com.rid.v1.request.SensorRequest;
import com.rid.v1.entity.Sensor;
import com.rid.v1.repository.SensorRepository;
import com.rid.v1.response.SensorResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @Autowired
    private SensorRepository sensorRepository;
    @Autowired
    private SensorReadingRepository sensorReadingRepository;

    @Operation(summary = "get all available sensors")
    @GetMapping("/all")
    @ResponseBody
    public Page<Sensor> getSensors(@RequestParam int page) {
        Pageable pageable = PageRequest.of(page,10);
        return sensorRepository.findAll(pageable);
    }

    @Operation(summary = "get a sensors info")
    @GetMapping("{sensor_id}")
    @ResponseBody
    public Sensor getSensor(@PathVariable int sensor_id) {
        Optional<Sensor>  sensor = sensorRepository.findById(sensor_id);
        return sensor.orElse(null);
    }

    @Operation(summary = "add a sensor to the database")
    @PostMapping("/new")
    public ResponseEntity<MessageResponse> addSensor(@RequestBody SensorRequest sensorRequest) {
        Sensor sensor = new Sensor();
        sensor.setDescription(sensorRequest.getDescription());
        sensor.setType(sensorRequest.getType());
        sensor.setLocation(sensorRequest.getLocation());
        sensor.setVendorEmail(sensorRequest.getVendorEmail());
        sensor.setVendorName(sensorRequest.getVendorName());

        sensorRepository.save(sensor);

        return ResponseEntity.ok( new MessageResponse("Sensor added successfully") );

    }

    @Operation(summary = "get a sensors metrics")
    @GetMapping("/metrics/{sensor_id}")
    @ResponseBody
    public SensorResponse getSensorMetrics(@PathVariable int sensor_id) {

        Sensor sensor = sensorRepository.findById(sensor_id).get();


        if(sensor == null  || sensorReadingRepository.findMeanOfReadingValueBySensorId(sensor_id)==null) {
            return null;
        }


            Double meanValue = sensorReadingRepository.findMeanOfReadingValueBySensorId(sensor_id);


            List<SensorReading> maxSensorReadings = sensorReadingRepository.find10MaxReadingValuesBySensorId(sensor_id);
            List<SensorReading> minSensorReadings = sensorReadingRepository.find10MinReadingValuesBySensorId(sensor_id);

            List<Double> maxValues = new ArrayList<>();
            List<Double> minValues = new ArrayList<>();

            for (SensorReading sensorReading : maxSensorReadings) {
                maxValues.add(sensorReading.getReadingValue());
            }

            for (SensorReading sensorReading : minSensorReadings) {
                minValues.add(sensorReading.getReadingValue());
            }

            double valueRange = Collections.max(maxValues) - Collections.min(minValues);
            Metrics metrics = new Metrics(valueRange,meanValue,maxValues,minValues);

            SensorResponse sensorResponse = new SensorResponse(sensor.getType(), sensor.getVendorName(), sensor.getVendorEmail()
                    , sensor.getDescription()
                    , sensor.getLocation(), metrics);



        return sensorResponse;

    }


}
