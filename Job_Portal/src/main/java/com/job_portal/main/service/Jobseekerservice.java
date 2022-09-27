package com.job_portal.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job_portal.main.model.Company;
import com.job_portal.main.model.JobSeeker;
import com.job_portal.main.repository.JobSeekerRepositary;

@Service
public class Jobseekerservice {
	
	@Autowired
	JobSeekerRepositary jobSeekerRepositary;
	
	public JobSeeker newJobseeker(JobSeeker jobseeker) {
		JobSeeker saved_jobsseeker= this.jobSeekerRepositary.save(jobseeker);
		return saved_jobsseeker;

	}

	public List<JobSeeker> getJobSeekers(){
		List<JobSeeker> JobseekerList= this.jobSeekerRepositary.findAll();
		return JobseekerList;
	}


	public JobSeeker signIn(String email,String password) {
		JobSeeker jobseeker=this.jobSeekerRepositary.findByEmailAndPassword(email, password);
		return  jobseeker;


	}

	public JobSeeker updateJobseeker(JobSeeker jobSeeker) throws Exception {
		JobSeeker dbJobseeker=  this.jobSeekerRepositary.findById(jobSeeker.getId()).orElseThrow(()-> new Exception("jobseeker not found"));
	    dbJobseeker.setAddress(jobSeeker.getAddress());
	    dbJobseeker.setEducation(jobSeeker.getEducation());
	    dbJobseeker.setEmail(jobSeeker.getEmail());
	    dbJobseeker.setName(jobSeeker.getName());
	    dbJobseeker.setNo(jobSeeker.getNo());
	    dbJobseeker.setPassword(jobSeeker.getPassword());
		JobSeeker  updated_jobseeker=  this.jobSeekerRepositary.save(dbJobseeker);
		return updated_jobseeker;
	}

	public JobSeeker getJobSeeker(int id) throws Exception{
		JobSeeker db_jobSeeker=  this.jobSeekerRepositary.findById(id).orElseThrow(()-> new Exception("jobseeker not found"));
		return db_jobSeeker;

	}

	public void deleteJobseeker(int id) throws Exception {
	     JobSeeker jobseeker=  this.jobSeekerRepositary.findById(id).orElseThrow(()-> new Exception("jobseeker not found"));
		this.jobSeekerRepositary.delete(jobseeker);

	}
	
	


	public JobSeeker  findJobSeekerByEmail(String email) {
		JobSeeker db_jobseeker=this.jobSeekerRepositary.findByEmail(email);

		return  db_jobseeker;
	}

	

}
