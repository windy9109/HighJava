package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionAddTest
 */
@WebServlet("/sessionAddTest.do")
public class SessionAddTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * - Session정보 저장하기
		 * 1. Session객체를 생성하거나 현재 Session정보 가져오기
		 * 		형식) request객체.getSession(); 
		 * 			또는 request객체.getSession(true);
		 * 			==> 현재 세션이 존재하면 현재 세션을 반환하고, 세션이 존재하지 않으면 새로운 세션을 생성해서 반환한다.
		 * 		형식) request객체.getSession(false);
		 * 			==> 현재세션이 존재하면 세션을 반환하고, 세션이 존재하지 않으면 
		 * 				새로운 세션을 생성하지 않고 null을 반환한다.
		 * 		
		 * 
		 * 
		*/
		
		HttpSession session = request.getSession();
		
		/*
		 * 2. Session에 데이터 저장하기 ==> setAttribute()메서드 이용
		 * 	  형식) Session객체.setAttribute("key값",데이터값);
		 * 			==> 'key값'은 문자열, '데이터값'은 모든 데이터
		 * 
		*/
		
		session.setAttribute("testSession", "연습용 세션입니다");
		session.setAttribute("userName", "홍길동");
		session.setAttribute("age", 25);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>세션추가하기</title>");
		out.println("<body>");
		out.println("<h2>session데이터가 저장되었습니다.</h2>");
		out.println("<a href='"+request.getContextPath()+"/03/sessionJsp.jsp'>시작문서로 이동하기</a>");
		out.println("</body></html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
