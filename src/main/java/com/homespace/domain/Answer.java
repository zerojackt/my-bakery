package com.homespace.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
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
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
	private User writer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_question"))
	private Question question;
    
	
	public Answer(String contents, User writer, Question question) {
		super();
		this.contents = contents;
		this.writer = writer;
		this.question = question;
	}


	public void update(String contents) {
		// TODO Auto-generated method stub
		this.contents = contents;
	}
	
	
	
	
	

}
