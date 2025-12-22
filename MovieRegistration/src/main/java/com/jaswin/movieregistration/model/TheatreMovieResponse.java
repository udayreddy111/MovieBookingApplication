package com.jaswin.movieregistration.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "theatre", "movies" })
public class TheatreMovieResponse {

    private TheatreResponse theatre;
    private List<MovieBookingDTO> movies;

    public TheatreResponse getTheatre() {
        return theatre;
    }

    public void setTheatre(TheatreResponse theatre) {
        this.theatre = theatre;
    }

    public List<MovieBookingDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieBookingDTO> movies) {
        this.movies = movies;
    }
}

