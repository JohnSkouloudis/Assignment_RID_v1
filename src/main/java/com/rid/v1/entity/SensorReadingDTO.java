package com.rid.v1.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class SensorReadingDTO {

    private String description;
    private String readingDate;
    private String readingType;
    private double readingValue;
    private String time;

    public SensorReadingDTO() {
    }

    public SensorReadingDTO(String description, String readingDate, String readingType, double readingValue, String time) {
        this.description = description;
        this.readingDate = readingDate;
        this.readingType = readingType;
        this.readingValue = readingValue;
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReadingDate() {
        return readingDate;
    }

    public void setReadingDate(String readingDate) {
        this.readingDate = readingDate;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
