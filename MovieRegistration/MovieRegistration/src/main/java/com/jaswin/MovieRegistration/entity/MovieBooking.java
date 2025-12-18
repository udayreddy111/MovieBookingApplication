package com.jaswin.MovieRegistration.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	@NotBlank(message = "movie name must not be empty")
	
	private String movienames;
	
	private LocalDate moviedate;
	
	private String language;
	@NotNull(message ="moviestarttime must not be null")
	private LocalTime moviestarttime;
	
	private int price;

}
