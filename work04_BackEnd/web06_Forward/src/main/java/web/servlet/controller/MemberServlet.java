package web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.dto.Member;


@WebServlet("/find")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberServlet() {
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
        
        // 1. 폼값 받아서    
        // 2. DAO리턴 받고 비즈니스 로직 호출
        // 3. DB 값 반환
        // 4. value binding at attribute
        // 5. 페이지 이동 (navigation)
        
        String address = request.getParameter("address");
        
        //ArrayList<Member> members = MemberDAO.getInstance().findMemberByAddress(address);
        
        Member mem1 = new Member("아이유", 33, "여의도");
        Member mem2 = new Member("박재범", 42, "여의도");
        
        ArrayList<Member> members = new ArrayList<>();
        
        members.add(mem1);
        members.add(mem2);
        
        request.setAttribute("mem1", mem1); // binding 하는 객체와 이름이 동일해야함, convention
        
        // 현재 모든 권한을 가지고 이동한다.
        request.getRequestDispatcher("result.jsp").forward(request, response); 
        
        /*
        PrintWriter out = response.getWriter();
        out.println("<h3>Result Page</h3>");
        out.println("<h4><a href=result.jsp>여기를 클릭하면 JSP 연결됩니다..</a></h4>");
        */
	}
}
