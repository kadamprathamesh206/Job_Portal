package com.job_portal.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job_portal.main.model.InterviewInvetion;
import com.job_portal.main.service.InterviewInvetionsevice;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/interviewInvetionj")
public class InterviewInvetionController {

	@Autowired
	InterviewInvetionsevice interviewInvetionsevice;
	
	@ApiOperation("This api use for creating invetion")
	@PostMapping("/newInvetion")
	public ResponseEntity<?>  newInvetion(@RequestBody InterviewInvetion interviewInvetion){
		  return new ResponseEntity<>(this.interviewInvetionsevice.createInvetion(interviewInvetion),HttpStatus.CREATED);
	}
	
	
	@ApiOperation("This api use for get the invetion for signleuser")
	@GetMapping("/getnvetion/{email}")
	public ResponseEntity<?> getSingleInvetionOfJobSeeker(@PathVariable("email") String email){
		 return new ResponseEntity<>(this.interviewInvetionsevice.getAllInterviewByJobseeker(email),HttpStatus.OK);
	}
 }
