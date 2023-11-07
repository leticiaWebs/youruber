package com.youruber.youruber.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    
    @PostMapping
    public ResponseEntity<PassageiroDTO> insert (@RequestBody PassageiroDTO dto){
    	dto = service.insert(dto);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
    			.buildAndExpand(dto.getId()).toUri();
    	return ResponseEntity.created(uri).body(dto);

    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<PassageiroDTO> update (@PathVariable Integer id, @RequestBody PassageiroDTO dto){
    	dto = service.update(id, dto);
    	return ResponseEntity.ok().body(dto);

    }
     
}
