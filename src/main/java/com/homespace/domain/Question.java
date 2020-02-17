package com.homespace.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Question {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User writer;
	
	@Lob
	private String contents;
	
	private int viewCount;
    
	
	
	
	public void increaseViewCount() {
		this.viewCount ++;
		
		
	}
	
	@Builder
	public Question(String title, User writer, String contents, int viewCount) {
		super();
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.viewCount = viewCount;
	}

	public void editied(String title, String contents) {
		// TODO Auto-generated method stub
		this.title = title;
		this.contents = contents;
	}
	
	
}
