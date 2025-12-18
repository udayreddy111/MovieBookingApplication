package com.jaswin.TheaterRegistration.entiry;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "theatres")
@Data
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
}
