package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FrontController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 	폼 값 받아서
		 * 	VO 생성
		 * 	DAO 리턴 받고
		 *  비지니스 로직 호출
		 *  반환값 바인딩
		 *  네비게이션
		 *  
		 *  네비게이션만 하기
		 *  String ---> ModelAndView
		 *  
		 */
		
		// forwarding default값 
		// Request에 자동 바인딩 setAttribute
		// 결과페이지가 저장되는 물리적 위치를 알 수 없다
		// 확장자도 알 수 없다
		return new ModelAndView("result","message","Hello First Spring MVC Framework");
		
		
		
	}
	
}
