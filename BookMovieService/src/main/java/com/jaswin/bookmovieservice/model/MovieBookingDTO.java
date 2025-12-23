package com.jaswin.bookmovieservice.model;

import java.time.LocalDate;

public class MovieBookingDTO {
	
	private Long theaterid;
    public Long getTheaterid() {
		return theaterid;
	}
	public void setTheaterid(Long theaterid) {
		this.theaterid = theaterid;
	}
	private Long movieId;
    private String movienames;
    private LocalDate moviedate;
    private String language;
    private String moviestarttime;
    private int price;
    
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
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
	public String getMoviestarttime() {
		return moviestarttime;
	}
	public void setMoviestarttime(String moviestarttime) {
		this.moviestarttime = moviestarttime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
    
    
}

