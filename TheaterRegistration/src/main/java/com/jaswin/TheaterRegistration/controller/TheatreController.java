package com.jaswin.TheaterRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.jaswin.TheaterRegistration.entity.Theatre;
import com.jaswin.TheaterRegistration.service.TheatreService;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping
    public Theatre add(@RequestBody Theatre theatre) {
        return theatreService.addTheatre(theatre);
    }

    @GetMapping("/location/{location}")
    public List<Theatre> getByLocation(@PathVariable String location) {
        return theatreService.getByLocation(location);
    }

}
