package com.homespace.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.homespace.domain.HighViewsQuestion;
import com.homespace.domain.Question;
import com.homespace.domain.User;
import com.homespace.repository.HighViewsQuestionRepository;
import com.homespace.service.HighViewsCountQuestionService;
import com.homespace.service.QuestionService;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private HighViewsCountQuestionService highViewsCountQuestionService;
	
	
	@GetMapping("")
	public String home(@PageableDefault Pageable pageable,Model model) {
		
		Page<Question> questionList = questionService.getQuestionList(pageable);
		model.addAttribute("questionList",questionList);
		
		return "category/qanda/qna";
		
	}
	
	@RequestMapping("/form")
	public String form() {
		
		return "category/qanda/qnaform";
	}
	
	@RequestMapping("/save")
	public String save(String title,User writer,String contents,int viewCount,HttpSession session) {
		Question question = new Question(title,writer,contents,viewCount);
		questionService.save(question);
		
		
		if(!(session.getAttribute("sessionUser") ==null)) {
			return "redirect:/";
		}
		
		
		return "redirect:category/qanda/qna";
		
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable Long id,Model model) {

		model.addAttribute("question",questionService.findById(id));
		
		Question question = questionService.findById(id);
		question.increaseViewCount();
		questionService.save(question);
		
		if(question.getViewCount() > 10) {
			
			HighViewsQuestion highViewsQuestion = new HighViewsQuestion(question.getTitle(),question.getWriter(),question.getContents(),question.getViewCount());
			
			highViewsCountQuestionService.save(highViewsQuestion);
			
		}
		
		return "category/qanda/qnaShow";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		
		 questionService.deleteById(id);
		
		
		return "redirect:/questions";
		
	}
	
	@RequestMapping("/edtited/{id}/form")
	public String edtitedForm(@PathVariable Long id,Model model) {
		

		model.addAttribute("question",questionService.findById(id));
	   
		
		return "category/qanda/qnaUpdateForm";
	}
	
	@RequestMapping("/edtited/{id}")
	public String editied(@PathVariable Long id,String title,String contents) {
		
		Question question = questionService.findById(id);
		question.editied(title,contents);
		questionService.save(question);
		
		return String.format("redirect:/questions/show/%d", id);
	}
	
	@RequestMapping("/high")
	public String highviewcountQuestion(@PageableDefault Pageable pageable,Model model) {
		
		Page<HighViewsQuestion> highViewsCountQuestion =  highViewsCountQuestionService.getHighViewsCountQuestionList(pageable);
		model.addAttribute("questionList", highViewsCountQuestion);
		
		
		
		return "category/qanda/qnaHighViewCount";
	}
	
	
	

}
