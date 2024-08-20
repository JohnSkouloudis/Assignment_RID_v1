package com.rid.v1.repository;

import com.rid.v1.entity.Reading;
import com.rid.v1.entity.ReadingRecord;
import com.rid.v1.entity.Sensor;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Hidden
@Repository
public interface ReadingRepository extends JpaRepository<Reading,Integer> {

    List<Reading> findBySensorOrderByReadingValueDesc(Sensor sensor, Pageable pageable);

    List<Reading> findBySensorOrderByReadingValueAsc(Sensor sensor, Pageable pageable);

    List<Reading> findBySensor(Sensor sensor);

    Page<Reading> findBySensor(Sensor sensor, Pageable pageable);

    boolean existsBySensor(Sensor sensor);




    @Query(value = "Select new com.rid.v1.entity.ReadingRecord(sr.id,sr.readingType,sr.readingValue,sr.readingDate,sr.description,sr.time) from Reading sr join Sensor s on sr.sensor.sensorId=s.sensorId "+
                   "WHERE (:sensortype IS NULL OR s.sensorType = :sensortype) " +
                   "AND (:location IS NULL OR s.location = :location) " +
                   "AND (:time IS NULL OR sr.time = :time)")
    Page<ReadingRecord> findReadingsByParameters(@Param("sensortype") String sensorType,
                                                  @Param("location")String location,
                                                  @Param("time") String time,
                                                  Pageable pageable);



}
