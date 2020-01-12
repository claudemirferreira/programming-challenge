package com.sidia.provarest;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sidia.provarest.service.ImportTsvService;

@SpringBootApplication
public class ProvaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvaRestApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(ImportTsvService rep) {
		return args -> {
			importarDados(rep);
		};
	}
	
	private void importarDados(ImportTsvService rep) throws IOException {
		//rep.importCep();
	}

}
