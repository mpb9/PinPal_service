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
@Table(name = "USER", schema = "PUBLIC")
public class User implements Serializable {

	@Serial
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Pattern(regexp = RegExConstants.VALID_USER_ID)
	@Column(name = "ID", nullable = false, length = 24)
	private String id;

	@NotBlank
	@Column(name = "NAME", nullable = false, length = 32)
	private String name;

	@NotBlank
	@Column(name = "EMAIL", nullable = false, length = 32)
	private String email;

	@NotBlank
	@Column(name = "PASSWORD", nullable = false, length = 32)
	private String password;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

		User that = (User) o;

		return that.getId().equals(this.id);
	}

	@Override
	public String toString() {
		StringBuilder strBld = new StringBuilder();

		strBld.append("\n");
		strBld.append("***** USER *****");
		strBld.append("\n");
		strBld.append("ID: ").append(this.id);
		strBld.append("\n");
		strBld.append("NAME: ").append(this.name);
		strBld.append("\n");
		strBld.append("EMAIL: ").append(this.email);
		strBld.append("\n");
		strBld.append("PASSWORD: ").append(this.password);
		strBld.append("\n");
		strBld.append("PBLC: ").append(this.pblc);
		strBld.append("\n");
		strBld.append("ABOUT: ").append(this.about);
		strBld.append("\n");
		strBld.append("***** END USER *****");

		return strBld.toString();
	}

}
