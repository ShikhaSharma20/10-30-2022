package com.devlaptop.repository;

import com.devlaptop.model.developer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface developerRepository extends JpaRepository<developer,Integer>{


}