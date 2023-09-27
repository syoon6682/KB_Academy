package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.MemberVO;
import com.service.spring.model.MemberDAO;
import com.service.spring.model.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private MemberService memberService;
	
	
	
	@RequestMapping("/find.do")
	public String find (Model model, String id) throws Exception {
		MemberVO rvo = memberService.getMember(id);
		String path = "find_fail";
		if(rvo != null) {
			model.addAttribute("vo", rvo);
			model.addAttribute("msg","회원 검색 성공~!");
			path = "find_ok";
		}else {
			model.addAttribute("msg","회원 검색 실패~!");
		}
		return path;
	}
	
	@RequestMapping("register.do")
    public String register(MemberVO pvo) throws Exception {
        memberDAO.registerMember(pvo);
        return "redirect:/showAll.do";
    }
	
	@RequestMapping("login.do")
    public String login(HttpServletRequest request,MemberVO pvo) throws Exception{

        MemberVO rvo=memberService.login(pvo);
        if(rvo!=null) {
            //login, update는 반드시  session에 값을 바인딩
            request.getSession().setAttribute("vo", rvo);
            return "login_result";
        }else {
            return "redirect:/index.jsp";
        }
    }
	
	@RequestMapping("logout.do")
    public String logout(HttpServletRequest request) throws Exception{
        HttpSession session=request.getSession();
        if(session.getAttribute("vo")!=null) { //로그인된 상태라면 로그아웃
            session.invalidate();//세션을 죽이고
            return "logout";
        }
        return null;
    }
	
	   @RequestMapping("showAll.do")
	    public String showAll(Model model )throws Exception {
	        List<MemberVO> list=memberService.showAllMember();
	        //HttpServletRequest에 데이타 바인딩 | 페이지 이동은 forward가 기본을 작동한다.
	        model.addAttribute("list", list);

	        return "allView";
	    }
	
	   @RequestMapping("update.do")
	    public String update(HttpSession session, MemberVO pvo) throws Exception{
	        memberDAO.updateMember(pvo);
	        //로그인된 상태에서만 수정 가능...

	        if(session.getAttribute("vo")!=null) {//로그인 상태라면
	          session.setAttribute("vo", pvo);
	          return "update_result";
	        }
	        return null;
	    }
	   
	   // 추가...비동기 요청
	   @RequestMapping("idExist.do")
	   public String idExist(String id, Model model) throws Exception {
		   boolean check = false;
		   String rid = memberDAO.idExist(id);
		   
		   if (rid != null) {// id가 있다는 의미
			   check = true;
		   }
		   
		   model.addAttribute("check", check);
		   
		   return "JsonView";
	   }
	
	
	
	
}
