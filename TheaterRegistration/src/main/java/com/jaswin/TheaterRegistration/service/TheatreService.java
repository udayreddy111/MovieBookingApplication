package com.jaswin.TheaterRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaswin.TheaterRegistration.entity.Theatre;
import com.jaswin.TheaterRegistration.repository.TheatreRepository;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    // Create Theatre
    public Theatre addTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }
    
    // Get theatres by location
    public List<Theatre> getByLocation(String location) {
        return theatreRepository.findByLocation(location);
    }
    
    // DELETE - Theatre by name
    public String deleteByName(String theatreName) {
    	 theatreRepository.deleteByTheatreName(theatreName);
        return "Theatre deleted successfully";
    }

    // UPDATE - Theatre name & seats
    public Theatre updateTheatre(String oldName, String newName, Integer seats) {

        Theatre theatre =  theatreRepository.findByTheatreName(oldName)
                .orElseThrow(() -> new RuntimeException("Theatre not found"));

        theatre.setTheatreName(newName);
        theatre.setSeats(seats);

        return  theatreRepository.save(theatre);
    }
    
}