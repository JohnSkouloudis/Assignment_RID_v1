package com.rid.v1.repository;

import com.rid.v1.entity.Sensor;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Hidden
@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {

}
