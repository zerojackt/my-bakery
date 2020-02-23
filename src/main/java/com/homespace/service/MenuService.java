package com.homespace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homespace.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
	
	

}
