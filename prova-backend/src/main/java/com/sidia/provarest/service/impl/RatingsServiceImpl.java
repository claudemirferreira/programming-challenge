package com.sidia.provarest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.sidia.provarest.model.Ratings;
import com.sidia.provarest.repository.RatingsRepository;
import com.sidia.provarest.service.RatingsService;

@Service
public class RatingsServiceImpl implements RatingsService {

	@Autowired
	private RatingsRepository rep;

	@Override
	@Async
	public void saveAll(List<Ratings> lista) {
		rep.saveAll(lista);

	}

}