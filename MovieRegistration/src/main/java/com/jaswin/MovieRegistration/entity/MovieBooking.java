package com.jaswin.movieregistration.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="moviebooking")

public class MovieBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long theaterid;
	@NotBlank(message = "movie name must not be empty")
	
	private String movienames;
	
	private LocalDate moviedate;
	
	private String language;
	@NotNull(message ="moviestarttime must not be null")
	private LocalTime moviestarttime;
	
	private int price;
	
	public MovieBooking() {
		
	}

	public MovieBooking(Long theaterid, @NotBlank(message = "movie name must not be empty") String movienames,
			LocalDate moviedate, String language,
			@NotNull(message = "moviestarttime must not be null") LocalTime moviestarttime, int price) {
		super();
		this.theaterid = theaterid;
		this.movienames = movienames;
		this.moviedate = moviedate;
		this.language = language;
		this.moviestarttime = moviestarttime;
		this.price = price;
	}

	public Long getTheaterid() {
		return theaterid;
	}

	public void setTheaterid(Long theaterid) {
		this.theaterid = theaterid;
	}

	public String getMovienames() {
		return movienames;
	}

	public void setMovienames(String movienames) {
		this.movienames = movienames;
	}

	public LocalDate getMoviedate() {
		return moviedate;
	}

	public void setMoviedate(LocalDate moviedate) {
		this.moviedate = moviedate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public LocalTime getMoviestarttime() {
		return moviestarttime;
	}

	public void setMoviestarttime(LocalTime moviestarttime) {
		this.moviestarttime = moviestarttime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MovieBooking [theaterid=" + theaterid + ", movienames=" + movienames + ", moviedate=" + moviedate
				+ ", language=" + language + ", moviestarttime=" + moviestarttime + ", price=" + price + "]";
	}

	
}
