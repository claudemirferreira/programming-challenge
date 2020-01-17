package com.sidia.prova.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sidia.prova.backend.repository.GenreRepository;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	GenreRepository rep;

	@Test
	void contextLoads() {
		rep.findAll();
	}

}
