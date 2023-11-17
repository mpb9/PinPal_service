package com.bb.places.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLACE", schema = "PUBLIC")
public class Place {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
