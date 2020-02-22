package com.homespace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homespace.domain.Answer;
import com.homespace.repository.AnswerRepository;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;

	public Answer createAnswer(Answer answer) {
		// TODO Auto-generated method stub
		return answerRepository.save(answer);
	}

	public void delete(Answer answer) {
		// TODO Auto-generated method stub
		
		answerRepository.delete(answer);
	}

	public void save(Answer answer) {
		// TODO Auto-generated method stub
		answerRepository.save(answer);
		
	}

	public Answer findById(Long id) {
		// TODO Auto-generated method stub
		return answerRepository.findById(id).get();
	}
	
	
	
	

}
