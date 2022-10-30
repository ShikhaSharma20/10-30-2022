package com.devlaptop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class laptop {
	
	@Id
	private int laptopId;
	private String laptopName;
	private int laptopPrice;
	
	
	
	
	
	
	
	
	
	
	
	
	

}