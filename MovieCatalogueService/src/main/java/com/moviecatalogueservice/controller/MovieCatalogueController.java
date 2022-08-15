package com.moviecatalogueservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moviecatalogueservice.entity.MovieCatalogue;
import com.moviecatalogueservice.entity.MovieInfo;
import com.moviecatalogueservice.entity.MovieRating;
import com.moviecatalogueservice.entity.MovieRatingResponse;
import com.moviecatalogueservice.service.MovieServices;

@RestController
@RequestMapping("moviecatalogue")
public class MovieCatalogueController {
	
	@Autowired
	MovieServices movieServices;
	
	@RequestMapping("{userId}")
	public List<MovieCatalogue> getMovieCatalogue(@PathVariable("userId")long userId){
		List<MovieCatalogue> movieCatalogueList=new ArrayList<>();
		
		MovieRatingResponse movieRatingResponse=movieServices.getMovieRatingResponse(userId);
		for (MovieRating movieRating : movieRatingResponse.getMoviesRating()) {
			MovieInfo movieInfoResponse=movieServices.getMovieInfoResponse(movieRating.getMovieId());
			movieCatalogueList.add(new MovieCatalogue(userId,movieInfoResponse.getName(),movieRating.getRating()));
		}
		return movieCatalogueList;
		
	}
}
