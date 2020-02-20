package com.homespace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homespace.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

	Answer findByQuestion(Long id);

}
