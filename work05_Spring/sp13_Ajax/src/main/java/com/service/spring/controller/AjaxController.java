package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Person;

@Controller
public class AjaxController {
	
	//Autowired...Sercice...생략
	
	@RequestMapping("/") // http://127.0.0.1:8888/spring
	public String index() {
		System.out.println("context path request calling...");
		return "redirect:index.jsp";
	}
	
	@RequestMapping("synchro")
	public String synchro(Model model) {
		System.out.println("synchro request....");
		//ServletRequest에 바동 바인딩...forward방식으로 이동한다.
		model.addAttribute("info", "와~~~ 동기통신이다~~!!");
		return "synchro_result";
	}
	
	@RequestMapping("asynch")
	public String asynchro(Model model) {
		System.out.println("asynch request");
		// ServletRequest에 자동 바인딩 -> forward 방식으로 이동
		model.addAttribute("person", new Person("김국민", "역삼동"));
		return "JsonView"; // 여기선 InternalResourceViewResolver방식이 안통한다.
	}
}
