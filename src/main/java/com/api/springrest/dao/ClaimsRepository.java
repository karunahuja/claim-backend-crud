package com.api.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.api.springrest.entities.Claims;



public interface ClaimsRepository  extends JpaRepository<Claims,Integer> {

	public Claims findById(int id);
	
	
}
