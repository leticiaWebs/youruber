package com.youruber.youruber.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@GetMapping(value = "/{id}")
	public ResponseEntity<DriverDTO> findById(@PathVariable Integer id) {
		 DriverDTO dto = service.findById(id);	 
		 return ResponseEntity.ok().body(dto);
		 
	}
	
	@PostMapping
	public ResponseEntity<DriverDTO> insert(@RequestBody DriverDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
		
		
	}
    
}
