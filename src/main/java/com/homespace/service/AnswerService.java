package com.homespace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homespace.domain.Answer;
import com.homespace.domain.Question;
import com.homespace.repository.AnswerRepository;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;

	public void save(Answer answer) {
		// TODO Auto-generated method stub
		answerRepository.save(answer);
		
	}

	public Answer findById(Long id) {
		// TODO Auto-generated method stub
		return answerRepository.findById(id).get();
	}

	public List<Answer> findAll() {
		// TODO Auto-generated method stub
		return answerRepository.findAll();
	}

	public Answer createAnswer(Answer answer) {
		// TODO Auto-generated method stub
		return answerRepository.save(answer);
	}

	

	

}
