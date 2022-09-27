package com.job_portal.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="postjob")
public class PostJob {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 60 )
	private String name;
	
	@Column(nullable = false, length = 120 )
	private String requirements;
	
	@Column(nullable = false, length = 120 )
	private String experience;
	
	@Column(nullable = false, length = 120 )
	private String email;
	
	
	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

//	@OneToMany(mappedBy = "post_job")
//	private List<StatusPostJob> postJobList=new ArrayList<>();
	
	@ManyToOne
	private Company company;
	
	public Company getCompany() {
		return company;
	}



	public void setCompany(Company company) {
		this.company = company;
	}



//	public List<StatusPostJob> getPostJobList() {
//		return postJobList;
//	}
//
//
//
//	public void setPostJobList(List<StatusPostJob> postJobList) {
//		this.postJobList = postJobList;
//	}
//
//
//
//	public void setPostJobList(ArrayList<StatusPostJob> postJobList) {
//		this.postJobList = postJobList;
//	}
//	


	public PostJob(int id, String name, String requirements, String experience, ArrayList<StatusPostJob> postJobList) {
		super();
		this.id = id;
		this.name = name;
		this.requirements = requirements;
		this.experience = experience;
//		this.postJobList = postJobList;
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
