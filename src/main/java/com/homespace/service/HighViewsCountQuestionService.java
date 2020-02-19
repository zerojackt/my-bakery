package com.homespace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.homespace.domain.HighViewsQuestion;
import com.homespace.repository.HighViewsQuestionRepository;

@Service
public class HighViewsCountQuestionService {
	
	private HighViewsQuestionRepository highViewsQuestionRepository;

   
	
	public HighViewsCountQuestionService(HighViewsQuestionRepository highViewsQuestionRepository) {
		super();
		this.highViewsQuestionRepository = highViewsQuestionRepository;
	}



	public Page<HighViewsQuestion> getHighViewsCountQuestionList(Pageable pageable) {
		int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() -1);
		pageable = PageRequest.of(page, 10,Sort.by(Sort.Direction.DESC,"id"));
		
		return highViewsQuestionRepository.findAll(pageable);
	}

	

	public HighViewsQuestion findById(Long id) {
		// TODO Auto-generated method stub
		return highViewsQuestionRepository.findById(id).get();
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
		 highViewsQuestionRepository.deleteById(id);
		
	}

	public void save(HighViewsQuestion highViewsQuestion) {
		// TODO Auto-generated method stub
	  
		highViewsQuestionRepository.save(highViewsQuestion);
	
	}
	
	
	
	

}
