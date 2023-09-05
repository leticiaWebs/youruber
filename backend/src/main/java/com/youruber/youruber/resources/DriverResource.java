package com.youruber.youruber.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youruber.youruber.dto.DriverDTO;
import com.youruber.youruber.entities.services.DriverService;  

@RestController
@RequestMapping(value = "/drivers")
public class DriverResource {
	
	@Autowired
	private DriverService service;
	
	
	@GetMapping
	public ResponseEntity<List<DriverDTO>> findAll() {
		 List<DriverDTO> list = service.FindAll();	 
		 return ResponseEntity.ok().body(list);
		 
	}
    
}
