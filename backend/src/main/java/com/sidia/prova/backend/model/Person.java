package com.sidia.prova.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tconst", length = 12, nullable = false)
	private String tconst;

	@Column(length = 60)
	private String primaryTitle;

	@Column(length = 4)
	private String birthYear;

	@Column(length = 4)
	private String deathYear;

	public String getTconst() {
		return tconst;
	}

	public void setTconst(String tconst) {
		this.tconst = tconst;
	}

	public String getPrimaryTitle() {
		return primaryTitle;
	}

	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getDeathYear() {
		return deathYear;
	}

	public void setDeathYear(String deathYear) {
		this.deathYear = deathYear;
	}

	public Person() {
	}

	public Person(String tconst, String primaryTitle, String birthYear, String deathYear) {
		super();
		this.tconst = tconst;
		this.primaryTitle = primaryTitle;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
	}

}
