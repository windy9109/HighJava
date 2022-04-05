package kr.or.ddit.basic.reqNres;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseForwardTest01
 */
@WebServlet("/responseForwardTest.do")
public class ResponseForwardTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ResponseForwardTest() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Forward방식으로 이동한 페이지 처리하기
		request.setCharacterEncoding("utf-8");
		
		//파라미터 데이터 가져오기
		String userName = request.getParameter("userName");
		
		//setAttribute()메서드로 저장한 데이터 가져오기
		// 		==> getAttribute("키값", 넘겨줄데이터)
		String tel = (String)request.getAttribute("tel");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>Forward방식 연습</title>");
		out.println("<body>");
		out.println("<h2>Forward 결과</h2>");
		out.println("<table border = '1'>");
		out.println("<tr><td>이름</td><td>"+userName+"</td></tr>");
		out.println("<tr><td>전화</td><td>"+tel+"</td></tr>");
		out.println("</table>");
		out.println("</body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
