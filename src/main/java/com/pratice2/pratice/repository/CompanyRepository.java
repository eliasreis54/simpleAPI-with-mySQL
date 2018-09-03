package com.pratice2.pratice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratice2.pratice.Models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

	Company findById(long i);

}
