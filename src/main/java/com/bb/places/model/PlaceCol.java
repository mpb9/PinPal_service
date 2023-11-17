package com.bb.places.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "PLACE_COL", schema = "PUBLIC")
public class PlaceCol {

	@Id
	@NotBlank
	@Column(name = "NAME", nullable = false, length = 64)
	private String name;

	@NotBlank
	@Column(name = "USER_ID", nullable = false, length = 32)
	private String userId;

	@NotNull
	@Column(name = "PLACE_ID", nullable = false)
	private int placeId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

}
