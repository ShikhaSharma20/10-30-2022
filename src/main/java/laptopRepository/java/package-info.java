package laptopRepository.java;package com.devlaptop.repository;

import com.devlaptop.model.laptop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface laptopRepository extends JpaRepository<laptop,Integer> {

}