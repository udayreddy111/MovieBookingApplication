package com.jaswin.bookmovieservice.remote;

import com.jaswin.bookmovieservice.feign.MovieClient;
import com.jaswin.bookmovieservice.model.MovieBookingDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieRegistrationRemote {

    @Autowired
    private MovieClient movieClient;


    @CircuitBreaker(name="movieservice",fallbackMethod ="getMovieFallback" )
    public List<MovieBookingDTO> getMovies(List<Long> theatreIds, LocalDate date) {
        List<MovieBookingDTO> movies =
                movieClient.getMovies(theatreIds, date);
        return movies;
    }

    public List<MovieBookingDTO> getMovieFallback(List<Long> theatreIds, LocalDate date,Throwable exception) {
        exception.printStackTrace();
        return new ArrayList<>();
    }
}
