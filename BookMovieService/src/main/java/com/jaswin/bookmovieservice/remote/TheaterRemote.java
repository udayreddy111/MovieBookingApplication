package com.jaswin.bookmovieservice.remote;

import com.jaswin.bookmovieservice.feign.TheatreClient;
import com.jaswin.bookmovieservice.model.TheatreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TheaterRemote {

    @Autowired
    TheatreClient theatreClient;

    public List<TheatreResponse> getTheatersList(String location) {


        List<TheatreResponse> theatres =
                theatreClient.getTheatresByLocation(location);
        return theatres;
    }
}
