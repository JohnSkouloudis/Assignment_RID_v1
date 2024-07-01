package com.rid.v1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sensors")
public class Sensor {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


}
