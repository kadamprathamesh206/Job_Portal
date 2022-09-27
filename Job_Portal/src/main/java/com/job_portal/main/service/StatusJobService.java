package com.job_portal.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.job_portal.main.model.PostJob;
import com.job_portal.main.model.StatusPostJob;
import com.job_portal.main.repository.JobSeekerRepositary;
import com.job_portal.main.repository.StatusJobRepository;

@Service
public class StatusJobService {

	@Autowired
	StatusJobRepository statusjobRepo;

	@Autowired
	JobSeekerRepositary jobseekerRepo;


	public StatusPostJob updatedStatus(String status,int id) {
		StatusPostJob updated_postJob=this.statusjobRepo.updatedJobStatus(status,id);
		return updated_postJob;
	}

	public StatusPostJob appliedStatus( StatusPostJob statusPostJob) {
		statusPostJob.setStatus("Applied");
		StatusPostJob saved_StatusPostJob=	this.statusjobRepo.save(statusPostJob);
		return saved_StatusPostJob;
	}

	public List<StatusPostJob>getAllStatusofJobseeker(int id){

		List<StatusPostJob>  statuslist= this.jobseekerRepo.getAllstatus(id);
//		List<StatusPostJob>  statuslist= this.jobseekerRepo.getAllstatus();
		return statuslist;
	}

	public StatusPostJob findById(int id) throws Exception {
		StatusPostJob  db_statusjob=  this.statusjobRepo.findById(id).orElseThrow(()-> new Exception("statusPostJob not exist"));
		return db_statusjob;
	}

	public List<StatusPostJob>  getJobAllOfParticularPostion(StatusPostJob statusPostJob){
		List<StatusPostJob> db_postJob=this.statusjobRepo.findByNameAndEmail(statusPostJob.getName(), statusPostJob.getEmail());
		return db_postJob;
	}

	public List<StatusPostJob> finadAllPostJobByCompany(String email){
		List<StatusPostJob> findAllJobsComapny=this.statusjobRepo.findByEmail(email);
		return findAllJobsComapny;

	}
	
	
}
