package com.spring.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.spring.entities.Users;

public interface UsersRepositories extends CrudRepository<Users, Integer>{

	Optional<Users> findByUsername(String username);
		
}
