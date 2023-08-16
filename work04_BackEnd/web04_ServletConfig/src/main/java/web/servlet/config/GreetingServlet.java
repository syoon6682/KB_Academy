package web.servlet.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		description = "servletConfig를 이용한 servlet 객체 초기화", 
		urlPatterns = { "/GS" }, 
		initParams = { 
				@WebInitParam(name = "GREET", value = "Welcome to the JAMBERY")
		})
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 화면으로부터 못 받아오는 변수
	// -> 컨테이너 차원의 정보를 세팅!
	private String greet; 
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("");
		String greet = getInitParameter("GREET");
		System.out.println(greet);
	}
	
    public GreetingServlet() {
        System.out.println("1. GreetingServlet 디폴트로 생성");
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("2. GreetingServlet 필드 초기화");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("3. doProcess : client 요청시 동작함");
		
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		
		// ready on 상태에서 container에서 받아온 값
		out.println("<body><h3> " + name + ", " + greet +  "</h3></body>");
	}

}
