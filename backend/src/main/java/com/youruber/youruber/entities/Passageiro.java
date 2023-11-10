package com.youruber.youruber.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "tb_passageiros")
public class Passageiro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private LocalDate dataNascimento; 
	@Column(unique=true)
    private String CPF;

    
	public Passageiro() {
		
	}

	public Passageiro(int id, String name,  LocalDate dataNascimento, String CPF) {
		super();
		this.id = id;
		this.name = name;
		this.dataNascimento = dataNascimento;
		this.CPF = CPF;
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

	@Override
	public int hashCode() {
		return Objects.hash(CPF, dataNascimento, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passageiro other = (Passageiro) obj;
		return Objects.equals(CPF, other.CPF) && Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	
	
    
}
	
