package com.rid.v1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table (name="readings")
public class SensorReading {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String readingType;
    @Column
    private double readingValue;
    @Column
    private LocalDate readingDate;
    @Column
    private String description;
    @Column
    private LocalTime time;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="sensor_id")
    private Sensor sensor;


    public SensorReading() {

    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReadingType() {
        return readingType;
    }

    public void setReadingType(String readingType) {
        this.readingType = readingType;
    }

    public double getReadingValue() {
        return readingValue;
    }

    public void setReadingValue(double readingValue) {
        this.readingValue = readingValue;
    }

    public LocalDate getReadingDate() {
        return readingDate;
    }

    public void setReadingDate(LocalDate readingDate) {
        this.readingDate = readingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
