package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.user.model.service.UserService;
import com.kh.test.user.model.vo.User;


@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/search")
	public String search(String id, Model model) {
		System.out.println(id);
		User user = service.search(id);
		System.out.println(user);
		if (user==null) {
			return "/searchFail";
		}
		model.addAttribute("user", user);
		
		return "/searchSuccess";
	}
	
}