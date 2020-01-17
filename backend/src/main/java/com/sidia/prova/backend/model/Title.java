package com.sidia.prova.backend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Title")
public class Title implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tconst", length = 12, nullable = false)
	private String tconst;

	private String titleType;

	private String primaryTitle;

	private String originalTitle;

	private boolean adulto;

	@Column(length = 4)
	private String startYear;

	@Column(length = 4)
	private String endYear;

	private String runtimeMinutes;

	@JsonManagedReference
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "title_genre", joinColumns = @JoinColumn(name = "tconst"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<Genre> genres = new ArrayList<Genre>();

	@OneToOne(mappedBy = "title", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Ratings ratings;

	public Title() {
	}

	public String getTconst() {
		return tconst;
	}

	public void setTconst(String tconst) {
		this.tconst = tconst;
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

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public Ratings getRatings() {
		return ratings;
	}

	public void setRatings(Ratings ratings) {
		this.ratings = ratings;
	}

	public Title(String tconst) {
		this.tconst = tconst;
	}

	public Title(String tconst, String titleType, String primaryTitle, String originalTitle, boolean adulto,
			String startYear, String endYear, String runtimeMinutes) {
		this.tconst = tconst;
		this.titleType = titleType;
		this.primaryTitle = primaryTitle;
		this.originalTitle = originalTitle;
		this.adulto = adulto;
		this.startYear = startYear;
		this.endYear = endYear;
		this.runtimeMinutes = runtimeMinutes;
	}

	public String toString() {
		return "\n tconst:" + tconst + "\n titleType:" + titleType + "\n primaryTitle:" + primaryTitle + "\n adulto:"
				+ adulto + "\n startYear:" + startYear + "\n endYear:" + endYear + "\n runtimeMinutes:"
				+ runtimeMinutes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Title))
			return false;
		return tconst != null && tconst.equals(((Title) o).getTconst());
	}

	@Override
	public int hashCode() {
		return 31;
	}

}