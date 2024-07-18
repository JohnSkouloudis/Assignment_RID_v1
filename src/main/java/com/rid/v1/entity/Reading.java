package com.rid.v1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    @NotBlank
    @NonNull
    @Column(name = "readingtype")
    @Size(min=4,max=30)
    private String readingType;

    @NotNull
    @NonNull
    @Column(name = "readingvalue",scale = 3)
    private Double readingValue;

    @NotBlank
    @NonNull
    @Column(name = "readingdate")
    private String readingDate;

    @NotBlank
    @NonNull
    @Column(name = "description")
    @Size(min=4,max=100)
    private String description;

    @NotBlank
    @NonNull
    @Column(name = "time")
    private String time;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="sensorId")
    private Sensor sensor;





}
