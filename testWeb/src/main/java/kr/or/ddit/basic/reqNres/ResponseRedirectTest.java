package kr.or.ddit.basic.reqNres;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseForwardTest02
 */
@WebServlet("/responseRedirectTest.do")
public class ResponseRedirectTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ResponseRedirectTest() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// redirect방식으로 이동한 페이지 처리하기
		
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 데이터 가져오기
		String userName = request.getParameter("userName");
		String tel = request.getParameter("tel"); 
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Rediect방식 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>Rediect 결과</h3>");
		out.println("<table border='1'>");
		out.println("<tr><td>이 름</td><td>" + 
							userName + "</td></tr>");
		out.println("<tr><td>전 화</td><td>" + 
							tel + "</td></tr>");
		out.println("</table>");
		
		
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
