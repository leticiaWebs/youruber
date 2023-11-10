package com.youruber.youruber.entities.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youruber.youruber.dto.PassageiroDTO;
import com.youruber.youruber.entities.Passageiro;
import com.youruber.youruber.entities.services.exceptions.ResourceNotFoundException;
import com.youruber.youruber.resources.exceptions.DataBaseException;
import com.youruber.youruber.resources.exceptions.UnprocessableEntityException;
import com.youruber.youruber.respositories.PassageiroRepository;

@Service
public class PassageiroService {
	
	@Autowired
	private PassageiroRepository repository;

	@Transactional(readOnly = true)
	public List<PassageiroDTO> findAll() {
		 List<Passageiro> list = repository.findAll();
		 return  list.stream().map(x -> new PassageiroDTO(x)).collect(Collectors.toList());
		 
		}

    @Transactional(readOnly = true)
    public PassageiroDTO findById(Integer id) {
	Optional<Passageiro> obj = repository.findById(id);
	Passageiro entity = obj.orElseThrow(() -> new ResourceNotFoundException("Passageiro não foi encontrado"));
	return new PassageiroDTO(entity); 
	}
    
    @Transactional
	public PassageiroDTO insert(PassageiroDTO dto) {
		try {
    	Passageiro entity = new Passageiro();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new PassageiroDTO(entity);
		
	} catch (UnprocessableEntityException e) {
		throw new UnprocessableEntityException("CPF já existente no sistema");
	}
      }
    
   @Transactional
	public PassageiroDTO update(Integer id, PassageiroDTO dto) {
		try {
		Passageiro entity = repository.getReferenceById(id);
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new PassageiroDTO(entity);
		
	}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
	}
     catch (UnprocessableEntityException e) {
		throw new UnprocessableEntityException("CPF já existente no sistema");
	}
 }

    public void delete(Integer id) {
     try {
    	 repository.deleteById(id);
     }
     catch(EmptyResultDataAccessException e) {
    	 throw new ResourceNotFoundException("Id not found" + id);
     }
     catch (DataIntegrityViolationException e) {
    	 throw new DataBaseException("Integrity violation");
     }
	// TODO Auto-generated method stub
	
}
}
	
	
	

