package com.sidia.prova.backend.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import com.sidia.prova.backend.model.Title;

public class TitleDTO {

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

	public static TitleDTO toDTO(Title o) {
		TitleDTO dto = new TitleDTO();
		dto.tconst = o.getTconst();
		dto.titleType = o.getTitleType();
		dto.primaryTitle = o.getPrimaryTitle();
		dto.originalTitle = o.getOriginalTitle();
		dto.adulto = o.isAdulto();
		dto.startYear = o.getStartYear();
		dto.endYear = o.getEndYear();
		dto.runtimeMinutes = o.getRuntimeMinutes();

		return dto;
	}

	public static List<TitleDTO> toDTO(List<Title> list) {
		List<TitleDTO> dtos = new ArrayList<TitleDTO>();
		
		for (Title o : list) {
			dtos.add(TitleDTO.toDTO(o));
		}
		
		return dtos;
	}

}
