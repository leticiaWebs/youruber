package com.youruber.youruber.entities;

import java.io.Serializable;
import java.util.Objects;

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
@Table(name= "tb_driver")
public class Driver  implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private String cnh;
	private String name; 
	private String veiculo; 
	
	

	
	public Driver() {
		
	}

	public Driver(int id, String cnh, String name, String veiculo) {
		super();
		this.id = id;
		this.cnh = cnh;
		this.name = name;
		this.veiculo = veiculo;
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

	@Override
	public int hashCode() {
		return Objects.hash(cnh, id, name, veiculo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		return Objects.equals(cnh, other.cnh) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(veiculo, other.veiculo);
	}



	
	
	
}
