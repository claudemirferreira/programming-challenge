package com.sidia.prova.backend;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sidia.prova.backend.model.Ratings;
import com.sidia.prova.backend.repository.RatingsRepository;

@SpringBootTest
class RatingsRepositoryTests {

	@Autowired
	RatingsRepository rep;

	@Test
	void contextLoads() {
		
		rep.saveAll(Arrays.asList(
				new Ratings("tt0000001", new Float (5.6), 1567),
				new Ratings("tt0000002", new Float (6.1), 189),
				new Ratings("tt0000003", new Float (6.5), 1231),
				new Ratings("tt0000004", new Float (6.2), 115),
				new Ratings("tt0000005", new Float (6.1), 1965),
				new Ratings("tt0000006", new Float (5.2), 106),
				new Ratings("tt0000007", new Float (5.4), 622),
				new Ratings("tt0000008", new Float (5.4), 1567),
				new Ratings("tt0000009", new Float (5.4), 85),
				new Ratings("tt0000010", new Float (6.9), 5617),
				new Ratings("tt0000011", new Float (5.2), 241),
				new Ratings("tt0000012", new Float (7.4), 9536)
				)
		);
	}

}
