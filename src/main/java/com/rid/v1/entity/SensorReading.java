package com.rid.v1.entity;

import jakarta.persistence.*;

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
    private String readingValue;
    @Column
    private String readingDate;
    @Column
    private String description;
    @Column
    private String time;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="sensor_id")
    private Sensor sensor;


    public SensorReading() {

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

    public String getReadingValue() {
        return readingValue;
    }

    public void setReadingValue(String readingValue) {
        this.readingValue = readingValue;
    }

    public String getReadingDate() {
        return readingDate;
    }

    public void setReadingDate(String readingDate) {
        this.readingDate = readingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
