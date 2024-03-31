package com.bb.places.model.dto;

import jakarta.validation.constraints.NotBlank;

public class POV {
    @NotBlank
    private Coordinate center;
    @NotBlank
    private String zoom;

    public Coordinate getCenter() {
        return center;
    }

    public void setCenter(Coordinate center) {
        this.center = center;
    }

    public String getZoom() {
        return zoom;
    }

    public void setZoom(String zoom) {
        this.zoom = zoom;
    }

    public String toString() {
        return center.toString() + " " + zoom;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof POV pov)) {
            return false;
        }
        return pov.toString().equals(this.toString());
    }
}
