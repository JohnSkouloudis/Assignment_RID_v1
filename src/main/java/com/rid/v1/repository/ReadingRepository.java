package com.rid.v1.repository;

import com.rid.v1.entity.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingRepository extends JpaRepository<SensorReading,Integer> {



}
