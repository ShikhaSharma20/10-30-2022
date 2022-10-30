package com.devlaptop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.devlaptop.model.laptop;
import com.devlaptop.repository.laptopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class laptopService {
	
	//Dependency injection for Repository
	@Autowired
	private laptopRepository laprepo;
	
	//Adding laptop to DataBase
	public String addLaptop(laptop l1) {
		String msg = null;
		laptop _l2 = laprepo.save(l1);
		if(_l2!=null) {
			msg = "Laptop added successfully.....!@"+new Date();
		}
		else {
			msg = null;
		}
		return msg;
		
		
	}
	
	//Retrieving List of Laptops
	public List<laptop> getLaptop(){
		
		List<laptop> laptopList = new ArrayList<>();
		
		laprepo.findAll().forEach(laptopList::add);
		return laptopList;
		
	}
	
	//Updating the existing Laptop in Database
	public String updateLaptop(laptop l1) {
		
		laptop _l2 = laprepo.save(l1);
		if(_l2!=null) {
			return "laptop updated....!"+new Date();
		}
		else {
			return null;
		}
		
	}
	
	//Deleting Laptop based on lapId if it is already existed in DataBase
	public String deleteLaptop(int lapid) {
		
		Optional<laptop> _l1 = laprepo.findById(lapid);
		if(_l1!= null ) {
			laprepo.deleteById(lapid);
			return "laptop deleted....!";
		}
		else {
			return null;
		}
		
	}
	
	//Sorting the list of laptops based on a specific field of a table
	public List<laptop> getLaptops(String field){
		
		return laprepo.findAll(Sort.by(Direction.DESC,field));
		
		}
	}