package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.util.View;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("movies")
public class Movie {
	@Id
	@JsonView(View.min.class)
	private String id;

	@JsonView(View.min.class)
	private String plot;

	@JsonView(View.min.class)
	private String poster;

	@JsonView(View.min.class)
	private String title;

	private String fullplot;

	private String lastupdated;

	private String type;

	private List<String> genres = new ArrayList<String>();

	private List<String> cast = new ArrayList<String>();

	private List<String> languages = new ArrayList<String>();

	private List<String> directors = new ArrayList<String>();

	private List<String> writers = new ArrayList<String>();

	private List<String> countries = new ArrayList<String>();
}
