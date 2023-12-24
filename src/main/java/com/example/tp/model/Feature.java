package com.example.tp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import com.example.tp.model.Geometry;
import com.example.tp.model.Properties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {

    private String type;
    private Geometry geometry;
    private Properties properties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}