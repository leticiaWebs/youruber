package com.youruber.youruber.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.youruber.youruber.entities.Passageiro;

public class PassageiroDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private LocalDate dataNascimento; 
    private String CPF;

    public PassageiroDTO() {
    	
    }
    
    public PassageiroDTO(int id, String name, LocalDate dataNascimento, String CPF) {
    	
		this.id = id;
		this.name = name;
		this.dataNascimento = dataNascimento;
		this.CPF = CPF;
	}

     public PassageiroDTO(Passageiro entity) {
        this.id = entity.getId();
 		this.name = entity.getName();
 		this.dataNascimento = entity.getDataNascimento();
 		this.CPF = entity.getCPF();
     }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
    
}
