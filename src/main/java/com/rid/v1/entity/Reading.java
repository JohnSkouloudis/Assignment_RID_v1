package com.rid.v1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="readings")
public class Reading {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "readingtype")
    private String readingType;

    @NonNull
    @Column(name = "readingvalue")
    private double readingValue;

    @NonNull
    @Column(name = "readingdate")
    private String readingDate;

    @NonNull
    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "time")
    private String time;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="sensorId")
    private Sensor sensor;





}
