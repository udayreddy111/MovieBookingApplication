package com.jaswin.theatreregistration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaswin.theatreregistration.entity.Theatre;


@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long>{
	
	List<Theatre> findByLocation(String location);

	Optional<Theatre> findByTheatreName(String theatreName);

    void deleteByTheatreName(String theatreName);

}
