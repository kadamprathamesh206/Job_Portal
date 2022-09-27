package com.job_portal.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job_portal.main.model.JobSeeker;
import com.job_portal.main.model.StatusPostJob;

public interface JobSeekerRepositary extends JpaRepository<JobSeeker, Integer> {
	
	@Query("SELECT u FROM JobSeeker u WHERE u.email= ?1")
	JobSeeker findByEmail(String email);
	
	JobSeeker findByEmailAndPassword(String email,String password);
	
	@Query(value = "select a from StatusPostJob a where a.jobseeker.id= :n")
	List<StatusPostJob> getAllstatus(@Param("n") int id);
//	List<StatusPostJob> getAllstatus();

}
