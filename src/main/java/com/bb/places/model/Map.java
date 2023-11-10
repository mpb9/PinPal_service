package com.bb.places.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "maps")
public class Map {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "title")
	private String title;

	@Column(name = "pblc")
	private Boolean pblc;

	public int getId() {
		return id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getPblc() {
		return pblc;
	}

	public void setPblc(Boolean pblc) {
		this.pblc = pblc;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
