package com.job_portal.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job_portal.main.config.ApiResponse;
import com.job_portal.main.model.JobSeeker;
import com.job_portal.main.service.Jobseekerservice;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/jobseeker")
public class JobseekerController {

	@Autowired 
	Jobseekerservice jobseekerService;


	@ApiOperation("This api use for create new job seeker")
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody JobSeeker jobseeker){
		JobSeeker db_jobSeeker= this.jobseekerService.findJobSeekerByEmail(jobseeker.getEmail());
		if(db_jobSeeker!=null) {
			return new ResponseEntity<>(new ApiResponse("Email Alerady exist"),HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(this.jobseekerService.newJobseeker(jobseeker),HttpStatus.OK);
	}
	
	
	

	@ApiOperation("This api use for sigin")
	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody JobSeeker jobseeker){
		JobSeeker db_jobseeker=  this.jobseekerService.signIn(jobseeker.getEmail(), jobseeker.getPassword());
		if(db_jobseeker==null) {
			return new ResponseEntity<>(new ApiResponse("Jobseeker not exist"),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(db_jobseeker,HttpStatus.OK);
	}
	
	
	
	@ApiOperation("This api operation is use for getAllJobseeker")
	@GetMapping("/getAllJobseeker")
	public ResponseEntity<?> getAllJobSeeker(){
		     return new ResponseEntity<>(this.jobseekerService.getJobSeekers(),HttpStatus.OK);
	}
	
	
	
	@ApiOperation("This api is use for delete jobseeker")
	@DeleteMapping("/deleteJobSeeker/{id}")
	public ResponseEntity<?> deleteJobSeeker(@PathVariable("id") int id) throws Exception{
		this.jobseekerService.deleteJobseeker(id);
		return new ResponseEntity<>(new ApiResponse("jobseeker deleted successfully"),HttpStatus.OK);
		
	}
	
//	@ApiOperation("This api use for get the status of jobseeker")
}
