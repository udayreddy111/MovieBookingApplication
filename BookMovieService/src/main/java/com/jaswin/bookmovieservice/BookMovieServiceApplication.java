package com.jaswin.bookmovieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookMovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMovieServiceApplication.class, args);
	}

}
