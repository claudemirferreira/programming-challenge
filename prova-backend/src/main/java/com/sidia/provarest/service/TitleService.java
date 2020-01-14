package com.sidia.provarest.service;

import java.util.List;

import com.sidia.provarest.model.Title;

public interface TitleService {

	public void saveAll(List<Title> lista);
	
	public List<String> listGenres();

}
