package com.rid.v1.controller;

import com.rid.v1.entity.Metrics;
import com.rid.v1.response.MessageResponse;
import com.rid.v1.entity.Sensor;
import com.rid.v1.service.SensorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/sensors")
@CrossOrigin(origins = "*")
public class SensorController {

   @Autowired
    private SensorService sensorService;

    @Operation(summary = "get all available sensors")
    @GetMapping("/all")
    @ResponseBody
    public Page<Sensor> getSensors(@RequestParam int page) {
        Pageable pageable = PageRequest.of(page,10);
        return sensorService.getAllSensors(pageable);
    }

    @Operation(summary = "get a sensor's info")
    @GetMapping("{sensor_id}")
    @ResponseBody
    public Sensor getSensor(@PathVariable int sensor_id) {
        return sensorService.getSensor(sensor_id);

    }

    @Operation(summary = "add a sensor to the database")
    @PostMapping("/new")
    public ResponseEntity<MessageResponse> addSensor(@Valid @RequestBody Sensor sensor) {

        sensorService.saveSensor(sensor);

        return ResponseEntity.ok( new MessageResponse("Sensor added successfully") );

    }

    @Operation(summary = "get a sensor's metrics")
    @GetMapping("/metrics/{sensor_id}")
    @ResponseBody
    public Metrics getSensorMetrics(@PathVariable int sensor_id) {

        return sensorService.calculateSensorMetrics(sensor_id);


    }


}
