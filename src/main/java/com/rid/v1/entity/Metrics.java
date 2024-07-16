package com.rid.v1.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Metrics {


    private double valuesRange;
    private double mean;
    private List<Double> maxValues;
    private List<Double> minValues;


}
