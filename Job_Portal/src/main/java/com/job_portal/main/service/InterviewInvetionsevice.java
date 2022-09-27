package com.job_portal.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job_portal.main.model.InterviewInvetion;
import com.job_portal.main.repository.InterviewInvetionRepository;

@Service
public class InterviewInvetionsevice {

	@Autowired
	InterviewInvetionRepository interviewInvetionRepository;

	public InterviewInvetion createInvetion(InterviewInvetion interviewInvetion) {

		InterviewInvetion saved_interview=this.interviewInvetionRepository.save(interviewInvetion);

		return saved_interview;

	}


	public List<InterviewInvetion>  getAllInterview(){

		List<InterviewInvetion> interviewInvetionsList=	 this.interviewInvetionRepository.findAll();
		return interviewInvetionsList;
	}


	public List<InterviewInvetion>  getAllInterviewByJobseeker(String email){

		List<InterviewInvetion> interviewInvetionsList=	 this.interviewInvetionRepository.findByEmail(email);
		return interviewInvetionsList;
	}

}
