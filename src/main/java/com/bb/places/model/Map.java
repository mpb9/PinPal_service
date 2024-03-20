package com.bb.places.model;

import java.io.Serial;
import java.io.Serializable;

import com.bb.places.util.RegExConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "MAP", schema = "PUBLIC")
public class Map implements Serializable {

	@Serial
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank
	@Column(name = "ID", nullable = false, length = 32)
	private String id;

	@NotBlank
	// @Pattern(regexp = RegExConstants.VALID_USER_ID)
	@Column(name = "USER_ID", nullable = false, length = 24)
	private String userId;

	@NotBlank
	@Column(name = "NAME", nullable = false, length = 32)
	private String name;

	@Column(name = "ABOUT", length = 255)
	private String about;

	@Min(0)
	@Max(1)
	@NotNull
	@Column(name = "PBLC", nullable = false)
	private int pblc;

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

		Map that = (Map) o;

		return that.getId().equals(this.id);
	}

	@Override
	public String toString() {
		StringBuilder strBld = new StringBuilder();

		strBld.append("\n");
		strBld.append("***** MAP *****");
		strBld.append("\n");
		strBld.append("ID: ").append(this.id);
		strBld.append("\n");
		strBld.append("USER_ID: ").append(this.userId);
		strBld.append("\n");
		strBld.append("NAME: ").append(this.name);
		strBld.append("\n");
		strBld.append("PBLC: ").append(this.pblc);
		strBld.append("\n");
		strBld.append("ABOUT: ").append(this.about);
		strBld.append("\n");
		strBld.append("***** END MAP *****");

		return strBld.toString();
	}

}
