package com.rid.v1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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


    @NotBlank
    @NonNull
    @Column(name = "sensortype")
    @Size(min=5,max=20)
    private String sensorType;

    @NotBlank
    @NonNull
    @Column(name="vendorname")
    @Size(min=3,max=50)
    private String vendorName;

    @NotBlank
    @NonNull
    @Column(name="vendoremail")
    @Size(min=5)
    @Email
    private String vendorEmail;

    @NotBlank
    @NonNull
    @Column(name = "description")
    @Size(min=4,max=100)
    private String description;

    @NotBlank
    @NonNull
    @Column(name = "location")
    @Size(min=3,max=100)
    private String location;


    @JsonIgnore
    @OneToMany( mappedBy ="sensor", cascade = CascadeType.ALL)
    private List<Reading> readings;




}
