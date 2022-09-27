package com.job_portal.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job_portal.main.model.Company;
import com.job_portal.main.repository.CompanyRepositary;

@Service
public class CompanyService {
    
	@Autowired
	CompanyRepositary companyRepositary;
	
	
	public Company newCompany(Company company) {
		Company saved_company= this.companyRepositary.save(company);
		return saved_company;

	}

	public List<Company> getCompany(){
		List<Company> companyList= this.companyRepositary.findAll();
		return companyList;
	}


	public Company signIn(String email,String password) {
		Company company=this.companyRepositary.findByEmailAndPassword(email, password);
		return company;


	}

	public Company updateComapny(Company company) throws Exception {
		Company db_company=  this.companyRepositary.findById(company.getId()).orElseThrow(()-> new Exception("company not found"));
		db_company.setComapny_name(company.getComapny_name());
		db_company.setEmail(company.getEmail());
		db_company.setLocation(company.getLocation());
		db_company.setNo(company.getNo());
		db_company.setPassword(company.getPassword());
		Company  updated_company=  this.companyRepositary.save(db_company);
		return updated_company;
	}

	public Company getACompany(int id) throws Exception{
		Company db_company=  this.companyRepositary.findById(id).orElseThrow(()-> new Exception("company not found"));
		return db_company;

	}

	public void deleteCompany(int id) throws Exception {
		Company db_company=  this.companyRepositary.findById(id).orElseThrow(()-> new Exception("company not found"));
		this.companyRepositary.delete(db_company);

	}


	public Company  findByCompanyByEmail(String email) {
		Company db_company=this.companyRepositary.findByEmail(email);

		return  db_company;
	}

	
	
}
