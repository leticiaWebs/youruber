package com.youruber.youruber.entities.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youruber.youruber.entities.Driver;
import com.youruber.youruber.respositories.DriverRepository;

@Service
public class DriverService {
	
   @Autowired	
 	private DriverRepository repository; 
	public List<Driver> FindAll(){
		return repository.findAll();
	}

}
