package com.bb.places.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.io.Serializable;

/*create or replace TABLE PLACES.PUBLIC.PIN (
	ID VARCHAR(98) NOT NULL,
	PLACE_ID VARCHAR(32) NOT NULL,
	PIN_COLL_ID VARCHAR(65) NOT NULL,
	NAME VARCHAR(32) NOT NULL,
	ADDRESS VARCHAR(256),
	ABOUT VARCHAR(255),
	LAT NUMBER(9,6) NOT NULL,
	LNG NUMBER(9,6) NOT NULL,
	primary key (ID)
);*/
@Entity
@Table(name = "PIN", schema = "PUBLIC")
public class Pin implements Serializable {

    @Serial
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @NotBlank
    @Column(name = "ID", nullable = false, length = 512)
    private String id;

    @NotBlank
    @Column(name = "PLACE_ID", nullable = false, length = 512)
    private String placeId;

    @NotBlank
    @Column(name = "PIN_COLL_ID", nullable = false, length = 65)
    private String pinCollId;

    @NotBlank
    @Column(name = "NAME", nullable = false, length = 32)
    private String name;

    @Column(name = "ABOUT", length = 256)
    private String about;

    @Column(name = "PHOTO", length = 256)
    private String photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPinCollId() {
        return pinCollId;
    }

    public void setPinCollId(String pinCollId) {
        this.pinCollId = pinCollId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass())
            return false;
        Pin pin = (Pin) o;
        return pin.toString().equals(this.toString());
    }

    @Override
    public String toString(){
        StringBuilder strBld = new StringBuilder();
        strBld.append("\n");
        strBld.append("***** PIN *****");
        strBld.append("\n");
        strBld.append("ID: ").append(this.id);
        strBld.append("\n");
        strBld.append("PLACE_ID: ").append(this.placeId);
        strBld.append("\n");
        strBld.append("PIN_COLL_ID: ").append(this.pinCollId);
        strBld.append("\n");
        strBld.append("NAME: ").append(this.name);
        strBld.append("\n");
        strBld.append("ABOUT: ").append(this.about);
        strBld.append("\n");
        strBld.append("PHOTO: ").append(this.photo);
        strBld.append("\n");
        strBld.append("***** END PIN *****");
        return strBld.toString();
    }
}
