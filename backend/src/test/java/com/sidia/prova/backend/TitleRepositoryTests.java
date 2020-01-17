package com.sidia.prova.backend;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sidia.prova.backend.model.Title;
import com.sidia.prova.backend.repository.TitleRepository;

@SpringBootTest
class TitleRepositoryTests {

	@Autowired
	TitleRepository rep;

	@Test
	void contextLoads() {

		List<Title> list = new ArrayList<Title>();

		list.add(new Title("tt0000001", "short", "Carmencita", "Carmencita", false, "1894", "", "1"));
		list.add(new Title("tt0000002", "short", "Le clown et ses chiens", "Le clown et ses chiens", false, "1892",
				null, "5"));
		list.add(new Title("tt0000003", "short", "Pauvre Pierrot", "Pauvre Pierrot", false, "1892", null, "45"));
		list.add(new Title("tt0000004", "short", "Un bon bock", "Un bon bock", false, "1892", null, null));
		list.add(new Title("tt0000005", "short", "Blacksmith Scene", "Blacksmith Scene", false, "1893", null, "1"));
		list.add(new Title("tt0000006", "short", "Chinese Opium Den", "Chinese Opium Den", false, "1894", null, "1"));
		list.add(new Title("tt0000007", "short", "Corbett and Courtney Before ", "Corbett and Courtney Before ", false,
				"1894", null, "1"));
		list.add(new Title("tt0000008", "short", "Edison Kinetoscopic ", "Edison Kinetoscopic ", false, "1894", null,
				"1"));
		list.add(new Title("tt0000009", "short", "Miss Jerry", "Miss Jerry", false, "1895", null, "1"));
		list.add(new Title("tt0000010", "short", "Exiting the Factory", "Exiting the Factory", false, "1895", null,
				"1"));
		list.add(new Title("tt0000011", "short", "Akrobatisches the Factory", "Akrobatisches the Factory", false,
				"1895", null, "1"));
		list.add(new Title("tt0000012", "short", "The Arrival the Factory", "The Arrival the Factory", false, "1895",
				null, "1"));

		rep.saveAll(list);

	}

}
