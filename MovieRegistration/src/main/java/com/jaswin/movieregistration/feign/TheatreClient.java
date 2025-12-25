package com.jaswin.movieregistration.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.jaswin.movieregistration.model.TheatreResponse;

@FeignClient(name = "theatre-service", url = "http://localhost:8081")
public interface TheatreClient {

    @GetMapping("/api/theatres/{id}")
    TheatreResponse getTheatreById(@PathVariable Long id);
}
