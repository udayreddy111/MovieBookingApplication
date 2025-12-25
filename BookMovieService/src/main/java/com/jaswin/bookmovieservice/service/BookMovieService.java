package com.jaswin.bookmovieservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jaswin.bookmovieservice.remote.MovieRegistrationRemote;
import com.jaswin.bookmovieservice.remote.TheaterRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaswin.bookmovieservice.feign.MovieClient;
import com.jaswin.bookmovieservice.feign.TheatreClient;
import com.jaswin.bookmovieservice.model.MovieBookingDTO;
import com.jaswin.bookmovieservice.model.TheatreMovieResponse;
import com.jaswin.bookmovieservice.model.TheatreResponse;

@Service
public class BookMovieService {

    @Autowired
    private TheaterRemote theatreClient;

    @Autowired
    private MovieRegistrationRemote movieClient;

    public List<TheatreMovieResponse> getBookings(
            String location, LocalDate date) {

        // 1️⃣ Get theatres by location
        List<TheatreResponse> theatres =
                theatreClient.getTheatersList(location);

        // 2️⃣ Extract theatreIds using for-loop
        List<Long> theatreIds = new ArrayList<>();
        for (TheatreResponse theatre : theatres) {
            theatreIds.add(theatre.getId());
        }

        // 3️⃣ Get all movies for those theatreIds & date
        List<MovieBookingDTO> movies =
                movieClient.getMovies(theatreIds, date);

        // 4️⃣ Prepare final response
        List<TheatreMovieResponse> responseList = new ArrayList<>();

        for (TheatreResponse theatre : theatres) {

            // 5️⃣ Filter movies for each theatre using for-loop
            List<MovieBookingDTO> theatreMovies = new ArrayList<>();

            for (MovieBookingDTO movie : movies) {
                if (movie.getTheaterid().equals(theatre.getId())) {
                    theatreMovies.add(movie);
                }
            }

            // 6️⃣ Map theatre + movies
            TheatreMovieResponse response = new TheatreMovieResponse();
            response.setTheatre(theatre);
            response.setMovies(theatreMovies);

            responseList.add(response);
        }

        return responseList;
    }
}
