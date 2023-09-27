package com.youruber.youruber.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.youruber.youruber.entities.Driver;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity

public class DriverDTO implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	private int id; 
	private String cnh;
	private String name; 
	private String veiculo; 
	
	public DriverDTO() {
		
	}

	public DriverDTO(int id, String cnh, String name, String veiculo) {
		super();
		this.id = id;
		this.cnh = cnh;
		this.name = name;
		this.veiculo = veiculo;
	}
	
	public DriverDTO(Driver entity) {
		this.id = entity.getId();
		this.cnh = entity.getCnh();
		this.name = entity.getName();
		this.veiculo = entity.getVeiculo();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	
	

}
