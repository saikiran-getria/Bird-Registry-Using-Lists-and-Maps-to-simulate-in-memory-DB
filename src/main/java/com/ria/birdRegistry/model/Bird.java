package com.ria.birdRegistry.model;


import java.util.List;

public class Bird {
    private String id;
    private String name;
    private String family;
    private List<String> continents;
    private String added;
    private Boolean visible;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<String> getContinents() {
        return continents;
    }

    public void setContinents(List<String> continents) {
        this.continents = continents;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public Boolean isVisible() {
        if (visible == null) {
            return false;
        } else {
            return visible;
        }
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }




}
