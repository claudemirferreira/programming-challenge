package com.sidia.prova.backend.dto;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sidia.prova.backend.model.Ratings;
import com.sidia.prova.backend.model.Title;

public class TitleDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tconst;

	private String titleType;

	private String primaryTitle;

	private String originalTitle;

	private boolean adulto;

	private String startYear;

	private String endYear;

	private String runtimeMinutes;

	private Ratings ratings;

	public TitleDTO() {
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

	public Ratings getRatings() {
		return ratings;
	}

	public void setRatings(Ratings ratings) {
		this.ratings = ratings;
	}

	public static TitleDTO toDTO(Title o) {
		return new TitleDTO(o.getTconst(), 
				o.getTitleType(), 
				o.getPrimaryTitle(), 
				o.getOriginalTitle(), 
				o.isAdulto(), 
				o.getStartYear(), 
				o.getEndYear(), 
				o.getRuntimeMinutes()
				);
	}
	
	public static List<TitleDTO> toDTO(List<Title> list) {	
		List<TitleDTO> listDTO = new ArrayList<TitleDTO>();
		for (Title o : list) {
			listDTO.add(TitleDTO.toDTO(o));
		}
		return listDTO;
	}

	public TitleDTO(String tconst, String titleType, String primaryTitle, String originalTitle, boolean adulto,
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

}