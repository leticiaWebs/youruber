package com.youruber.youruber.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youruber.youruber.entities.Driver;  

@RestController
@RequestMapping(value = "/drivers")
public class DriverResource {
	
	@GetMapping
	public ResponseEntity<List<Driver>> findAll() {
		 List<Driver> list = new ArrayList<>();	
		 list.add(new Driver(12345, "Sasuke Uchiha", "Celta"));
		 list.add(new Driver(45678, "Sakura Haruno", "HB20"));
		 list.add(new Driver(91011, "Hinata Hyuga", "Cherry qq"));
		 return ResponseEntity.ok().body(list);
		 
	}
    
}
