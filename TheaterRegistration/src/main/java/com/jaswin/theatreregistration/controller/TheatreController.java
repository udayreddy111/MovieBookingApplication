package com.jaswin.theatreregistration.controller;

import java.util.List;

import com.jaswin.theatreregistration.model.TheatreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jaswin.theatreregistration.model.TheatreRequest;
import com.jaswin.theatreregistration.service.TheatreService;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    // POST - Create Theatre
    @PostMapping("/addTheatre")
    public TheatreResponse add(@RequestBody TheatreRequest dto) {
        return theatreService.addTheatre(dto);
    }

    // GET - Find by Location
    @GetMapping("/location/{location}")
    public List<TheatreResponse> getByLocation(@PathVariable String location) {
        return theatreService.getByLocation(location);
    }

    // DELETE - Delete by Theatre Name
    @DeleteMapping("/{theatreName}")
    public String deleteTheatre(@PathVariable String theatreName) {
        return theatreService.deleteByName(theatreName);
    }

    // PUT - Update Theatre (Pass oldName separately)
    @PutMapping
    public TheatreResponse updateTheatre(@RequestParam String oldName,
                                        @RequestBody TheatreRequest dto) {
        return theatreService.updateTheatre(oldName, dto);
    }
}
