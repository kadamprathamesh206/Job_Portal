package com.job_portal.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job_portal.main.config.ApiResponse;
import com.job_portal.main.model.Admin;
import com.job_portal.main.service.AdminService;

import io.swagger.annotations.ApiOperation;

@RequestMapping
@RestController("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@ApiOperation("This api use for create new admin")
	@PostMapping("/register")
	public ResponseEntity<?> newAdmin(@RequestBody Admin admin){
		 Admin db_Admin=this.adminService.findByAdmin(admin.getEmail());
		 if(db_Admin!=null) {
			 return new ResponseEntity<>(new ApiResponse("Email id Alerady Exist"),HttpStatus.BAD_REQUEST);
		 }
		 return new ResponseEntity<>(this.adminService.createAdmin(admin),HttpStatus.CREATED);
		 
	}
	
	
	@ApiOperation("This api use for sign")
	@PostMapping("/signIn")
	public ResponseEntity<?> signIn(@RequestBody Admin admin){
	        Admin db_admin= this.adminService.signin(admin.getEmail(), admin.getPassword());
	        if(db_admin==null) {
	        	return new ResponseEntity<>(new ApiResponse("Admin not exist"),HttpStatus.BAD_REQUEST);
	        }
	        return new ResponseEntity<>(db_admin,HttpStatus.OK);
	}
	
	@ApiOperation("This api use for updateda admin")
	@PutMapping("/updatedAdmin")
	public ResponseEntity<?> updatedAdmin(@RequestBody Admin admin) throws Exception{
		 return new ResponseEntity<>(this.adminService.updatedAdmin(admin),HttpStatus.OK);
	}
	
	
	@ApiOperation("This api use for delete admin")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable("id") int id) throws Exception{
		 this.adminService.deletedAdmin(id);
		  return new ResponseEntity<>(new ApiResponse("Admin deleted successfully"),HttpStatus.OK);
	}
	
	
	@ApiOperation("This api use for fetching the all admin from datatbase")
	@GetMapping("/getAllAdmin")
	public ResponseEntity<?> getAllAdmin(){
		return new ResponseEntity<>(this.adminService.adminList(),HttpStatus.OK);
	}
	
	
	
	

}
