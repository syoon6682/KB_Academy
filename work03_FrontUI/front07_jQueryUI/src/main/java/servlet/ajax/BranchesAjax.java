package servlet.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BranchesAjax")
public class BranchesAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BranchesAjax() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB 갔다왔다 치고 반환된 데이트를  result
		System.out.println("doGet 2 진입");
		
		String result = "<ul><li> 국민은행 서초 지점 </li></ul>"
				 + "<ul><li> 국민은행 강남 지점 </li></ul>"
				 + "<ul><li> 국민은행 선릉 지점 </li></ul>"
				 + "<ul><li> 국민은행 역삼 지점 </li></ul>"
				 + "<ul><li> 국민은행 강북 지점 </li></ul>"
				 + "<ul><li> 국민은행 가산 디지털단지 지점 </li></ul>"
				 + "<ul><li> 국민은행 용산 지점 </li></ul>";
	    request.setAttribute("result", result); //데이타 바인딩

	    request.getRequestDispatcher("Result.jsp").forward(request, response);
	}

}
