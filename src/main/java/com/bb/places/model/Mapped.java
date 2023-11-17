package com.bb.places.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "MAPPED", schema = "PUBLIC")
public class Mapped {

	@NotNull
	@Column(name = "MAP_ID", nullable = false)
	private int mapId;

	@NotNull
	@Column(name = "PLACE_ID", nullable = false)
	private int placeId;

	@Column(name = "PLACE_COL", length = 64)
	private String placeCol;

	@Column(name = "PARENT_COL", length = 64)
	private String parentCol;

	@Id
	@NotBlank
	@Column(name = "NAME", nullable = false, length = 64)
	private String name;

	@Column(name = "ABOUT", length = 255)
	private String about;

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public String getPlaceCol() {
		return placeCol;
	}

	public void setPlaceCol(String placeCol) {
		this.placeCol = placeCol;
	}

	public String getParentCol() {
		return parentCol;
	}

	public void setParentCol(String parentCol) {
		this.parentCol = parentCol;
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

}
