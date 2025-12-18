package com.jaswin.MovieRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaswin.MovieRegistration.entity.MovieBooking;
@Repository
public interface MovieRepository extends JpaRepository<MovieBooking, Long> {

}
