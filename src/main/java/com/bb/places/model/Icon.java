package com.bb.places.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

public class Icon {
    @NotBlank
    private String name;
    @NotBlank
    private String color;
    @NotBlank
    private String style;
    @NotBlank
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String toString() {
        return name + " " + color + " " + style + " " + number;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Icon icon)) {
            return false;
        }
        return icon.toString().equals(this.toString());
    }



}
