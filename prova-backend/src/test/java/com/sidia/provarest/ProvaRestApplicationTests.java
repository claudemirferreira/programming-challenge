package com.sidia.provarest;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sidia.provarest.service.ImportTsvService;

@SpringBootTest
class ProvaRestApplicationTests {
	
	@Autowired
	ImportTsvService service;

	@Test
	void contextLoads() throws IOException {
		service.importTitle();
	}

}
