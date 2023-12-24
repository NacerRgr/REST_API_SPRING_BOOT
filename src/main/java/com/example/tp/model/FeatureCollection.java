package com.example.tp.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.tp.model.Feature;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureCollection {

    private String type;
    private String version;
    private List<Feature> features;
    private String attribution;
    private String licence;
    private String query;
    private int limit;

    public FeatureCollection() {
    }

    public FeatureCollection(String type, String version, List<Feature> features, String attribution, String licence, String query, int limit) {
        this.type = type;
        this.version = version;
        this.features = features;
        this.attribution = attribution;
        this.licence = licence;
        this.query = query;
        this.limit = limit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}