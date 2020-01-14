package com.sidia.provarest.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.sidia.provarest.model.Title;

public interface TitleService {

	public void saveAll(List<Title> lista);
	
	public List<String> listGenres();
	
	public Page<Title> findByStartYear(
            String startYear,
            int page,
            int size);
	
	public Page<Title> findAll(int page, int size);

}
