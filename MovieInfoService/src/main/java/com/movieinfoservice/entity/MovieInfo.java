package com.movieinfoservice.entity;

public class MovieInfo {
	private long movieId;
	private String name;
	private String description;
	private String language;
	
	public MovieInfo() {
		super();
	}
	public MovieInfo(long movieId,String name, String description, String language) {
		super();
		this.movieId = movieId;
		this.name=name;
		this.description = description;
		this.language = language;
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
