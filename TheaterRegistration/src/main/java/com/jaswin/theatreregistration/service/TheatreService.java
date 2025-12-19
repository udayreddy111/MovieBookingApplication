package com.jaswin.theatreregistration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaswin.theatreregistration.entity.Theatre;
import com.jaswin.theatreregistration.model.TheatreDTO;
import com.jaswin.theatreregistration.repository.TheatreRepository;


@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    // Convert Entity → DTO
    private TheatreDTO convertToDTO(Theatre theatre) {
        TheatreDTO dto = new TheatreDTO();
        dto.setId(theatre.getId());
        dto.setTheatreName(theatre.getTheatreName());
        dto.setLocation(theatre.getLocation());
        dto.setSeats(theatre.getSeats());
        return dto;
    }

    // Convert DTO → Entity
    private Theatre convertToEntity(TheatreDTO dto) {
        Theatre theatre = new Theatre();
        theatre.setId(dto.getId());
        theatre.setTheatreName(dto.getTheatreName());
        theatre.setLocation(dto.getLocation());
        theatre.setSeats(dto.getSeats());
        return theatre;
    }

    // CREATE theatre
    public TheatreDTO addTheatre(TheatreDTO dto) {
        Theatre theatre = convertToEntity(dto);
        Theatre saved = theatreRepository.save(theatre);
        return convertToDTO(saved);
    }

    // READ by location  (Option 1 — Classic loop conversion)
    public List<TheatreDTO> getByLocation(String location) {
        List<Theatre> theatreList = theatreRepository.findByLocation(location);
        List<TheatreDTO> dtoList = new ArrayList<>();

        for (Theatre theatre : theatreList) {
            TheatreDTO dto = convertToDTO(theatre);
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
    public TheatreDTO updateTheatre(String oldName, TheatreDTO dto) {
        Theatre theatre = theatreRepository.findByTheatreName(oldName)
                .orElseThrow(() -> new RuntimeException("Theatre not found"));

        theatre.setTheatreName(dto.getTheatreName());
        theatre.setLocation(dto.getLocation());
        theatre.setSeats(dto.getSeats());

        Theatre updated = theatreRepository.save(theatre);
        return convertToDTO(updated);
    }
}
