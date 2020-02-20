package com.homespace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homespace.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	

}
