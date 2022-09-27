package com.job_portal.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InterviewInvetion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String  employper_name;
	private String interview_date;
	private String interview_time;
	private String email;
	private String job_role;
	public String getJobseeker_email() {
		return email;
	}
	public InterviewInvetion(int id, String employper_name, String interview_date, String interview_time, String email,
			String job_role) {
		super();
		this.id = id;
		this.employper_name = employper_name;
		this.interview_date = interview_date;
		this.interview_time = interview_time;
		this.email = email;
		this.job_role = job_role;
	}
	public void setJobseeker_email(String jobseeker_email) {
		this.email = jobseeker_email;
	}
	public InterviewInvetion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJob_role() {
		return job_role;
	}
	public void setJob_role(String job_role) {
		this.job_role = job_role;
	}
	public InterviewInvetion(int id, String employper_name, String interview_date, String interview_time) {
		super();
		this.id = id;
		this.employper_name = employper_name;
		this.interview_date = interview_date;
		this.interview_time = interview_time;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployper_name() {
		return employper_name;
	}
	public void setEmployper_name(String employper_name) {
		this.employper_name = employper_name;
	}
	public String getInterview_date() {
		return interview_date;
	}
	public void setInterview_date(String interview_date) {
		this.interview_date = interview_date;
	}
	public String getInterview_time() {
		return interview_time;
	}
	public void setInterview_time(String interview_time) {
		this.interview_time = interview_time;
	}

}
