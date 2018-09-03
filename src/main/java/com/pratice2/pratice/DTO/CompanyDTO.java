package com.pratice2.pratice.DTO;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class CompanyDTO {

	private String name;
	private int cnpj;
	
	@NotEmpty(message = "Not be empty")
	@Length(max = 100, min = 5, message = "Invalid Length")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Max(30)
	public int getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
