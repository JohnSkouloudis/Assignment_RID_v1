package com.rid.v1.repository;

import com.rid.v1.entity.SensorReading;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Hidden
@Repository
public interface SensorReadingRepository extends JpaRepository<SensorReading,Integer> {

    @Query(value = "select * from readings where sensor_id = :sensorId order by reading_value desc limit 10", nativeQuery = true)
    List<SensorReading> find10MaxReadingValuesBySensorId(@Param("sensorId") int sensorId);

    @Query(value = "select * from readings where sensor_id = :sensorId order by reading_value asc limit 10", nativeQuery = true)
    List<SensorReading> find10MinReadingValuesBySensorId(@Param("sensorId") int sensorId);

    @Query(value = "SELECT AVG(reading_value) from readings where sensor_id =:sensorId",nativeQuery = true)
    Double findMeanOfReadingValueBySensorId(@Param("sensorId") int sensorId);



}
