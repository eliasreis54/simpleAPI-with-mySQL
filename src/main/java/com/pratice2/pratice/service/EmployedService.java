package com.pratice2.pratice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice2.pratice.DTO.EmployedDTO;
import com.pratice2.pratice.Models.Company;
import com.pratice2.pratice.Models.Employed;
import com.pratice2.pratice.repository.CompanyRepository;
import com.pratice2.pratice.repository.EmployedRepository;

@Service
public class EmployedService {

	@Autowired
	EmployedRepository repository;
	
	@Autowired
	CompanyRepository companyReposity;
	
	public Employed saveEmployed(EmployedDTO employedDTO) {
		Employed emp = new Employed();
		
		
		Company comp = this.companyReposity.findById(employedDTO.getCompany());
		
		System.out.println(comp.toString());
		
		emp.setCompany(comp);
		emp.setName(employedDTO.getName());
		emp.setCpf(employedDTO.getCpf());
		
		return this.repository.save(emp);
	}
	
	public List<Employed> getAll() {
		return this.repository.findAll();
	}
}
