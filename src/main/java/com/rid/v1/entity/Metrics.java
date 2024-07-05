package com.rid.v1.entity;

import java.util.List;

public class Metrics {


    private double valuesRange;
    private double mean;
    private List<Double> maxValues;
    private List<Double> minValues;

    public Metrics(double valuesRange, double mean, List<Double> maxValues, List<Double> minValues) {
        this.valuesRange = valuesRange;
        this.mean = mean;
        this.maxValues = maxValues;
        this.minValues = minValues;
    }



    public double getValuesRange() {
        return valuesRange;
    }

    public void setValuesRange(double valuesRange) {
        this.valuesRange = valuesRange;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public List<Double> getMaxValues() {
        return maxValues;
    }

    public void setMaxValues(List<Double> maxValues) {
        this.maxValues = maxValues;
    }

    public List<Double> getMinValues() {
        return minValues;
    }

    public void setMinValues(List<Double> minValues) {
        this.minValues = minValues;
    }
}
