package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class ParkingBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingBookingSystemApplication.class, args);
	}

}
