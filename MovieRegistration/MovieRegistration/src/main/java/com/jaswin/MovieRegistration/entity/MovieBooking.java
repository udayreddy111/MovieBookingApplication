package com.jaswin.MovieRegistration.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="moviebooking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long theaterid;
	
	private String movienames;
	
	private LocalDate moviedate;
	
	private String language;
	
	private LocalTime moviestarttime;
	
	private int price;

}
