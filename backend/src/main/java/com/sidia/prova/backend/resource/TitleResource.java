package com.sidia.prova.backend.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sidia.prova.backend.model.Genre;
import com.sidia.prova.backend.model.Title;
import com.sidia.prova.backend.response.Response;
import com.sidia.prova.backend.service.GenreService;
import com.sidia.prova.backend.service.TitleService;

@RestController
@RequestMapping("/api/title/")
@CrossOrigin(origins = "*")
public class TitleResource {

	@Autowired
	private TitleService service;

	@Autowired
	private GenreService genreService;

	@GetMapping("findAll")
	public ResponseEntity<Response<List<Genre>>> findAll() {
		Response<List<Genre>> response = new Response<List<Genre>>();
		try {
			List<Genre> list = genreService.findAll();
			response.setData(list);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping("findByStartYear")
	public Page<Title> search(
			@RequestParam(value = "startYear", required = false, defaultValue = "0") Integer startYear,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {

		if (startYear == 0)
			return service.findTitleRatings(page, size);
		else
			return service.findTitleRatingsForYear(startYear + "", page, size);

	}

	@GetMapping("findTitleRatings")
	public Page<Title> findTitleRatings(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		Page<Title> list = service.findTitleRatings(page, size);
		return list;

	}
}
