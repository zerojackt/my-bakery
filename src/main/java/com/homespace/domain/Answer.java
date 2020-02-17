package com.homespace.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Answer {
	
	@Id @GeneratedValue
	private Long id;
	
	@Lob
	private String contents;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User writer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QUESTION_ID")
	private Question questionId;
    
	
	public Answer(String contents, User writer, Question questionId) {
		super();
		this.contents = contents;
		this.writer = writer;
		this.questionId = questionId;
	}
	
	
	
	
	

}
