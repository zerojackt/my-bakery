package com.homespace.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Menu {
	
	@Id @GeneratedValue
	private Long id;
	
	private String title;
	
	@Lob
	private String contents;
	
	private String price;

	public Menu(String title, String contents, String price) {
		super();
		this.title = title;
		this.contents = contents;
		this.price = price;
	}
	
	
	
	

}
