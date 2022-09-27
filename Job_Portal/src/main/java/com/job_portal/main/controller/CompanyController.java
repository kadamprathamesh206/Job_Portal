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
import com.job_portal.main.model.Company;
import com.job_portal.main.service.CompanyService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
   @ApiOperation("This api use for register company")
   @PostMapping("/register")
   public ResponseEntity<?> register(@RequestBody Company company){
	    Company db_company=this.companyService.findByCompanyByEmail(company.getEmail());
	    if(db_company!=null) {
	    	 return new ResponseEntity<>(new ApiResponse("Email Alerady Exist"),HttpStatus.BAD_REQUEST);
	    }
	     return new ResponseEntity<>(this.companyService.newCompany(company),HttpStatus.OK);
   }
   
   
   @ApiOperation("This api use for signIn")
   @PostMapping("/signIn")
   public ResponseEntity<?> signIn(@RequestBody Company company){
	 Company db_company=  this.companyService.signIn(company.getEmail(), company.getPassword());
	 if(db_company==null) {
		 return new ResponseEntity<>(new ApiResponse("company not exist"),HttpStatus.BAD_REQUEST);
	 }
	 return new ResponseEntity<>(db_company,HttpStatus.OK);
   }
   
   @ApiOperation("This api use for getting all list of company")
   @GetMapping("/getAllCompanylist")
   public ResponseEntity<?> getAllCompany(){
	        return new ResponseEntity<> (this.companyService.getCompany(),HttpStatus.OK);
   }
   
   @ApiOperation("This api use for updating company")
   @PutMapping("/updateCompany")
   public ResponseEntity<?> updateCompany(@RequestBody Company company) throws Exception{
	    return new ResponseEntity<>(this.companyService.updateComapny(company),HttpStatus.OK);
   }
   
   @ApiOperation("This api use for delete company")
   @DeleteMapping("/deleteCompany/{id}")
   public ResponseEntity<?> deleteCompany(@PathVariable("id") int id) throws Exception{
	   this.companyService.deleteCompany(id);
        return new ResponseEntity<>(new ApiResponse("company deleted successfully"),HttpStatus.OK);
}
}
