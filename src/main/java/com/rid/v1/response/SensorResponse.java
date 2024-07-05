package com.rid.v1.response;

import com.rid.v1.entity.Metrics;

public class SensorResponse {

    private String type;

    private String vendorName;

    private String vendorEmail;

    private String description;

    private String location;

    Metrics metrics;

    public SensorResponse(String type, String vendorName, String vendorEmail, String description, String location,Metrics metrics) {
        this.type = type;
        this.vendorName = vendorName;
        this.vendorEmail = vendorEmail;
        this.description = description;
        this.location = location;
        this.metrics=metrics;
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

    public Metrics getMetrics() {
        return metrics;
    }

    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }
}
