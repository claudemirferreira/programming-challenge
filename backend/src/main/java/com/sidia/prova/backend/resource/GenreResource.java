package com.sidia.prova.backend.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidia.prova.backend.model.Genre;
import com.sidia.prova.backend.response.Response;
import com.sidia.prova.backend.service.GenreService;

@RestController
@RequestMapping("/api/genre/")
@CrossOrigin(origins = "*")
public class GenreResource {

	@Autowired
	GenreService service;

	@GetMapping("findAll")
	public ResponseEntity<Response<List<Genre>>> findAll() {
		Response<List<Genre>> response = new Response<List<Genre>>();
		try {
			List<Genre> list = service.findAll();
			response.setData(list);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

}
