package com.devlaptop.controller;

import java.util.List;

import com.devlaptop.model.developer;
import com.devlaptop.service.developerService;


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

@RestController
public class developerController {
	
	//Injecting Service
	@Autowired
	private developerService service;
	
	//Adding Developers
	@PostMapping("/developer")
	public ResponseEntity<String> addDeveloper(@RequestBody developer d1){
		String status = service.addDevloper(d1);
		
		if(status!=null) {
			//Sending Response Entity
			return new ResponseEntity<>(status,HttpStatus.CREATED);
			
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	//Retrieving Developers
	@GetMapping("/developer")
	public ResponseEntity<List<developer>> getAllDevs(){
		
		return new ResponseEntity<>(service.getAllDevs(),HttpStatus.OK);
		
	}
	
	//To Update the Developer in DataBase
	@PutMapping("/developer")
	public ResponseEntity<String> updateDeveloper(@RequestBody developer d1){
		
		String status = service.updateDeveloper(d1);
		if(status!= null) 
			return new ResponseEntity<>(status,HttpStatus.OK);
		else
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//To delete the Developer in DataBase
	@DeleteMapping("/developer")
	public ResponseEntity<String> deleteDeveloper(@PathVariable int devid){
		
		String status = service.deleteDeveloper(devid);
		
		if(status!= null) 
			return new ResponseEntity<>(status,HttpStatus.OK);
		else
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		}
	
	}
