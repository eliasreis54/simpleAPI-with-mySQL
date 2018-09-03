package com.pratice2.pratice.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratice2.pratice.DTO.EmployedDTO;
import com.pratice2.pratice.Models.Company;
import com.pratice2.pratice.Models.Employed;
import com.pratice2.pratice.response.Response;
import com.pratice2.pratice.service.EmployedService;

@RestController
@RequestMapping("employed")
public class EmployedController {

	@Autowired
	EmployedService service;
	
	@PostMapping
	public ResponseEntity<Response<Employed>> postEmployed(@Valid @RequestBody EmployedDTO employedDTO, BindingResult results) {
		Response<Employed> response = new Response<Employed>();
		
		if (results.hasErrors()) {
			System.out.println(results.getAllErrors());
			results.getAllErrors().forEach(erro -> response.getErrors().add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(this.service.saveEmployed(employedDTO));
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public List<Employed> getAll(){
		
		return this.service.getAll();
	}
}
