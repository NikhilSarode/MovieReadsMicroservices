package com.movieratingsserviec.entity;

import java.util.List;

public class MovieRatingResponse {
	private List<MovieRating> moviesRating;

	public MovieRatingResponse() {
		super();
	}

	public List<MovieRating> getMoviesRating() {
		return moviesRating;
	}

	public void setMoviesRating(List<MovieRating> moviesRating) {
		this.moviesRating = moviesRating;
	}
	
	
}	
