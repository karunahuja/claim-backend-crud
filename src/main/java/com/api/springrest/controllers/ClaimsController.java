package com.api.springrest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.springrest.entities.Claims;
import com.api.springrest.services.ClaimsService;



@RestController
public class ClaimsController {

	
	@Autowired
	private ClaimsService claimService;
	
	
	
	//Get all Claimss
	
	@GetMapping("/claims")
	public ResponseEntity<List<Claims>> getClaimss() {
		
		
		List<Claims> list= this.claimService.getAllClaimss();
		
		if(list.size()<=0) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
		
		
	
	}
	
	//Get single claim

	
	@GetMapping("/claims/{id}")
	public ResponseEntity<Claims> getClaims(@PathVariable("id") int id)
	{
		 
		Claims claim=claimService.getClaimsById(id);
		if(claim==null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
		return ResponseEntity.of(Optional.of(claim));
	}
	
	
	
	//add new claim
	
	@PostMapping("/claims")
	public ResponseEntity<Claims> addClaims(@RequestBody Claims claim) {
		Claims b=null;
		
		try {
			b=this.claimService.addClaims(claim);
			System.out.println(claim);
			return ResponseEntity.of(Optional.of(b));
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
			
		}
		
	
	}
	
	//delete Claims
	
	
	@DeleteMapping("/claims/{claimId}")
	public ResponseEntity<Void> deleteClaims(@PathVariable("claimId") int claimId) {
		
		try {
			
			this.claimService.deleteClaims(claimId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
		
		
		
	}
	
	//update
	
	@PutMapping("/claims/{claimId}")
	public ResponseEntity<Claims> updateClaims(@RequestBody Claims claim,@PathVariable("claimId") int claimId) {
	
		try {
			this.claimService.updateClaims(claim, claimId);
	return ResponseEntity.ok().body(claim);
			
		} catch (Exception e) {
			
			// TODO: handle exception
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	
	}
	
	
	
}

