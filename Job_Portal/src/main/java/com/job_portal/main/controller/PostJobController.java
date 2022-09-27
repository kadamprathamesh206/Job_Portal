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
import com.job_portal.main.model.PostJob;
import com.job_portal.main.service.PostJobService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/postJob")
public class PostJobController {
   
	@Autowired
	PostJobService postJobService;
	
	@ApiOperation("This api use for creating new Job")
	@PostMapping("/createjob")
	public ResponseEntity<?> newJob(@RequestBody PostJob postJob ){
		PostJob saved_postJob=   this.postJobService.newPostJob(postJob);
		return new ResponseEntity<>(saved_postJob, HttpStatus.OK);
	}
	
	
   @ApiOperation("This api use for getAlljob")
   @GetMapping("/getAllpostJob")
	public ResponseEntity<?> getAlljob(){
	   return new ResponseEntity<>(this.postJobService.getAllPostJob(),HttpStatus.OK);
   }
   
   @ApiOperation("This api use for get the joblist from company")
	@GetMapping("/getJobforparticularcompany/{email}")
	public ResponseEntity<?> getJobForparticularcompany(@PathVariable("email") String email){
		return new ResponseEntity<>(this.postJobService.finadAllPostJobByCompany(email),HttpStatus.OK);
	}
   
   @ApiOperation("This api use for delete job ")
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> deleteJob(@PathVariable("id") int id) throws Exception{
	      this.postJobService.deletepostJob(id);
	      return new ResponseEntity<>(new ApiResponse("job deleted successfully"),HttpStatus.OK);
   }
   
   @ApiOperation("This api use for update job")
   @PutMapping("/update")
   public ResponseEntity<?> updateJob(@RequestBody PostJob postJob) throws Exception{
	     return new ResponseEntity<> (this.postJobService.updatePostJobforAppiled(postJob),HttpStatus.OK);
   }
}
