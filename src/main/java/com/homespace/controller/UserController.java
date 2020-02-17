package com.homespace.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.homespace.domain.User;
import com.homespace.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/signin")
	public String signin() {
		
		
		return "category/signin";
		
	}
	
	@RequestMapping("/signup")
	public String signup() {
		
		return "category/signup";
		
	}
	
	@RequestMapping("/save")
	public String save(String username,String passoword) {
		
		User user = new User(username,passoword);
		userRepository.save(user);
		
		return "redirect:/users/signin";
	}
	
	@RequestMapping("/check")
	public String signinCheck(String username,String password,HttpSession session) {
		
		User signinUser = userRepository.findByUsername(username);
		if(!username.equals(signinUser.getUsername())
		   && !password.equals(signinUser.getPassoword())) {
			
			return "redirect:/users/signin";
		}
		
		session.setAttribute("sessionUser", signinUser);
		
		
		
		
		return "redirect:/";
	}
	
	
	@RequestMapping("/signout")
	public String signout(HttpSession session) {
		
		session.removeAttribute("sessionUser");
		
		
		return "redirect:/";
	}

}
