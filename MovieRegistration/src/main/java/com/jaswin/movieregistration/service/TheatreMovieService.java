package com.jaswin.movieregistration.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaswin.movieregistration.feign.TheatreClient;
import com.jaswin.movieregistration.model.*;

@Service
public class TheatreMovieService {

    @Autowired
    private MovieRegistrationService movieService;

    @Autowired
    private TheatreClient theatreClient;

    public TheatreMovieResponse getTheatreMovies(Long theatreId, LocalDate date) {

        TheatreResponse theatre = theatreClient.getTheatreById(theatreId);

        List<MovieBookingDTO> movies =
                movieService.getMoviesByTheatreAndDate(theatreId, date);

        TheatreMovieResponse response = new TheatreMovieResponse();
        response.setTheatre(theatre);
        response.setMovies(movies);

        return response;
    }
}
