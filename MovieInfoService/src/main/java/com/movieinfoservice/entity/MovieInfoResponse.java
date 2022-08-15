package com.movieinfoservice.entity;

import java.util.List;

public class MovieInfoResponse {
	private List<MovieInfo> moviesInfo;

	public MovieInfoResponse() {
		super();
	}

	public List<MovieInfo> getMoviesInfo() {
		return moviesInfo;
	}

	public void setMoviesInfo(List<MovieInfo> moviesInfo) {
		this.moviesInfo = moviesInfo;
	}
	
	
}
