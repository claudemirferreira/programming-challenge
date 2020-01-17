package com.sidia.prova.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.sidia.prova.backend.dto.TitleDTO;
import com.sidia.prova.backend.model.Title;
import com.sidia.prova.backend.repository.GenreRepository;
import com.sidia.prova.backend.repository.TitleRepository;
import com.sidia.prova.backend.service.TitleService;

@Service
public class TitleServiceImpl implements TitleService {

	@Autowired
	private TitleRepository rep;
	
	@Autowired
	private GenreRepository genreRepository;

	@Override
	@Async
	public void saveAll(List<Title> lista) {
		rep.saveAll(lista);
	}

	public Page<Title> findByStartYear(String startYear, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "startYear");
		return rep.findByStartYear(startYear, pageRequest);
	}

	public Page<Title> findAll(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "startYear");
		return rep.findAll(pageRequest);
	}

	@Override
	public Page<Title> findTitleRatings(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "startYear");
		return rep.findTitleRatings(pageRequest);
	}

	@Override
	public Page<Title> findTitleRatingsForYear(String startYear, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "startYear");
		Page<Title> list = rep.findTitleRatingsForYear(startYear, pageRequest);
		
		return list;
	}
	
	public List<TitleDTO> findTitleGenre(Integer id){
		return TitleDTO.toDTO(genreRepository.getOne(id).getTitles());
	}

}