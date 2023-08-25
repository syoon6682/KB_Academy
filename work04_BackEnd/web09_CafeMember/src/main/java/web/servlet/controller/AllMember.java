package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


@WebServlet("/AllMember")
public class AllMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AllMember() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
  }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		/*
		 * 1. DAO 리턴 받고 비즈니스 로직 호출
		 * 2. 반환된 값 바인딩
		 * 3. 결과 페이지로 네비게이션
		 */
		String path = "allView.jsp";
		try {
	          ArrayList<MemberVO> list=MemberDAOImpl.getInstance().showAllMember();
	          request.setAttribute("list", list);
	          request.getRequestDispatcher("allView.jsp").forward(request, response);
	      }catch(Exception e) {

	      }
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
}
