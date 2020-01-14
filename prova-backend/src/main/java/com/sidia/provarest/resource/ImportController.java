package com.sidia.provarest.resource;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidia.provarest.model.Title;
import com.sidia.provarest.response.Response;
import com.sidia.provarest.service.ImportService;

@RestController
@RequestMapping("/api/import/")
@CrossOrigin(origins = "*")
public class ImportController {

	@Autowired
	private ImportService service;

	@GetMapping(value = "title")
	public ResponseEntity<Response<List<Title>>> importTitle() throws IOException {
		System.out.println("############### importTitle ##############");
		Response<List<Title>> response = new Response<List<Title>>();
		service.importTitle();
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "ratings")
	public ResponseEntity<Response<List<Title>>> importRatings() throws IOException {
		System.out.println("############### importTitle ##############");
		Response<List<Title>> response = new Response<List<Title>>();
		service.importRatings();
		return ResponseEntity.ok(response);
	}

}