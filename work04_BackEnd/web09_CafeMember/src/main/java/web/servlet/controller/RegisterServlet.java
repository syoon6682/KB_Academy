package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
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
      
      // 폼값 받아와서
      // dao 돌리고 
      // set attribute
      
      String id = request.getParameter("id");
      String password = request.getParameter("password");
      String name = request.getParameter("name");
      String address = request.getParameter("address");
      
      String path = "index.html";
      try {
    	MemberVO vo = new MemberVO(id, password, name, address);
		MemberDAOImpl.getInstance().registerMember(vo);
		// path = "register_result.jsp";
		path = "allMember";
      } catch (SQLException e) {
		e.printStackTrace();
      }
     
//      request.getRequestDispatcher(path).forward(request, response);
//      request.getRequestDispatcher(path).forward(request, response);
      response.sendRedirect(path);
      
  }
}