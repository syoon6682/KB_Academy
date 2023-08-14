package web.servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
MyGenericServlet 서블릿 클래스는 java 기반으로 만들어진 클래스
자바 클래스 -> JVM(Platform)
서블릿 클래스 -> Container(WAS, Engine)(servlet의 플랫폼!)

 SE level에서는 객체 생성의 주체가 개발자가 아님
 
*/

public class MyGenericServlet extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// 웹 브라우저로 응답을 하기 위한 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>");
		out.println("Hello Generic Servlet!");
		out.println("</h2></body></html>");
		
		// 닫혔다는 의미는 client 응답이 끝났다 == thread, requset, response 객체는 메모리에서 내려온다.
		out.close();
	}
}
