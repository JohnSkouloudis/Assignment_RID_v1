package com.rid.v1.repository;

import com.rid.v1.entity.Reading;
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


    @Query(value = "SELECT AVG(reading_value) from readings where sensor_id =:sensorId",nativeQuery = true)
    Double findMeanOfReadingValueBySensorId(@Param("sensorId") int sensorId);

    @Query(value = "Select sr.description,sr.reading_date,sr.reading_type,sr.reading_value,sr.time from readings sr join sensors s on sr.sensor_id=s.sensor_id "+
                   "WHERE (:type IS NULL OR s.type = :type) " +
                   "AND (:location IS NULL OR s.location = :location) " +
                   "AND (:time IS NULL OR sr.time = :time)",nativeQuery = true)
    List<Object[]> findSensorReadingBySensor(@Param("type") String type,
                                                     @Param("location")String location,
                                                     @Param("time") String time,
                                                     Pageable pageable);

    @Query(value = "Select sr.reading_value from readings sr join sensors s on sr.sensor_id=s.sensor_id "+
            "WHERE (:type IS NULL OR s.type = :type) " +
            "AND (:location IS NULL OR s.location = :location) " +
            "AND (:time IS NULL OR sr.time = :time)" +
            "order by sr.reading_value desc limit 10",nativeQuery = true)
    List<Double> find10MaxReadingValuesBySensor(@Param("type") String type,
                                                @Param("location")String location,
                                                @Param("time") String time,
                                                Pageable pageable);

    @Query(value = "Select sr.reading_value from readings sr join sensors s on sr.sensor_id=s.sensor_id "+
            "WHERE (:type IS NULL OR s.type = :type) " +
            "AND (:location IS NULL OR s.location = :location) " +
            "AND (:time IS NULL OR sr.time = :time)" +
            "order by sr.reading_value asc limit 10",nativeQuery = true)
    List<Double> find10MinReadingValuesBySensor(@Param("type") String type,
                                                @Param("location")String location,
                                                @Param("time") String time,
                                                Pageable pageable);
}
