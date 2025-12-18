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
    
}