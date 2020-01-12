package com.sidia.provarest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidia.provarest.model.Title;
import com.sidia.provarest.response.Response;

@RestController
@RequestMapping("/prova/api/")
@CrossOrigin(origins = "*")
public class ProvaResource {

	@GetMapping()
	public ResponseEntity<Response<List<Title>>> listaFilmes() {
		Response<List<Title>> response = new Response<List<Title>>();
		List<Title> lista = new ArrayList<Title>();
		try {
			List<String> list = new ArrayList<>();
			list.add("acao");

			response.setData(lista);
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
