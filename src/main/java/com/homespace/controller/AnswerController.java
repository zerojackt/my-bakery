package com.homespace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/answers")
public class AnswerController {
	
	@RequestMapping("")
	public String home() {
		
		return "";
	}

}
