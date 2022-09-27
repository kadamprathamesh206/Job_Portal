package com.job_portal.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job_portal.main.model.Company;
import com.job_portal.main.model.PostJob;
import com.job_portal.main.model.StatusPostJob;
import com.job_portal.main.repository.PostJobRepositary;

@Service
public class PostJobService {

	@Autowired
	PostJobRepositary postJobRepositary;



	public PostJob newPostJob(PostJob postJob) {
		PostJob saved_postJob= this.postJobRepositary.save(postJob);
		return saved_postJob;

	}

	public List<PostJob> getAllPostJob(){
		List<PostJob> postJobList= this.postJobRepositary.findAll();
		return postJobList;
	}


	//	public PostJob signIn(String email,String password) {
	//		PostJob postJob=this.postJobRepositary.findByEmailAndPassword(email, password);
	//		return postJob;
	//
	//
	//	}
	

	public PostJob updatePostJobforAppiled(PostJob postjob) throws Exception {
		PostJob postJob=  this.postJobRepositary.findById(postjob.getId()).orElseThrow(()-> new Exception("company not found"));
		postJob.setExperience(postjob.getExperience());
		postJob.setName(postjob.getName());
		postJob.setRequirements(postjob.getRequirements());
		PostJob  updated_postJob=  this.postJobRepositary.save(postjob);
		return updated_postJob;
	}

	public PostJob getPostJob(int id) throws Exception{
		PostJob db_poastJob=  this.postJobRepositary.findById(id).orElseThrow(()-> new Exception("company not found"));
		return db_poastJob;

	}

	public void deletepostJob(int id) throws Exception {
		PostJob  db_postJob=  this.postJobRepositary.findById(id).orElseThrow(()-> new Exception("company not found"));
		this.postJobRepositary.delete(db_postJob);

	}
	
	public List<PostJob> finadAllPostJobByCompany(String email){
		List<PostJob> findAllJobsComapny=this.postJobRepositary.findByEmail(email);
		return findAllJobsComapny;

	}

	

	//	public PostJob updatedStatus(String status,int id) {
	//		 PostJob updated_postJob=this.postJobRepositary.updatedJobStatus(status, id);
	//		 return updated_postJob;
	//	}


	//	public Company  findByCompanyByEmail(String email) {
	//		Company db_company=this.postJobRepositary.findByEmail(email);
	//
	//		return  db_company;
	//	}




}
