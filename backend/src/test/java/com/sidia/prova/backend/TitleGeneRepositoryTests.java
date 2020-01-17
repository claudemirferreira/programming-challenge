package com.sidia.prova.backend;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sidia.prova.backend.model.Genre;
import com.sidia.prova.backend.repository.GenreRepository;

@SpringBootTest
class TitleGeneRepositoryTests {

	@Autowired
	GenreRepository rep;

	@Test
	void contextLoads() {

		rep.saveAll(Arrays.asList(new Genre(null, "Documentary"), new Genre(null, "Short"),
				new Genre(null, "Animation"), new Genre(null, "Comedy"), new Genre(null, "Romance"),
				new Genre(null, "Sport")
				)
		);
	}

}