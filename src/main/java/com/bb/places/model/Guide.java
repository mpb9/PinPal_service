package com.bb.places.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

//ID: USER_ID + "~" + NAME
/*
create or replace TABLE PINPAL.PUBLIC.GUIDE (
	ID VARCHAR(32) NOT NULL,
	USER_ID VARCHAR(24) NOT NULL,
	NAME VARCHAR(32) NOT NULL,
	ABOUT VARCHAR(256),
	PBLC NUMBER(1,0) NOT NULL,
	DEFAULT_ZOOM NUMBER(2,0) NOT NULL,
	DEFAULT_LAT NUMBER(8,6) NOT NULL,
	DEFAULT_LNG NUMBER(9,6) NOT NULL,
	primary key (ID)
);
*/
@Entity
@Table(name = "GUIDE", schema = "PUBLIC")
public class Guide implements Serializable {

	@Serial
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank
	@Column(name = "ID", nullable = false, length = 32)
	private String id;

	@NotBlank
	@Column(name = "USER_ID", nullable = false, length = 24)
	private String userId;

	@NotBlank
	@Column(name = "NAME", nullable = false, length = 32)
	private String name;

	@Column(name = "ABOUT", length = 256)
	private String about;

	@Min(0)
	@Max(1)
	@NotNull
	@Column(name = "PBLC", nullable = false)
	private int pblc;

	@Min(0)
	@Max(20)
	@NotNull
	@Column(name = "DEFAULT_ZOOM", nullable = false)
	private Long defaultZoom;

	@Min(-90)
	@Max(90)
	@NotNull
	@Column(name = "DEFAULT_LAT", nullable = false)
	private Long defaultLat;

	@Min(-180)
	@Max(180)
	@NotNull
	@Column(name = "DEFAULT_LNG", nullable = false)
	private Long defaultLng;


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

	public Long getDefaultZoom() {
		return defaultZoom;
	}

	public void setDefaultZoom(Long defaultZoom) {
		this.defaultZoom = defaultZoom;
	}

	public Long getDefaultLat() {
		return defaultLat;
	}

	public void setDefaultLat(Long defaultLat) {
		this.defaultLat = defaultLat;
	}

	public Long getDefaultLng() {
		return defaultLng;
	}

	public void setDefaultLng(Long defaultLng) {
		this.defaultLng = defaultLng;
	}

	public int getPblc() {
		return pblc;
	}

	public void setPblc(int pblc) {
		this.pblc = pblc;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || this.getClass() != o.getClass())
			return false;

		Guide that = (Guide) o;

		return that.getId().equals(this.id);
	}

	@Override
	public String toString() {
		StringBuilder strBld = new StringBuilder();

		strBld.append("\n");
		strBld.append("***** GUIDE *****");
		strBld.append("\n");
		strBld.append("ID: ").append(this.id);
		strBld.append("\n");
		strBld.append("USER_ID: ").append(this.userId);
		strBld.append("\n");
		strBld.append("NAME: ").append(this.name);
		strBld.append("\n");
		strBld.append("ABOUT: ").append(this.about);
		strBld.append("\n");
		strBld.append("PBLC: ").append(this.pblc);
		strBld.append("\n");
		strBld.append("DEFAULT_ZOOM: ").append(this.defaultZoom);
		strBld.append("\n");
		strBld.append("DEFAULT_LAT: ").append(this.defaultLat);
		strBld.append("\n");
		strBld.append("DEFAULT_LNG: ").append(this.defaultLng);
		strBld.append("\n");
		strBld.append("***** END GUIDE *****");

		return strBld.toString();
	}

}
