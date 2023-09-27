package com.service.spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




public class Controller {
	
	@RequestMapping("/hello")
	public String doHello(Model model) {
		
		model.addAttribute("data", "Hello SpringBoot Start!!");
		return "result";
	}
	
}
