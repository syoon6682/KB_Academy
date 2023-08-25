package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        /*
         * 1. form 값 받아서
         * 2. DAO 리턴 받고 비즈니스 로직 호출
         * 3. 반환값 바인딩
         * 4. 결과 페이지로 네비게이션
         */
        
        //세션은 클라이언트가 서버에 요청시에 서버에 만들어짐.
        //만들어진 세션을 받아서 사용한다.
        HttpSession session = request.getSession();
        
        
        System.out.println("JSESSIONID : " + session.getId());
        
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        
        MemberVO vo = new MemberVO(id, password, "김국민", "신사동");
        
        // 비즈니스 로직 호출, 결과값 반환 받았다!
        
        // 바인딩 - 짱짱 중요! 
        // 이때 attribute가 아닌 session에 바인딩 진행!
        // session에 정보를 받아줘야하는 경우는 로그인, 회원정보 수정 정도! 
        // 나머지는 forwarding!! 
        session.setAttribute("vo", vo);
        
        // 네비게이션
        response.sendRedirect("BuyServlet");
        
        
        
	}

}
