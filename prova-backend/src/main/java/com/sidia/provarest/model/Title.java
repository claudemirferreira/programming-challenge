package com.sidia.provarest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Title")
public class Title implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", length = 12, nullable = false)
	private String id;

	private String titleType;

	private String primaryTitle;

	private String originalTitle;

	private boolean adulto;

	@Column(length = 4)
	private String startYear;

	@Column(length = 4)
	private String endYear;

	private String runtimeMinutes;

	@ElementCollection
	private List<String> genres;

	@OneToOne
	@JoinColumn(name = "tconst")
	@JsonManagedReference
	private Ratings ratings;

	public Title() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getPrimaryTitle() {
		return primaryTitle;
	}

	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public boolean isAdulto() {
		return adulto;
	}

	public void setAdulto(boolean adulto) {
		this.adulto = adulto;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public String getRuntimeMinutes() {
		return runtimeMinutes;
	}

	public void setRuntimeMinutes(String runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public Ratings getRatings() {
		return ratings;
	}

	public void setRatings(Ratings ratings) {
		this.ratings = ratings;
	}

	public Title(String id) {
		this.id = id;
	}

	public Title(String id, String titleType, String primaryTitle, String originalTitle, boolean adulto,
			String startYear, String endYear, String runtimeMinutes, List<String> genres) {
		this.id = id;
		this.titleType = titleType;
		this.primaryTitle = primaryTitle;
		this.originalTitle = originalTitle;
		this.adulto = adulto;
		this.startYear = startYear;
		this.endYear = endYear;
		this.runtimeMinutes = runtimeMinutes;
		this.genres = genres;
	}

	public String toString() {
		return "\n id:" + id + "\n titleType:" + titleType + "\n primaryTitle:" + primaryTitle + "\n adulto:" + adulto
				+ "\n startYear:" + startYear + "\n endYear:" + endYear + "\n runtimeMinutes:" + runtimeMinutes
				+ "\n genres:" + genres;
	}

}