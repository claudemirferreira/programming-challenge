package com.sidia.provarest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidia.provarest.model.Title;
import com.sidia.provarest.repository.TitleRepository;
import com.sidia.provarest.service.TitleService;

@Service
public class TitleServiceImpl implements TitleService {

	@Autowired
	private TitleRepository rep;

	@Override
	public List<Title> listAll() {
		return rep.findAll();
	}

}
