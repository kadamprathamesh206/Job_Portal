package com.job_portal.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.job_portal.main.model.Admin;

@Repository
public interface AdminRepositary extends JpaRepository<Admin, Integer> {

	
	Admin findByEmail(String email);
	
	Admin findByEmailAndPassword(String email,String password);
}
