package com.rid.v1.controller;

import com.rid.v1.response.MessageResponse;
import com.rid.v1.request.SensorReadingRequest;
import com.rid.v1.entity.SensorReading;
import com.rid.v1.repository.SensorReadingRepository;
import com.rid.v1.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensorreadings")
public class SensorReadingController {

    @Autowired
    private SensorReadingRepository sensorReadingRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @PostMapping("/new/{sensorId}")
    public ResponseEntity<?> addSensorReading(@RequestBody SensorReadingRequest sensorReadingRequest, @PathVariable int sensorId) {

        if (sensorRepository.existsById(sensorId)) {

            SensorReading reading = new SensorReading();

            reading.setReadingDate( sensorReadingRequest.getReadingDate() );
            reading.setReadingType( sensorReadingRequest.getReadingType() );
            reading.setReadingValue( sensorReadingRequest.getReadingValue() );
            reading.setDescription( sensorReadingRequest.getDescription() );
            reading.setReadingDate( sensorReadingRequest.getReadingDate() );
            reading.setSensor(sensorRepository.findById(sensorId).get());

            sensorReadingRepository.save(reading);
            return ResponseEntity.ok(new MessageResponse("Sensor Reading Added Successfully"));

        }else {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Error:Sensor with id " + sensorId + " does not exist"));
        }

    }

    @GetMapping("/search")
    public List<SensorReading> SearchSensorReadings(@RequestParam(required = false) String type, @RequestParam(required = false) String location,@RequestParam(required = false) String time) {


        return null;
    }

}
