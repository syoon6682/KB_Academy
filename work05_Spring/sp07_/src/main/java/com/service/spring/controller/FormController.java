package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController { //POJO
	
	@RequestMapping("/form.do")
	public ModelAndView form(String myName, String myAddr) {
		/*
		 * ���� �޾Ƽ�
		 * ����Ͻ� ���� ȣ��
		 * ��ȯ�� ���ε�
		 * �׺���̼�
		 * 
		 */
		
		
		return new ModelAndView("/WEB-INF/views/form_result.jsp", "info", myName+"���� ��� ���� "+ myAddr);
	}

}
