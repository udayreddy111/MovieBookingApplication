package com.jaswin.theatreregistration.service;

import java.util.ArrayList;
import java.util.List;

import com.jaswin.theatreregistration.model.TheatreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaswin.theatreregistration.entity.Theatre;
import com.jaswin.theatreregistration.model.TheatreRequest;
import com.jaswin.theatreregistration.repository.TheatreRepository;


@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

//    // Convert Entity → DTO
//    private TheatreRequest convertToDTO(Theatre theatre) {
//        TheatreRequest dto = new TheatreRequest();
//        dto.setId(theatre.getId());
//        dto.setTheatreName(theatre.getTheatreName());
//        dto.setLocation(theatre.getLocation());
//        dto.setSeats(theatre.getSeats());
//        return dto;
//    }

    // Convert DTO → Entity
    private Theatre convertToEntity(TheatreRequest dto) {
        Theatre theatre = new Theatre();
        theatre.setTheatreName(dto.getTheatreName());
        theatre.setLocation(dto.getLocation());
        theatre.setSeats(dto.getSeats());
        return theatre;
    }

    private TheatreResponse convertToEntityToResponseType(Theatre entity) {
        TheatreResponse theatre = new TheatreResponse();
        theatre.setTheatreName(entity.getTheatreName());
        theatre.setLocation(entity.getLocation());
        theatre.setSeats(entity.getSeats());
        theatre.setId(entity.getId());
        return theatre;
    }

    // CREATE theatre
    public TheatreResponse addTheatre(TheatreRequest dto) {
        Theatre theatre = convertToEntity(dto);
        Theatre saved = theatreRepository.save(theatre);
        return convertToEntityToResponseType(saved);
    }

    // READ by location  (Option 1 — Classic loop conversion)
    public List<TheatreResponse> getByLocation(String location) {
        List<Theatre> theatreList = theatreRepository.findByLocation(location);
        List<TheatreResponse> dtoList = new ArrayList<>();

        for (Theatre theatre : theatreList) {
            TheatreResponse dto = convertToEntityToResponseType(theatre);
            dtoList.add(dto);
        }

        return dtoList;
    }

    // DELETE by name
    public String deleteByName(String theatreName) {
        theatreRepository.deleteByTheatreName(theatreName);
        return "Theatre deleted successfully";
    }

    // UPDATE theatre
    public TheatreResponse updateTheatre(String oldName, TheatreRequest dto) {
        Theatre theatre = theatreRepository.findByTheatreName(oldName)
                .orElseThrow(() -> new RuntimeException("Theatre not found"));

        theatre.setTheatreName(dto.getTheatreName());
        theatre.setLocation(dto.getLocation());
        theatre.setSeats(dto.getSeats());

        Theatre updated = theatreRepository.save(theatre);
        return convertToEntityToResponseType(updated);
    }
}
