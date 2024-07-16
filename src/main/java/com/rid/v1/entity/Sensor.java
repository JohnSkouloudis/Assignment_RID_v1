package com.rid.v1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sensors")
public class Sensor {

    @Id
    @Column(name = "sensorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sensorId;

    @NonNull
    @Column(name = "sensortype")
    private String sensorType;

    @NonNull
    @Column(name="vendorname")
    private String vendorName;

    @NonNull
    @Column(name="vendoremail")
    @Email
    private String vendorEmail;

    @NonNull
    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "location")
    private String location;


    @JsonIgnore
    @OneToMany( mappedBy ="sensor", cascade = CascadeType.ALL)
    private List<Reading> readings;




}
