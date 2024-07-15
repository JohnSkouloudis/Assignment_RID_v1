package com.rid.v1.controller;

import com.rid.v1.entity.Metrics;
import com.rid.v1.entity.Reading;
import com.rid.v1.entity.SensorReadingDTO;
import com.rid.v1.response.MessageResponse;
import com.rid.v1.repository.ReadingRepository;
import com.rid.v1.repository.SensorRepository;
import com.rid.v1.service.ReadingService;
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


@RestController
@RequestMapping("/api/readings")
public class ReadingController {

    @Autowired
    private ReadingRepository readingRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private ReadingService readingService;

    @GetMapping("/{sensorId}")
    public Page<Reading> getReadings(@PathVariable int sensorId, @RequestParam int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return readingService.getAllReadings(sensorId, pageable);
    }

    @Operation(summary = "add a new sensor reading to the database")
    @PostMapping("/new/{sensorId}")
    public ResponseEntity<MessageResponse> addReading(@RequestBody Reading reading, @PathVariable int sensorId) {

        if (sensorRepository.existsById(sensorId)) {

            readingService.saveReading(reading, sensorId);
            
            return ResponseEntity.ok(new MessageResponse("Sensor Reading Added Successfully"));

        }else {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Error:Sensor with id " + sensorId + " does not exist"));
        }

    }







}
