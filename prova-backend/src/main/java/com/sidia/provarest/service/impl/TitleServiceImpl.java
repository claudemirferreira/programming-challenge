package com.sidia.provarest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.sidia.provarest.model.Title;
import com.sidia.provarest.repository.TitleRepository;
import com.sidia.provarest.service.TitleService;

@Service
public class TitleServiceImpl implements TitleService {

	@Autowired
	private TitleRepository rep;

	@Override
	@Async
	public void saveAll(List<Title> lista) {
		rep.saveAll(lista);
	}

	public List<String> listGenres() {
		return rep.listGenres();
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
		return rep.findTitleRatingsForYear(startYear, pageRequest);
	}

}