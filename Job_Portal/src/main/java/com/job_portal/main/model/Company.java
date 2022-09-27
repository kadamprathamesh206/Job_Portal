package com.job_portal.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="company")
public class Company {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 60 )
	private String comapny_name;
	
	@Column(nullable = false, length = 120 )
	private String location;
	
	@Column(nullable = false, length = 20 )
	private String no;
	
	@Column(nullable = false, unique =true, length = 39 )
	@Email
	private String email;
	
	@Column(nullable = false, length = 60 )
	@Size(min = 2,max = 8 ,message = "password should be in between 2 to 8 char")
	private String password;
   
	@OneToMany(mappedBy = "company")
	private List<PostJob> postJob=new ArrayList<>();
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComapny_name() {
		return comapny_name;
	}

	public void setComapny_name(String comapny_name) {
		this.comapny_name = comapny_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(int id, String comapny_name, String location, String no, String email, String password) {
		super();
		this.id = id;
		this.comapny_name = comapny_name;
		this.location = location;
		this.no = no;
		this.email = email;
		this.password = password;
	}
	
	
}
