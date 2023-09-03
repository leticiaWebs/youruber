package com.youruber.youruber.entities;

import java.util.Objects;
import java.io.Serializable;

public class Driver  implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	
	private int cnh;
	private String name; 
	private String veiculo; 
	
	public Driver() {
		
	}

	public Driver(int cnh, String name, String veiculo) {
		super();
		this.cnh = cnh;
		this.name = name;
		this.veiculo = veiculo;
	}

	public int getCnh() {
		return cnh;
	}

	public void setCnh(int cnh) {
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
		return Objects.hash(cnh, name, veiculo);
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
		return Objects.equals(cnh, other.cnh) && Objects.equals(name, other.name)
				&& Objects.equals(veiculo, other.veiculo);
	}
   
	
	
}
