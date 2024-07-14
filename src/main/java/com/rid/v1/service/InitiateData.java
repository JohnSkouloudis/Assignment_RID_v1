package com.rid.v1.service;

import com.rid.v1.entity.Reading;
import com.rid.v1.entity.Sensor;
import com.rid.v1.repository.ReadingRepository;
import com.rid.v1.repository.SensorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class InitiateData {

    private static final int SENSOR_COUNT=12;

    private static final Random random = new Random();

    private static final String[] types = {"Temperature", "Humidity", "Acoustic"};
    private static final String[] locations={"Athens","Thessaloniki","Patras","Heraklion"};

    private static final String[] emails={"yahoo.com","gmail.com"};


    private final SensorRepository sensorRepository;
    private final ReadingRepository readingRepository;

    public InitiateData(SensorRepository sensorRepository, ReadingRepository readingRepository) {
        this.sensorRepository = sensorRepository;
        this.readingRepository = readingRepository;
    }



    public  void createSensors(){

        for (int i=0; i<SENSOR_COUNT; i++){

            Sensor sensor = new Sensor(types[random.nextInt(types.length)],"vendorName"+i, "vendor"+i+"@"+emails[random.nextInt(emails.length)], "description"+i, locations[random.nextInt(locations.length)]);

            sensor = sensorRepository.save(sensor);



        }

    }

    public void createSensorReadings(){


            Sensor sensor = this.sensorRepository.findById(random.nextInt(SENSOR_COUNT + 1)).get();
            List<Reading> readings = new ArrayList<>();

            for (int i = 1; i <= 11; i++) {
                Reading reading = new Reading("readingType" + i, random.nextDouble() * 10
                        , "1/7/2024", "description" + i,
                        "13:4" + i);

                reading.setSensor(sensor);
                readings.add(reading);

            }

            sensor.setReadings(readings);
            this.sensorRepository.save(sensor);


    }




    @PostConstruct
    public void setup(){
        createSensors();
        createSensorReadings();
    }

}
