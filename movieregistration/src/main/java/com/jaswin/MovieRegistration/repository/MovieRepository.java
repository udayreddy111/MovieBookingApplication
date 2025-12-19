package com.jaswin.movieregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaswin.movieregistration.entity.MovieBooking;

@Repository
public interface MovieRepository extends JpaRepository<MovieBooking, Long> {

}
