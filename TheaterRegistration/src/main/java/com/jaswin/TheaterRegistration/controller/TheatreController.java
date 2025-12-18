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
    
    // DELETE - Theatre by theatreName
    @DeleteMapping("/{theatreName}")
    public String deleteTheatre(@PathVariable String theatreName) {
        return theatreService.deleteByName(theatreName);
    }

    // PUT - Update theatre
    @PutMapping
    public Theatre updateTheatre(@RequestParam String oldName,
                                 @RequestParam String newName,
                                 @RequestParam Integer seats) {
    	
    	System.out.println("Updating theatre name");
        return theatreService.updateTheatre(oldName, newName, seats);
        
    }

}
