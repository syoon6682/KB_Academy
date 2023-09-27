package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/Find")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FindServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        // 로직은 여기서 작성
        
        // 1. 폼값 받아서
        // 2. DAO 리턴 받고 비즈니스 로직 호출
        // 3. 반환된 값을 바인딩
        // 4. 네비게이션 -> jsp 결과페이지로
        
        // request에 담겨온 걸 비즈니스 로직으로 처리한 후에 jsp에 전달
        String id = request.getParameter("id");
        String path = "find_fail.jsp"; // 못했을 때를 가정해서
      
        try {
			MemberVO rvo = MemberDAOImpl.getInstance().findByIdMember(id);
			if (rvo != null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}
			
		} catch (SQLException e) {
		}
        
        request.getRequestDispatcher(path).forward(request, response);
        
	}

}
