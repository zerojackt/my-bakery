package com.homespace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.homespace.domain.Menu;
import com.homespace.service.MenuService;

@Controller
@RequestMapping("/menus")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("")
	public String home(Model model) {
		model.addAttribute("menuList",menuService.findAll());
		
		return "category/menu";
	}
	
	@RequestMapping("/form")
	public String form() {
		
		return "category/menuForm";
		
	}
	
	@RequestMapping("/save")
	public String save(String title, String contents,String price) {
		
		Menu menu = new Menu(title,contents,price);
		menuService.save(menu);
		
		return "redirect:/menus";
	}

}
