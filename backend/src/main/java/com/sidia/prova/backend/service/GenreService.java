package com.sidia.prova.backend.service;

import java.util.List;

import com.sidia.prova.backend.model.Genre;

public interface GenreService {

	List<Genre> findAll();
	
	Genre getOne(Integer id);

}