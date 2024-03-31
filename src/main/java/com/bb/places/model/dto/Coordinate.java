package com.bb.places.model.dto;

import jakarta.validation.constraints.NotBlank;

public class Coordinate {
    @NotBlank
    private String lat;

    @NotBlank
    private String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String toString() {
        return lat + " " + lng;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Coordinate coordinate)) {
            return false;
        }
        return coordinate.toString().equals(this.toString());
    }
}
