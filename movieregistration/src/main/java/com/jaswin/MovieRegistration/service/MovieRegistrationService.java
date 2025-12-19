package com.jaswin.movieregistration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaswin.movieregistration.entity.MovieBooking;
import com.jaswin.movieregistration.model.MovieBookingDTO;
import com.jaswin.movieregistration.repository.MovieRepository;

@Service
public class MovieRegistrationService {

    @Autowired
    private MovieRepository movieRepository;

    // ---------- DTO → Entity ----------
    private MovieBooking convertToEntity(MovieBookingDTO dto) {
        MovieBooking movie = new MovieBooking();
        movie.setTheaterid(dto.getTheaterid());
        movie.setMovienames(dto.getMovienames());
        movie.setMoviedate(dto.getMoviedate());
        movie.setLanguage(dto.getLanguage());
        movie.setMoviestarttime(dto.getMoviestarttime());
        movie.setPrice(dto.getPrice());
        return movie;
    }

    // ---------- Entity → DTO ----------
    private MovieBookingDTO convertToDTO(MovieBooking entity) {
        MovieBookingDTO dto = new MovieBookingDTO();
        dto.setTheaterid(entity.getTheaterid());
        dto.setMovienames(entity.getMovienames());
        dto.setMoviedate(entity.getMoviedate());
        dto.setLanguage(entity.getLanguage());
        dto.setMoviestarttime(entity.getMoviestarttime());
        dto.setPrice(entity.getPrice());
        return dto;
    }

    // ---------- CREATE ----------
    public MovieBookingDTO insertMovie(MovieBookingDTO dto) {
        MovieBooking savedEntity = movieRepository.save(convertToEntity(dto));
        return convertToDTO(savedEntity);
    }

    // ---------- READ BY ID ----------
    public MovieBookingDTO getMovieById(Long theaterId) {
        MovieBooking movie = movieRepository.findById(theaterId)
                .orElseThrow(() -> new RuntimeException("Movie not found with Id: " + theaterId));
        return convertToDTO(movie);
    }

    // ---------- READ ALL (Classic Loop Option-1) ----------
    public List<MovieBookingDTO> getAllMovies() {
        List<MovieBooking> movies = movieRepository.findAll();
        List<MovieBookingDTO> dtoList = new ArrayList<>();

        for (MovieBooking movie : movies) {
            MovieBookingDTO dto = convertToDTO(movie);
            dtoList.add(dto);
        }

        return dtoList;
    }

    // ---------- UPDATE ----------
    public MovieBookingDTO updateMovie(Long theaterId, MovieBookingDTO dto) {
        MovieBooking movie = movieRepository.findById(theaterId)
                .orElseThrow(() -> new RuntimeException("Movie not found with Id: " + theaterId));

        movie.setMovienames(dto.getMovienames());
        movie.setMoviedate(dto.getMoviedate());
        movie.setLanguage(dto.getLanguage());
        movie.setMoviestarttime(dto.getMoviestarttime());
        movie.setPrice(dto.getPrice());

        MovieBooking updated = movieRepository.save(movie);
        return convertToDTO(updated);
    }

    // ---------- DELETE ----------
    public String deleteMovie(Long theaterId) {
        movieRepository.findById(theaterId)
                .orElseThrow(() -> new RuntimeException("Movie not found with Id: " + theaterId));
        movieRepository.deleteById(theaterId);
        return "Movie deleted successfully with ID: " + theaterId;
    }
}
