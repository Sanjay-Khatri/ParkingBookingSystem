package com.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.Locations;
import com.spring.entities.ParkingSpot;
import com.spring.entities.Users;
import com.spring.exception.LocationNotFoundException;
import com.spring.repositories.ParkingSpotRepositories;
import com.spring.repositories.UsersRepositories;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UsersRepositories usersRepositories;
	
	@Autowired
	ParkingSpotRepositories parkingSpotRepositories;

	@PostMapping("/user")
	public ResponseEntity<?> createUser(@RequestBody(required=true)Users user) {
		Users save = usersRepositories.save(user);
		return ResponseEntity.ok(save);
	}
	
	@PostMapping("/locations")
	public ResponseEntity<?> addLocations(@RequestBody(required=true)Locations locations){
		for (ParkingSpot location : locations.getLocations()) {
			parkingSpotRepositories.save(location);
		}
		return ResponseEntity.ok(locations);
	}
	
	@PostMapping("/location")
	public ResponseEntity<?> addLocation(@RequestBody(required=true)ParkingSpot location){
		ParkingSpot save = parkingSpotRepositories.save(location);
		return ResponseEntity.ok(save);
	}
	
	@DeleteMapping("/location")
	public ResponseEntity<?> deleteLocation(@RequestParam(required=true, name="locationId")int id) throws LocationNotFoundException{
		Optional<ParkingSpot> location = parkingSpotRepositories.findById(id);
		if(location.isPresent()) {
			parkingSpotRepositories.deleteById(id);
			return ResponseEntity.ok(location.get());
		}
		throw new LocationNotFoundException("Given location id not found.");
	}
	
}
