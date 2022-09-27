package com.job_portal.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job_portal.main.model.PostJob;
import com.job_portal.main.model.StatusPostJob;

@Repository
public interface StatusJobRepository extends JpaRepository<StatusPostJob, Integer> {
	@Query("update StatusPostJob  u set u.status= :n where u.id= :i")
	StatusPostJob updatedJobStatus(@Param("n") String status,@Param("i") int id);
	List<StatusPostJob> findByNameAndEmail(String name,String email);
	 List<StatusPostJob> findByEmail(String email);
	 
	 
	 
}
