package com.pratice2.pratice.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratice2.pratice.DTO.CompanyDTO;
import com.pratice2.pratice.Models.Company;
import com.pratice2.pratice.response.Response;
import com.pratice2.pratice.service.CompanyService;

@RestController
@RequestMapping("/controller")
public class Controller1 {
	@Autowired
	CompanyService service;
	
	@PostMapping
	public ResponseEntity<Response<Company>> postCompany(@Valid @RequestBody CompanyDTO companyDTO, BindingResult results) {
		Response<Company> response = new Response<Company>();
		
		if (results.hasErrors()) {
			System.out.println(results.getAllErrors());
			results.getAllErrors().forEach(erro -> response.getErrors().add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(this.service.saveCompany(companyDTO));
		return ResponseEntity.ok(response);
	}
}
