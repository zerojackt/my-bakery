package com.homespace.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

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
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
	private User writer;
	
	@Lob
	private String contents;
	
	private Integer viewCount;
	
	@OneToMany(mappedBy = "question",fetch = FetchType.LAZY)
	private List<Answer> answers;
	

    
	
	
	
	public void increaseViewCount() {
		this.viewCount = viewCount +1 ;
		
		
	}
	
	@Builder
	public Question(String title, User writer, String contents, Integer viewCount) {
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
