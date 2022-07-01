package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.example.demo.repo.MovieRepository;

@Service
public class MovieService{

	@Autowired
	public MovieRepository repo;

	public List<Movie> getAllMovies(int id, int size) {
		Pageable request = PageRequest.of(id, size);
		List<Movie> Movies = new ArrayList<Movie>();
		Page<Movie> page = this.repo.findAll(request);
		page.forEach(t -> Movies.add(t));
		return Movies;
	}

	public Movie getMovie(String id) {
		Optional<Movie> op = this.repo.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			return null;
		}
	}

	public Movie addMovie(Movie com) {
		return this.repo.save(com);
	}

	public Movie deleteMovie(String id) {
		Movie com = this.repo.findById(id).get();
		this.repo.delete(com);

		return com;
	}

	public Movie updateMovie(String id, Movie com) {

		Movie temp = this.repo.findById(id).get();
		temp.setTitle(com.getTitle());

		return this.repo.save(temp);
	}

}
