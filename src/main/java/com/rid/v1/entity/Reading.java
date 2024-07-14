package com.rid.v1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="readings")
public class Reading {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "readingtype")
    private String readingType;
    @Column(name = "readingvalue")
    private double readingValue;
    @Column(name = "readingdate")
    private String readingDate;
    @Column(name = "description")
    private String description;
    @Column(name = "time")
    private String time;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="sensorId")
    private Sensor sensor;

    public Reading(String readingType, double readingValue, String readingDate, String description, String time) {
        this.readingType = readingType;
        this.readingValue = readingValue;
        this.readingDate = readingDate;
        this.description = description;
        this.time = time;

    }

         public Reading() {

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
