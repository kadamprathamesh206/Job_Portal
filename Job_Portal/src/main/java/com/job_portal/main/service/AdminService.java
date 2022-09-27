package com.job_portal.main.service;

import java.util.List;

import org.hibernate.annotations.SQLInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job_portal.main.model.Admin;
import com.job_portal.main.repository.AdminRepositary;

@Service
public class AdminService {

	@Autowired
	AdminRepositary adminRepositary;

	public List<Admin>  adminList(){
		List<Admin> adminList=   this.adminRepositary.findAll();
		return adminList;
	}
	public Admin findByAdmin(String email) {
		Admin admin=this.adminRepositary.findByEmail(email);
		return admin;
		}

	public Admin createAdmin(Admin admin) {
		Admin createdadmin = this.adminRepositary.save(admin);
		return createdadmin;
	}

	public Admin updatedAdmin(Admin admin) throws Exception {
		Admin db_Admin= this.adminRepositary.findById(admin.getId()).orElseThrow(()->new Exception("Admin not exist"));
		db_Admin.setEmail(admin.getEmail());
		db_Admin.setAddress(admin.getAddress());
		db_Admin.setName(admin.getName());
		db_Admin.setNo(admin.getNo());
		db_Admin.setPassword(admin.getPassword());
		Admin updated_Admin = this.adminRepositary.save(db_Admin);
		return updated_Admin;
	} 

	public void deletedAdmin(int id) throws Exception {
		Admin db_Admin= this.adminRepositary.findById(id).orElseThrow(()->new Exception("Admin not exist"));
		this.adminRepositary.delete(db_Admin);
	
	}
	
	public Admin signin(String email,String password) {
		    Admin admin= this.adminRepositary.findByEmailAndPassword(email, password);
		    return admin;
	}
	
	
}
