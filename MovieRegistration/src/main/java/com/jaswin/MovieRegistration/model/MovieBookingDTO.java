package com.jaswin.movieregistration.model;


import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class MovieBookingDTO {

    private Long theaterid;

    @NotBlank(message = "movie name must not be empty")
    private String movienames;

    private LocalDate moviedate;

    private String language;

    @NotNull(message = "moviestarttime must not be null")
    private LocalTime moviestarttime;

    private int price;

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
    
   
}

