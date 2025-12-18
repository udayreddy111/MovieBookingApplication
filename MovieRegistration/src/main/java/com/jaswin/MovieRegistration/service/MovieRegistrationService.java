package com.jaswin.MovieRegistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaswin.MovieRegistration.entity.MovieBooking;
import com.jaswin.MovieRegistration.repository.MovieRepository;

@Service
public class MovieRegistrationService {
	
	@Autowired
	private  MovieRepository  movieRepository;
	

	public MovieBooking insertMovieDetails(MovieBooking movieBooking) {
		
		return movieRepository.save(movieBooking);
	}
   public Optional<MovieBooking> getMovieDetailsById(Long theaterid) {
	return movieRepository.findById(theaterid);
   }
   public List<MovieBooking> getAllMovieDetails() {
	   return movieRepository.findAll();
   }
   public MovieBooking updateMovieDetails(Long theaterid, MovieBooking movieBooking) {
	   
	 MovieBooking exsistingmovieBooking =   movieRepository.findById(theaterid).orElseThrow(() -> new RuntimeException("MovieDetails not found with Theaterid: " + theaterid));
	 
	 exsistingmovieBooking.setMovienames(movieBooking.getMovienames());
	 exsistingmovieBooking.setMoviedate(movieBooking.getMoviedate());
	 exsistingmovieBooking.setLanguage(movieBooking.getLanguage());
	 exsistingmovieBooking.setMoviestarttime(movieBooking.getMoviestarttime());
	 exsistingmovieBooking.setPrice(movieBooking.getPrice());
	 
	 
	 return  movieRepository.save(exsistingmovieBooking);
   }
}

	
	


