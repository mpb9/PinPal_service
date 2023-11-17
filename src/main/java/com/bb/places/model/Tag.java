package com.bb.places.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TAG", schema = "PUBLIC")
public class Tag {

	@Id
	@Column(name = "ID", nullable = false, length = 64)
	private String id;

	@NotNull
	@Column(name = "MAP_ID", nullable = false)
	private int mapId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

}
