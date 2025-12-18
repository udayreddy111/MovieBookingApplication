package com.jaswin.MovieRegistration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaswin.MovieRegistration.entity.MovieBooking;
import com.jaswin.MovieRegistration.service.MovieRegistrationService;

@RestController
@RequestMapping("/Api/MoviesRegistration")
public class MovieRegistrationController {
	@Autowired
	private MovieRegistrationService movieRegistrationService ;
	@PostMapping("/insert")
	public MovieBooking insertMovieDetails(@RequestBody MovieBooking movieBooking) {

		return movieRegistrationService.insertMovieDetails(movieBooking);
	}
	@GetMapping("/getmoviedetailsbyid/{theaterid}")
	public Optional<MovieBooking> getMovieDetailsById(@PathVariable Long theaterid) {
		return movieRegistrationService.getMovieDetailsById(theaterid);
	}
	@GetMapping("/getallmoviedetails")
	public List<MovieBooking> getAllMovieDetails() {
		return movieRegistrationService.getAllMovieDetails();
	}
	@PutMapping("/updatemoviedetails/{theaterid}")
	public MovieBooking updateMovieDetailsById(@PathVariable Long theaterid,@RequestBody MovieBooking movieBooking) {
		System.out.println( "this is trying to update");
        return movieRegistrationService.updateMovieDetails(theaterid,movieBooking);
	}

    
}
