package com.bb.places.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.io.Serializable;

/*create or replace TABLE PLACES.PUBLIC.ICON (
	ID VARCHAR(98) NOT NULL,
	PIN_COLL_ID VARCHAR(65) NOT NULL,
	NAME VARCHAR(32) NOT NULL,
	COLOR VARCHAR(7) NOT NULL,
	STYLE VARCHAR(7) NOT NULL,
	primary key (ID)
);*/
@Entity
@Table(name = "ICON", schema = "PUBLIC")
public class Icon implements Serializable {
    @Serial
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @NotBlank
    @Column(name = "ID", nullable = false, length = 98)
    private String id;

    @NotBlank
    @Column(name = "PIN_COLL_ID", nullable = false, length = 65)
    private String pinCollId;

    @NotBlank
    @Column(name = "NAME", nullable = false, length = 32)
    private String name;
    @NotBlank
    @Column(name = "COLOR", nullable = false, length = 7)
    private String color;
    @NotBlank
    @Column(name = "STYLE", nullable = false, length = 7)
    private String style;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public int hashCode(){
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass())
            return false;

        Icon that = (Icon) o;

        return that.getId().equals(this.id);
    }

    @Override
    public String toString(){
        StringBuilder strBld = new StringBuilder();

        strBld.append("\n");
        strBld.append("***** ICON *****");
        strBld.append("\n");
        strBld.append("ID: ").append(this.id);
        strBld.append("\n");
        strBld.append("PIN_COLL_ID: ").append(this.pinCollId);
        strBld.append("\n");
        strBld.append("NAME: ").append(this.name);
        strBld.append("\n");
        strBld.append("COLOR: ").append(this.color);
        strBld.append("\n");
        strBld.append("STYLE: ").append(this.style);
        strBld.append("\n");
        strBld.append("***** END ICON *****");

        return strBld.toString();

    }


}
