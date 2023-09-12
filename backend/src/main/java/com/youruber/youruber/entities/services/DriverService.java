package com.youruber.youruber.entities.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youruber.youruber.dto.DriverDTO;
import com.youruber.youruber.entities.Driver;
import com.youruber.youruber.entities.services.exceptions.ResourceNotFoundException;
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
	Driver entity = obj.orElseThrow(() -> new ResourceNotFoundException("Driver not found"));
	return new DriverDTO(entity); 
    }
    
    @Transactional
	public DriverDTO insert(DriverDTO dto) {
		Driver entity = new Driver();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new DriverDTO(entity);
	}
    @Transactional
	public DriverDTO update(Integer id, DriverDTO dto) {
     try {
		@SuppressWarnings("deprecation")
		Driver entity = repository.getById(id);
		entity.setCnh(dto.getCnh());
		entity.setName(dto.getName());
		entity.setVeiculo(dto.getVeiculo());
		entity = repository.save(entity);
		return new DriverDTO(entity);
     }
     
     catch (EntityNotFoundException e) {
    	 throw new ResourceNotFoundException("Id not found" + id);
    	 
     }
     
	}
  

}
