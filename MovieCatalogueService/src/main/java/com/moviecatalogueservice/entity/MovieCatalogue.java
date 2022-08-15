package com.moviecatalogueservice.entity;

import java.util.List;

public class MovieCatalogue {
	private long userId;
	private String movieName;
	private int rating;
	
	
	public MovieCatalogue() {
		super();
	}
	public MovieCatalogue(long userId, String movieName, int rating) {
		super();
		this.userId = userId;
		this.movieName = movieName;
		this.rating = rating;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
}
