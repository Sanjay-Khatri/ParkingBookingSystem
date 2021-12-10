package com.spring.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.spring.entities.ParkingSpot;
import com.spring.entities.Users;

public interface ParkingSpotRepositories extends CrudRepository<ParkingSpot, Integer> {
	
	Optional<ParkingSpot> findByArea(String area);
	
}
