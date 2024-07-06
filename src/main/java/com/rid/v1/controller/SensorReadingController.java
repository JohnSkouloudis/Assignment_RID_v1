package com.rid.v1.controller;

import com.rid.v1.entity.Metrics;
import com.rid.v1.entity.SensorReadingDTO;
import com.rid.v1.response.MessageResponse;
import com.rid.v1.request.SensorReadingRequest;
import com.rid.v1.entity.SensorReading;
import com.rid.v1.repository.SensorReadingRepository;
import com.rid.v1.repository.SensorRepository;
import com.rid.v1.response.SensorReadingResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/sensorreadings")
public class SensorReadingController {

    @Autowired
    private SensorReadingRepository sensorReadingRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Operation(summary = "add a new sensor reading to the database")
    @PostMapping("/new/{sensorId}")
    public ResponseEntity<?> addSensorReading(@RequestBody SensorReadingRequest sensorReadingRequest, @PathVariable int sensorId) {

        if (sensorRepository.existsById(sensorId)) {

            SensorReading reading = new SensorReading();

            reading.setReadingDate( sensorReadingRequest.getReadingDate() );
            reading.setReadingType( sensorReadingRequest.getReadingType() );
            reading.setReadingValue( sensorReadingRequest.getReadingValue() );
            reading.setDescription( sensorReadingRequest.getDescription() );
            reading.setReadingDate( sensorReadingRequest.getReadingDate() );
            reading.setTime(sensorReadingRequest.getTime());
            reading.setSensor(sensorRepository.findById(sensorId).get());

            sensorReadingRepository.save(reading);
            return ResponseEntity.ok(new MessageResponse("Sensor Reading Added Successfully"));

        }else {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Error:Sensor with id " + sensorId + " does not exist"));
        }

    }


    @Operation(summary = "search sensor reading based on location,time and sensor type")
    @GetMapping("/search")
    public SensorReadingResponse SearchSensorReadings(@RequestParam int page, @RequestParam(required = false) String type, @RequestParam(required = false) String location, @RequestParam(required = false) String time) {

        Pageable pageable = PageRequest.of(page,10);

        List<Object[]> results = sensorReadingRepository.findSensorReadingBySensor(type, location, time,pageable);

        List<SensorReadingDTO> sensorReadings= new ArrayList<>();

        for(Object[] result:results){
            SensorReadingDTO reading = new SensorReadingDTO();
            reading.setDescription( (String) result[0]);
            reading.setReadingDate((String) result[1]);
            reading.setReadingType((String) result[2]);
            reading.setReadingValue((double) result[3]);
            reading.setTime((String) result[4]);
            sensorReadings.add(reading);
        }

        List<Double> maxValues = new ArrayList<>();
        List<Double> minValues =new ArrayList<>();

        double mean=0;
        for (SensorReadingDTO reading :sensorReadings) {
             maxValues.add(reading.getReadingValue());
             minValues.add(reading.getReadingValue());
            mean+=reading.getReadingValue();
        }

        mean /= sensorReadings.size();



        double valueRange= Collections.max(maxValues) - Collections.min(minValues);

        Metrics metrics = new Metrics(valueRange,mean,null,null);


        SensorReadingResponse response = new SensorReadingResponse(sensorReadings,metrics);

        return response;

    }



}
