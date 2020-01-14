package com.sidia.provarest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Name")
public class Name implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	private String primaryName;

	@Column(length = 4)
	private String birthYear;

	@Column(length = 4)
	private String deathYear;

	@ElementCollection
	private List<String> primaryProfession;

	@ElementCollection
	private List<String> knownForTitles;

	@OneToOne
	@JoinColumn(name = "tconst")
	@JsonManagedReference
	private Title title;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public String getPrimaryName() {
		return primaryName;
	}

	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
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

	public List<String> getPrimaryProfession() {
		return primaryProfession;
	}

	public void setPrimaryProfession(List<String> primaryProfession) {
		this.primaryProfession = primaryProfession;
	}

	public List<String> getKnownForTitles() {
		return knownForTitles;
	}

	public void setKnownForTitles(List<String> knownForTitles) {
		this.knownForTitles = knownForTitles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Name(Integer id, String primaryName, String birthYear, String deathYear, List<String> primaryProfession,
			List<String> knownForTitles, String tconst) {
		this.id = id;
		this.primaryName = primaryName;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
		this.primaryProfession = primaryProfession;
		this.knownForTitles = knownForTitles;
		this.title = new Title(tconst);
	}
	
	public String toString() {		
		return "\n id:" + this.id + 
		"\n primaryName:" + this.primaryName + 
		"\n birthYear:" + this.birthYear + 
		"\n deathYear:" + this.deathYear + 
		"\n primaryProfession:" + this.primaryProfession + 
		"\n knownForTitles:" + this.knownForTitles +
		"\n title:" + this.title.getTconst();
		
	}

}