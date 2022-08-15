package com.moviecatalogueservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moviecatalogueservice.entity.MovieInfo;
import com.moviecatalogueservice.entity.MovieRating;
import com.moviecatalogueservice.entity.MovieRatingResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MovieServices {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getMovieInfoResponseFB",
			commandProperties = {
			        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),//when to consider a request as a failure
			        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"), //count of last n requests to examine
			        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),  //break the circuit if 50% of the examined request failes
			        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") }, //After what time circuit should close
			threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "20"),//a pool of 20 threads will be allocated for below request
					@HystrixProperty(name = "maxQueueSize", value = "10")// 10 additional requests can be kept waiting to get threads from above pool
			}
			)
	public MovieInfo getMovieInfoResponse(long movieId) {
		return restTemplate.getForObject("http://movie-info-service/movieinfo/"+movieId, MovieInfo.class);
	}
	
	public MovieInfo getMovieInfoResponseFB(long movieId) {
		return new MovieInfo(-1, "No Movie", "something went wrong", "NA");
	}
	
	@HystrixCommand(fallbackMethod = "getMovieRatingResponseFB")
	public MovieRatingResponse getMovieRatingResponse(long userId) {
		return restTemplate.getForObject("http://movie-ratings-service/movierating/"+userId, MovieRatingResponse.class);
	}
	
	public MovieRatingResponse getMovieRatingResponseFB(long userId) {
		List<MovieRating> mr=new ArrayList<>();
		mr.add(new MovieRating(-1,-1,-1));
		MovieRatingResponse mresp=new MovieRatingResponse();
		mresp.setMoviesRating(mr);
		return mresp;
	}
}
