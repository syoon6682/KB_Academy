package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.PhoneService;

@Controller
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@GetMapping("/") //http://127.0.0.1:9999/
	public String index() {
		return "redirect:index.jsp"; // redirect는 viewresolver를 거치지 않음 -> 확장자 꼭 붙이기!
	}
	
	@GetMapping("/regPhone.do")
	public String getRegPhone(Model model) {
		model.addAttribute("title", "핸드폰 관리 - 핸드폰 들록 폼");
		return "PhoneReg"; 
	}
	
	@PostMapping("/savePhone.do")
	public String doRegPhone(Phone phone, Model model) {
		
		try {
			// 성공 페이지 
			System.out.println(phone);
			System.out.println("phone service insert..");
			phoneService.insert(phone);
			model.addAttribute("title", "핸드폰  저장 성공");
			return "Result";
		} catch (Exception e) {
			// 에러 페이지
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 저장 에러");
			return "Error";
		}
		
	}
	
	@GetMapping("/searchPhone.do")
	public String doList(Model model) {
		
		try {
			List<Phone> phones = phoneService.select();
			model.addAttribute("phones", phones);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 목록 리스트");
			return "PhoneList";
		} catch (Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");	
			model.addAttribute("message", "문제 내용 - 핸드폰 목록 조회 중 에러 발생...");	
			
			return "Error";
		}	
	}
	
	@PostMapping("/deleteAjax.do")
	@ResponseBody
	public String doAjaxDelete(@RequestParam List<String> num, Model model) {
		List<String> temp = new ArrayList();
		
		try {
			for (String n : num) {
				temp.add(n);
			}
			phoneService.delete(temp);
			return "";
		} catch (Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "핸드폰  관리 중 에러");
			return "Error";
		}
		
	}
	
	@GetMapping("/detail.do")
	public String doDetail(Phone phone, Model model) {
		
		try {
			Phone selected = phoneService.select(phone);
			model.addAttribute("phone", selected);
			model.addAttribute("title", "상세 조회");
			return "";
		} catch (Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "폰  상세 조회 중 에러");
			return "Error";
		}
		
	}
	
	@GetMapping("/login.do")
	public String getLoginForm() {
		return "Login";
	}
	
	@PostMapping("/login.do")
	public String doLogin(Model model, UserInfo user, HttpSession session) {
		try {
			UserInfo selected = phoneService.select(user);
			if (selected != null) {
				session.setAttribute("loginUser", selected);
				return "redirect:search.do";
			} else {
				return "Login";
			}
			
		} catch (Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "문제 내용 - 로그인 중 에러 발생");	
			return "Error";
		}
		
		
	}
	
	@GetMapping("/rest.do")
	public String getRestClient() {
		
		return "rest";
	}
}
