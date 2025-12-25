package com.jaswin.bookmovieservice.feign;

import com.jaswin.bookmovieservice.model.MovieBookingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "movie-service", url = "http://localhost:8080")
public interface MovieClient {

    @GetMapping("/api/movies/by-theatres-date")
    List<MovieBookingDTO> getMovies(
            @RequestParam("theatreIds") List<Long> theatreIds,
            @RequestParam("date") LocalDate date);
}