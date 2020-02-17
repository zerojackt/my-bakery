package com.homespace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/elements")
public class ElementController {
	
	@RequestMapping("")
	public String home() {
		
		return "/category/elements";
	}

}
