package com.jaswin.bookmovieservice.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaswin.bookmovieservice.model.TheatreMovieResponse;
import com.jaswin.bookmovieservice.service.BookMovieService;

@RestController
@RequestMapping("/api/bookings")
public class BookMovieController {

    @Autowired
    private BookMovieService bookMovieService;

    /**
     * GET BOOKINGS BY LOCATION & DATE
     *
     * Example:
     * GET /api/bookings?location=Bangalore&date=2025-12-25
     */
    @GetMapping
    public List<TheatreMovieResponse> getBookings(
            @RequestParam("location") String location,
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date) {
        System.out.println("eneytered");
        return bookMovieService.getBookings(location, date);
    }
}
