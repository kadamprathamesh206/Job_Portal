package com.job_portal.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job_portal.main.model.StatusPostJob;
import com.job_portal.main.repository.StatusJobRepository;
import com.job_portal.main.service.StatusJobService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/statusPostJob")
public class StatusPostJobcontroller {
	
	@Autowired
	StatusJobService statusJobservice;
	
	@Autowired
	StatusJobRepository statusJobRepository;
	
	@ApiOperation("This api use for updateJobStatusWhenApplied")
	@PostMapping("/appliedStatus")
	public ResponseEntity<?> updateJobstatusapplied(@RequestBody StatusPostJob  statusPostJob){
        return new ResponseEntity<>(  this.statusJobservice.appliedStatus(statusPostJob),HttpStatus.CREATED);
}
	  
	
	
	
	@ApiOperation("This api use for get the job for particular postion")
	@PostMapping("/getJobfrompostionAndEmail")
	public ResponseEntity<?> getJobfrompostionAndEmail(@RequestBody StatusPostJob statusPostJob){
	    return new ResponseEntity<>(this.statusJobservice.getJobAllOfParticularPostion(statusPostJob),HttpStatus.OK);
	}
	
	
	
	@ApiOperation("This api use for get the joblist from company")
	@GetMapping("/getJobforparticularcompany/{email}")
	public ResponseEntity<?> getJobForparticularcompany(@PathVariable("email") String email){
		return new ResponseEntity<>(this.statusJobservice.finadAllPostJobByCompany(email),HttpStatus.OK);
	}
	
	
	
	
	@ApiOperation("This api use for get all status of user from particular id")
    @GetMapping("/getAllStatusOfjob_seeker/{id}")
	public ResponseEntity<List<?>> getAllStatusOfjob(@PathVariable("id") int id){
		   return new ResponseEntity<>(this.statusJobservice.getAllStatusofJobseeker(id),HttpStatus.OK);
	}
	
	
	
	
	@ApiOperation("This api use for updated the status of job to select")
	@PutMapping("/updateJobStatusSelected")
	public ResponseEntity<?> updateStatusToSelected(@RequestBody StatusPostJob statuspostjob ) throws Exception{
		StatusPostJob statusPostJob = this.statusJobservice.findById(statuspostjob.getId());
		    String status="selected";
		   statusPostJob .setStatus(status);
		  return new ResponseEntity<> ( this.statusJobRepository.save(statusPostJob) ,HttpStatus.OK);
	}
	
	
	
	@ApiOperation("This api use for updated the status of job to select")
	@PutMapping("/updateJobStatusRejected")
	public ResponseEntity<?> updateStatusToRejected(@RequestBody StatusPostJob statuspostjob ) throws Exception{
		StatusPostJob statusPostJob = this.statusJobservice.findById(statuspostjob.getId());
		    String status="rejected";
		    statusPostJob .setStatus(status);
		  return new ResponseEntity<> ( this.statusJobRepository.save(statusPostJob),HttpStatus.OK);
	}
	
	

	
}
