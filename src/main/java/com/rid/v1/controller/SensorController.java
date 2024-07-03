package com.rid.v1.controller;

import com.rid.v1.entity.Sensor;
import com.rid.v1.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @Autowired
    private SensorRepository sensorRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<Sensor> getSensors() {
        return sensorRepository.findAll();
    }

    @GetMapping("{sensor_id}")
    @ResponseBody
    public Sensor getSensor(@PathVariable int sensor_id) {
        Optional<Sensor>  sensor = sensorRepository.findById(sensor_id);
        return sensor.orElse(null);
    }

}
