package com.rid.v1.response;

import java.util.List;

public class SensorResponse {

    private String type;

    private String vendorName;

    private String vendorEmail;

    private String description;

    private String location;

    private double meanValue;

    private List<Double> maxValues;

    private List<Double> minValues;

    private double valueRange;

    public SensorResponse(String type, String vendorName, String vendorEmail, String description, String location, double meanValue, List<Double> maxValues, List<Double> minValues,  double valueRange) {
        this.type = type;
        this.vendorName = vendorName;
        this.vendorEmail = vendorEmail;
        this.description = description;
        this.location = location;
        this.meanValue = meanValue;
        this.maxValues = maxValues;
        this.minValues = minValues;
        this.valueRange = valueRange;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getMeanValue() {
        return meanValue;
    }

    public void setMeanValue(double meanValue) {
        this.meanValue = meanValue;
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

    public double getValueRange() {
        return valueRange;
    }

    public void setValueRange(double valueRange) {
        this.valueRange = valueRange;
    }
}
