package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.User;
import com.service.spring.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("memberLogin.do")
	public ModelAndView login(User user, HttpServletRequest request) throws Exception{
//		로그인 로직을 호출
//		1. userService의 login()
//		2. 반환된 값 있다면 ..세션에 바인딩
//		3. 네비게이션
		
		User rvo = userService.login(user);
		System.out.println(rvo);
		
		String path = "index.jsp";
		String msg = "아이디 혹은 패스워드가 틀렸습니다";
		
		if(rvo != null) {
			// 로그인 성공
			request.getSession().setAttribute("user", rvo);
			msg = "정상 로그인~!~!~";
		}
		request.getSession().setAttribute("msg", msg);
		return new ModelAndView("redirect:" + path);
	}
	
	@RequestMapping("/memberLogout.do")
	public ModelAndView logout(HttpSession session) throws Exception{
		
		// 로그아웃 로직 구현 후 네비게이션
		session.invalidate();
		
		return new ModelAndView("redirect:index.jsp");
	}
}
