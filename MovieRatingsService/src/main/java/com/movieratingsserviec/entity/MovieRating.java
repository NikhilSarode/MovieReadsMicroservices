package com.movieratingsserviec.entity;

public class MovieRating {
	private long movieId;
	private long userId;
	private int rating;
	
	public MovieRating() {
		super();
	}
	public MovieRating(long movieId, long userId, int rating) {
		super();
		this.movieId = movieId;
		this.userId = userId;
		this.rating = rating;
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
