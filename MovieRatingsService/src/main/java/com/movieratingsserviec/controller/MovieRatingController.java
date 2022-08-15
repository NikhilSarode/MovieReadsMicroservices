package com.movieratingsserviec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieratingsserviec.entity.MovieRating;
import com.movieratingsserviec.entity.MovieRatingResponse;

@RestController
@RequestMapping("movierating")
public class MovieRatingController {
	
	@RequestMapping("{userId}")
	public MovieRatingResponse getMovieRatings(@PathVariable("")long userId){
		MovieRatingResponse resp=new MovieRatingResponse();
		List<MovieRating> mr=new ArrayList<MovieRating>();
		resp.setMoviesRating(mr);
		if(userId==555) {
			mr.add(new MovieRating(1234,555,8));
			mr.add(new MovieRating(5678,555,9));
		}
		return resp;
	}
}
