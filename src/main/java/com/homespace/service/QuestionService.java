package com.homespace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.homespace.domain.Question;
import com.homespace.repository.QuestionRepository;

@Service
public class QuestionService {
	
	private QuestionRepository questionRepository;

	public QuestionService(QuestionRepository questionRepository) {
		super();
		this.questionRepository = questionRepository;
	}
	
	public Page<Question> getQuestionList(Pageable pageable) {
		int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() -1);
		pageable = PageRequest.of(page, 10,Sort.by(Sort.Direction.DESC,"id"));
		
		return questionRepository.findAll(pageable);
	}

	public void save(Question question) {
		questionRepository.save(question);
		
	}

	public Question findById(Long id) {
		// TODO Auto-generated method stub
		return questionRepository.findById(id).get();
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
		 questionRepository.deleteById(id);
		
	}
	
	
	
	

}
