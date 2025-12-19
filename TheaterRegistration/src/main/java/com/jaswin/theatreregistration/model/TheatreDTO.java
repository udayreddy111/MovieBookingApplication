package com.jaswin.theatreregistration.model;

public class TheatreDTO {

	    private Long id;
	    private String theatreName;
	    private String location;
	    private Integer seats;
	    
	    
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
	
	    


}
