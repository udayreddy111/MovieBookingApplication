package com.jaswin.movieregistration.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jaswin.movieregistration.model.TheatreMovieResponse;
import com.jaswin.movieregistration.service.TheatreMovieService;

@RestController
@RequestMapping("/api/theatre-movies")
public class TheatreMovieController {

    @Autowired
    private TheatreMovieService service;

    @GetMapping("/{theatreId}")
    public TheatreMovieResponse getTheatreMovies(
            @PathVariable Long theatreId,
            @RequestParam("date") LocalDate date) {

        return service.getTheatreMovies(theatreId, date);
    }
}
