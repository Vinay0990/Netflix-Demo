package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import com.example.demo.util.MovieNotFoundException;
import com.example.demo.util.View;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class MainController {

	@Autowired
	public MovieService service;

	@GetMapping("/Movies")
	@JsonView(View.min.class)
	public List<Movie> getAllMovies(@RequestParam(defaultValue = "1", name = "page") int id,
			@RequestParam(defaultValue = "10", name = "size") int size) {
		return this.service.getAllMovies(id, size);
	}

	@GetMapping("/Movies/{id}")
	public Movie getMovie(@PathVariable String id) {
		Movie movie = this.service.getMovie(id);
		if (movie == null) {
			throw new MovieNotFoundException("Movie not found for this id =" + id);
		} else {
			return movie;
		}
	}

	@PostMapping("/Movies")
	public Movie addMovie(@RequestBody Movie com) {
		return this.service.addMovie(com);
	}

	@DeleteMapping("/Movies/{id}")
	public Movie deleteMovie(@PathVariable String id) {
		Movie movie = this.service.deleteMovie(id);
		if (movie == null) {
			throw new MovieNotFoundException("Movie not found for this id =" + id);
		} else {
			return movie;
		}
	}

	@PutMapping("/Movies/{id}")
	public Movie updateMovie(@PathVariable String id, @RequestBody Movie com) {
		return this.service.updateMovie(id, com);
	}
}
