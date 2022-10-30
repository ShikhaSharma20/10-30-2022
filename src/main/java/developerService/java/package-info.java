package com.devlaptop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.devlaptop.model.developer;
import com.devlaptop.repository.developerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class developerService {
	
	//Injecting to the Repository
	@Autowired
	private developerRepository repo;
	
	//Adding Developers to the DataBase
	public String addDevloper(developer d1) {
		developer _d2=repo.save(d1);
		
		if(_d2!=null) {
			return "developer added....@"+new Date();
		}
		else {
			return null;
		}
	
	
	}
	
	//Retrieving all Developers from the DataBase
	public List<developer> getAllDevs(){
		
		List<developer> devlist = new ArrayList<>();
		
		repo.findAll().forEach(devlist::add);
		return devlist;
		
	}
	
	//Updating the Developer if it is already existed
	public String updateDeveloper(developer d1) {
		
		developer _d2 = repo.save(d1);
		if(_d2!= null) {
			return "developer updated"+new Date();
		}
		else {
			return null;
		}
	}
	
	//Deleting the Developer based on devId of it is existed
	public String deleteDeveloper(int devid) {
		
		Optional<developer >_d1 = repo.findById(devid);
		
		if(_d1!= null) {
			repo.deleteById(devid);
			return "developer deleted";
		}
		else {
			return null;
		}
		
	}
	
}