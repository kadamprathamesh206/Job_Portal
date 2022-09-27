package com.job_portal.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class JobSeeker {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 60 )
	private String name;
	
	@Column(nullable = false, length = 120 )
	private String address;
	
	@Column(nullable = false, length = 20 )
	private String no;
	
	@Column(nullable = false, unique =true, length = 39 )
	@Email
	private String email;
	
	@Column(nullable = false, length = 60 )
	@Size(min = 2,max = 8 ,message = "password should be in between 2 to 8 char")
	private String password;
	
	@Column(nullable = false, length = 120 )
	private String education;
	
	@OneToMany(mappedBy = "jobseeker",cascade = CascadeType.REMOVE)
	private List<StatusPostJob> ststusJobList=new ArrayList<>();
	
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public JobSeeker(int id, String name, String address, String no, String email, String password, String education) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.no = no;
		this.email = email;
		this.password = password;
		this.education = education;
	}
	public JobSeeker() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
