package com.jaswin.movieregistration.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieBooking {

	
	private String movienames;
	
	private LocalDate moviedate;
	
	private String language;
	@NotNull(message ="moviestarttime must not be null")
	private LocalTime moviestarttime;
	
	private int price;

}
