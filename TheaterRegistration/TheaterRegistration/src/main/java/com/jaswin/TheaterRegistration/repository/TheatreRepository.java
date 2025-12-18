package com.jaswin.TheaterRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaswin.TheaterRegistration.entiry.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long>{

}
