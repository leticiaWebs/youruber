package com.youruber.youruber.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youruber.youruber.entities.Driver;


@Repository
public interface  DriverRepository  extends JpaRepository<Driver, Integer> {
	
       
	
} 
