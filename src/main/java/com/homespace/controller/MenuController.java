package com.homespace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menus")
public class MenuController {
	
	@RequestMapping("")
	public String home() {
		
		return "category/menu";
	}
	
	@RequestMapping("/form")
	public String form() {
		
		return "category/menuForm";
		
	}

}
