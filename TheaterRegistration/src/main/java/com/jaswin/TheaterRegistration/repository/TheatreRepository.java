package com.jaswin.TheaterRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaswin.TheaterRegistration.entity.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long>{
	
	List<Theatre> findByLocation(String location);

}
