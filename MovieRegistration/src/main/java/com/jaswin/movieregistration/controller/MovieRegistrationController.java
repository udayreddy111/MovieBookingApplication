package com.jaswin.movieregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jaswin.movieregistration.model.MovieBookingDTO;
import com.jaswin.movieregistration.service.MovieRegistrationService;

@RestController
@RequestMapping("/api/movies")
public class MovieRegistrationController {

    @Autowired
    private MovieRegistrationService movieService;

    // CREATE
    @PostMapping
    public MovieBookingDTO insert(@RequestBody MovieBookingDTO dto) {
        return movieService.insertMovie(dto);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public List<MovieBookingDTO> getById(@PathVariable("id") Long theaterId) {
        return movieService.getMovieById(theaterId);
    }

    // READ ALL
    @GetMapping
    public List<MovieBookingDTO> getAll() {
        return movieService.getAllMovies();
    }

    // UPDATE
    @PutMapping("/{id}")
    public MovieBookingDTO update(
            @PathVariable("id") Long theaterId,
            @RequestBody MovieBookingDTO dto) {
        return movieService.updateMovie(theaterId, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long theaterId) {
        return movieService.deleteMovie(theaterId);
    }
}
