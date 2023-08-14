package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JQueryAjax
 */
@WebServlet("/JQueryAjax")
public class JQueryAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JQueryAjax() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		// 이 값을 가지고 DB 다녀왔다고 치고, 로직이 돌아갔다고 치고
		
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			
		}
		
		PrintWriter out = response.getWriter();
		out.print(id);
		
		
	}

}
