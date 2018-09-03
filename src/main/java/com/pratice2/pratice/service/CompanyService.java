package com.pratice2.pratice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice2.pratice.DTO.CompanyDTO;
import com.pratice2.pratice.Models.Company;
import com.pratice2.pratice.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository repository;
	
	public Company saveCompany(CompanyDTO company) {
		Company comp = new Company();
		comp.setCnpj(company.getCnpj());
		comp.setName(company.getName());
		
		return this.repository.save(comp);
	}
}
