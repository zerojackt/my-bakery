package com.homespace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homespace.domain.Menu;
import com.homespace.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;

	public void save(Menu menu) {
		// TODO Auto-generated method stub
		menuRepository.save(menu);
	}

	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		return menuRepository.findAll();
	}
	
	

}
