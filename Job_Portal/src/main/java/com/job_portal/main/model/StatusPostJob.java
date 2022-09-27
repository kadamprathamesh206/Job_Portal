package com.job_portal.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StatusPostJob {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 60 )
	private String name;
	
	@Column(nullable = false, length = 120 )
	private String requirements;
	
	@Column(nullable = false, length = 120 )
	private String experience;
	
	private String status;
	
	@Column(nullable = false, length = 120 )
	private String email;
    
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public PostJob getPost_job() {
//		return post_job;
//	}
//
//	public void setPost_job(PostJob post_job) {
//		this.post_job = post_job;
//	}

	public JobSeeker getJobseeker() {
		return jobseeker;
	}

	public void setJobseeker(JobSeeker jobseeker) {
		this.jobseeker = jobseeker;
	}

//	@ManyToOne
//	private PostJob  post_job;
//	
	@ManyToOne
	private JobSeeker jobseeker;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	
	
}
