package com.spring.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entities.ParkingSpot;
import com.spring.exception.LocationNotFoundException;
import com.spring.repositories.ParkingSpotRepositories;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	ParkingSpotRepositories parkingSpotRepositories;

	@GetMapping("/location")
	public ResponseEntity<?> getAllLocations(@RequestParam(required=false, name="locationName")Optional<String> locationName) throws LocationNotFoundException {
		if(locationName.isPresent()) {
			Optional<ParkingSpot> area = parkingSpotRepositories.findByArea(locationName.get());
			if(area.isPresent()) {
				return ResponseEntity.ok(area.get());
			}else {
				throw new LocationNotFoundException(locationName.get().toUpperCase()+" is not found.");
			}
		}
		
		Iterable<ParkingSpot> findAll = parkingSpotRepositories.findAll();
		Map<String, Iterable<ParkingSpot>> map = new HashMap<>();
		map.put("location", findAll);
		return ResponseEntity.ok(map);
	}
	
	
}
