package web.servlet.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Redirect2")
public class Redirect2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		1. form값 받기 (하나의 값만 받기)
		2. 만약에 어느 값도 선택되지 않았다면 에러페이지로 연결
		하나의 값이 선택되었다면 redirect2.jsp로 바로 이동
		3. redirect2.jsp에서는 <% %> <%= %> 잘 사용해서 당신이 선택한 도시는 000입니다. 라고 출력
		*/
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		
		String city = request.getParameter("city");
		if (city != null) {
			request.getRequestDispatcher("redirect2.jsp").forward(request, response); 
		} else {
			response.sendRedirect("./error/error2.html");
		}
		
	}


}
