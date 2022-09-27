package com.job_portal.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.job_portal.main.model.Company;



@Repository
public interface CompanyRepositary extends JpaRepository<Company, Integer> {

	
	Company findByEmail(String email);
	
	Company findByEmailAndPassword(String email,String password);
}
