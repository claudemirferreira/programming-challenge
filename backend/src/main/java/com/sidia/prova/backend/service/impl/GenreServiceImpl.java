package com.sidia.prova.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidia.prova.backend.model.Genre;
import com.sidia.prova.backend.repository.GenreRepository;
import com.sidia.prova.backend.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	GenreRepository rep;

	@Override
	public List<Genre> findAll() {
		return rep.findAll();
	}

}
