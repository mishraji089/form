package com.example.demo.repository;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	// to search by email
	 Optional<User> findByEmail(String email);
	 boolean existsByEmail(String email);
	 List<User> findByState_StateCode(Integer stateCode);
	 
	 
	 

}