package com.youruber.youruber.resources;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youruber.youruber.entities.Passageiro;

@RestController
@RequestMapping(value = "/passageiros")
public class PassageiroController {
	
	

	@GetMapping
    public ResponseEntity <List<Passageiro>> findAll() {
	  List<Passageiro> list = new ArrayList<>();
	   list.add(new Passageiro(1L, "Monkey D. Luffy", LocalDate.of(1997, 5, 5), "111.111.111-11"));
	   list.add(new Passageiro(2L, "Roronoa Zoro", LocalDate.of(1996, 11, 11), "222.222.222-22"));
	   list.add(new Passageiro(3L, "Nami", LocalDate.of(1998, 7, 3), "333.333.333-33"));
	   list.add(new Passageiro(4L, "Usopp", LocalDate.of(1997, 4, 1), "444.444.444-44"));
	   list.add(new Passageiro(5L, "Sanji", LocalDate.of(1995, 3, 2), "555.555.555-55"));
	   list.add(new Passageiro(6L, "Tony Tony Chopper", LocalDate.of(1999, 12, 24), "666.666.666-66"));
	   list.add(new Passageiro(7L, "Nico Robin", LocalDate.of(1996, 2, 6), "777.777.777-77"));
	   list.add(new Passageiro(8L, "Franky", LocalDate.of(1994, 8, 30), "888.888.888-88"));
       list.add(new Passageiro(9L, "Brook", LocalDate.of(1990, 4, 3), "999.999.999-99"));
       list.add(new Passageiro(10L, "Jinbei", LocalDate.of(1993, 9, 30), "000.000.000-00"));
	  return ResponseEntity.ok().body(list);
  }
	
}
