package com.sidia.prova.backend.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.sidia.prova.backend.model.Title;

public interface TitleService {

	public void saveAll(List<Title> lista);

	public Page<Title> findByStartYear(String startYear, int page, int size);

	public Page<Title> findAll(int page, int size);

	public Page<Title> findTitleRatings(int page, int size);

	public Page<Title> findTitleRatingsForYear(String startYear, int page, int size);

}
