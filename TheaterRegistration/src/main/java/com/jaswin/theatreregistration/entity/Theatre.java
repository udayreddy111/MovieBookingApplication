package com.jaswin.theatreregistration.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "theatres")

public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "theatre_name", nullable = false)
    private String theatreName;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "seats", nullable = false)
    private Integer seats;
    
    public Theatre() {
    	
    }

	public Theatre(Long id, String theatreName, String location, Integer seats) {
		super();
		this.id = id;
		this.theatreName = theatreName;
		this.location = location;
		this.seats = seats;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Theatre [id=" + id + ", theatreName=" + theatreName + ", location=" + location + ", seats=" + seats
				+ "]";
	}
    
	
	
    
}