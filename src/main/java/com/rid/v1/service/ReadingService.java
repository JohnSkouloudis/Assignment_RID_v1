package com.rid.v1.service;

import com.rid.v1.entity.Reading;
import com.rid.v1.entity.Sensor;
import com.rid.v1.repository.ReadingRepository;
import com.rid.v1.repository.SensorRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadingService {

    private final ReadingRepository readingRepository;

    private final SensorRepository sensorRepository;

    public ReadingService(ReadingRepository readingRepository, SensorRepository sensorRepository) {
        this.readingRepository = readingRepository;
        this.sensorRepository = sensorRepository;
    }

    public List<Reading> getAllReadings(int sensor_id,Pageable pageable) {
        Optional<Sensor> sensor = sensorRepository.findById(sensor_id);

        if (sensor.isPresent()) {
            return readingRepository.findBySensor(sensor.get(),pageable);
        }

        return null;
    }

}
