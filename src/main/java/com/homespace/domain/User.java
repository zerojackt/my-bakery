package com.homespace.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, length = 20, unique = true)
	private Long id;
	
	private String username;
	private String passoword;
	
	@Builder
	public User(String username, String passoword) {
		super();
		this.username = username;
		this.passoword = passoword;
	}
	
	

}
