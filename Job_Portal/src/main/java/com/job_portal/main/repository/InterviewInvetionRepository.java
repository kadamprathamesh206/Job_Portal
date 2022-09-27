package com.job_portal.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job_portal.main.model.InterviewInvetion;

@Repository
public interface InterviewInvetionRepository extends JpaRepository<InterviewInvetion, Integer> {
	public List<InterviewInvetion> findByEmail(String email);

}
