package com.movieinfoservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieinfoservice.entity.MovieInfo;
import com.movieinfoservice.entity.MovieInfoResponse;

@RestController
@RequestMapping("movieinfo")
public class MovieInfoController {
	
	@RequestMapping("{movieId}")
	public MovieInfo getMovieInfo(@PathVariable("movieId") long movieId){
		if(movieId==1234) {
			
			return new MovieInfo(1234,"Iron Man","sci fi movie in engineering","English");
			 
		}else {
			return new MovieInfo(5678,"Pursuit of Happiness","life teaching movie","All lang");
		}
	}
}
