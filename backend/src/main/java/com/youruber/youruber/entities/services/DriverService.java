package com.youruber.youruber.entities.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youruber.youruber.dto.DriverDTO;
import com.youruber.youruber.entities.Driver;
import com.youruber.youruber.entities.services.exceptions.EntityNotFoundException;
import com.youruber.youruber.respositories.DriverRepository;

@Service
public class DriverService {
	
   @Autowired	
 	private DriverRepository repository; 
   
   
   @Transactional(readOnly = true)
   
	public List<DriverDTO> FindAll(){
		List<Driver> list =  repository.findAll();
		
	return list.stream().map(x -> new DriverDTO(x)).collect(Collectors.toList());
				
		
	}

    @Transactional(readOnly = true)
    public DriverDTO findById(Integer id) {
	Optional<Driver> obj = repository.findById(id);
	Driver entity = obj.orElseThrow(() -> new EntityNotFoundException("Driver not found"));
	return new DriverDTO(entity); 
    }

}
