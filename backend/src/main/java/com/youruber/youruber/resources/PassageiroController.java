package com.youruber.youruber.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youruber.youruber.dto.PassageiroDTO;
import com.youruber.youruber.entities.services.PassageiroService;

@RestController
@RequestMapping(value = "/passageiro")
public class PassageiroController {
	
   @Autowired
   private PassageiroService service; 

	@GetMapping
    public ResponseEntity <List<PassageiroDTO>> findAll() {
	  List<PassageiroDTO> list =  service.findAll(); 
	  return ResponseEntity.ok().body(list);
  }

    @GetMapping(value = "/{id}")
     public ResponseEntity<PassageiroDTO> findById(@PathVariable Integer id) {
     PassageiroDTO dto = service.findById(id);	 
	 return ResponseEntity.ok().body(dto);
   }
}
