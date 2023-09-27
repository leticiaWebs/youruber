package com.youruber.youruber.entities.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youruber.youruber.dto.PassageiroDTO;
import com.youruber.youruber.entities.Passageiro;
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
	}

