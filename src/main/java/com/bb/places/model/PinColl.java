package com.bb.places.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.io.Serializable;

/* create or replace TABLE PLACES.PUBLIC.PIN_COLL (
	ID VARCHAR(65) NOT NULL,
	USER_ID VARCHAR(24) NOT NULL,
	GUIDE_ID VARCHAR(32) NOT NULL,
	ICON_ID VARCHAR(98) NOT NULL,
	NAME VARCHAR(32) NOT NULL,
	primary key (ID)
); */
@Entity
@Table(name = "PIN_COLL", schema = "PUBLIC")
public class PinColl implements Serializable {

    @Serial
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @NotBlank
    @Column(name = "ID", nullable = false, length = 65)
    private String id;

    @NotBlank
    @Column(name = "USER_ID", nullable = false, length = 24)
    private String userId;

    @NotBlank
    @Column(name = "GUIDE_ID", nullable = false, length = 32)
    private String guideId;

    @NotBlank
    @Column(name = "ICON_ID", nullable = false, length = 98)
    private String iconId;

    @NotBlank
    @Column(name = "NAME", nullable = false, length = 32)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGuideId() {
        return guideId;
    }

    public void setGuideId(String guideId) {
        this.guideId = guideId;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PinColl pinColl = (PinColl) obj;
        return id != null ? id.equals(pinColl.id) : pinColl.id == null;
    }

    @Override
    public String toString() {
        StringBuilder strBld = new StringBuilder();

        strBld.append("\n");
        strBld.append("***** PIN_COLL *****");
        strBld.append("\n");
        strBld.append("ID: ").append(this.id);
        strBld.append("\n");
        strBld.append("USER_ID: ").append(this.userId);
        strBld.append("\n");
        strBld.append("GUIDE_ID: ").append(this.guideId);
        strBld.append("\n");
        strBld.append("ICON_ID: ").append(this.iconId);
        strBld.append("\n");
        strBld.append("NAME: ").append(this.name);
        strBld.append("\n");
        strBld.append("***** END PIN_COLL *****");

        return strBld.toString();
    }
}
