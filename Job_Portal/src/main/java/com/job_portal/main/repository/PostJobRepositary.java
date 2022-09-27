package com.job_portal.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job_portal.main.model.PostJob;

@Repository
@EnableJpaRepositories
public interface PostJobRepositary extends JpaRepository<PostJob, Integer> {

	
////	PostJob findByEmailAndPassword(String email,String password);
//	@Query("SELECT pg FROM Company bk join bk.postjob pg WHERE bk.companyId = :companyId")
//	List<PostJob> findByCompanyid(@Param("companyId") int companyId);
	
    List<PostJob> findByEmail(String email);
    
    List<PostJob> findByNameAndEmail(String name,String email);
}
