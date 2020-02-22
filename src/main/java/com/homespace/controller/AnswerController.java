package com.homespace.controller;

import javax.persistence.Lob;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.homespace.domain.Answer;
import com.homespace.domain.Question;
import com.homespace.domain.User;
import com.homespace.service.AnswerService;
import com.homespace.service.QuestionService;

@Controller
@RequestMapping("questions/{questionId}/answers")
public class AnswerController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	
	@RequestMapping("")
	public String create(@PathVariable Long questionId,String contents,HttpSession session,Model model) {
		
		
		Question question = questionService.findById(questionId);
		User writer = (User) session.getAttribute("sessionUser");
		
		if(writer== null) {
			
			return "redirect:/users/signin";
			
		}
		
		
//		Answer answer = new Answer(contents,writer,question);
		
		
		model.addAttribute("answer",answerService.createAnswer(new Answer(contents,writer,question)));
		
		
		
		
		
		return String.format("redirect:/questions/show/%d", questionId);
		
		
	}
	
	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable Long questionId,@PathVariable Long id) {
		Answer answer = answerService.findById(id);
		
		answerService.delete(answer);
		
		return String.format("redirect:/questions/show/%d", questionId);
		
	}
	
	@RequestMapping("/{id}/update")
	public String update(@PathVariable Long questionId,@PathVariable Long id,String contents) {
		
		Answer answer = answerService.findById(id);
		answer.update(contents);
		answerService.save(answer);
		
		return String.format("redirect:/questions/show/%d", questionId);
		
	}
	
	@RequestMapping("/update")
	public String updateForm(@PathVariable Long questionId) {
		
		
		
		return "category/qanda/answerUpdateForm";
	}
	
	
	

}
