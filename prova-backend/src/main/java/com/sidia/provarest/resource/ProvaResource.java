package com.sidia.provarest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidia.provarest.model.Title;
import com.sidia.provarest.response.Response;
import com.sidia.provarest.service.TitleService;

@RestController
@RequestMapping("/prova/api/")
@CrossOrigin(origins = "*")
public class ProvaResource {

	@Autowired
	private TitleService service;

	@GetMapping()
	public ResponseEntity<Response<List<Title>>> listAll() {
		Response<List<Title>> response = new Response<List<Title>>();
		try {
			List<Title> list = service.listAll();

			response.setData(list);
		} catch (DuplicateKeyException dE) {
			response.getErrors().add("xxxxxx !");
			return ResponseEntity.badRequest().body(response);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

}
