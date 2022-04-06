package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionDeleteTest.do")
public class SessionDeleteTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * - Session 삭제하기
		 * 1. Session객체 생성 및 현재 세션구하기 
		 * 
		*/
		
		HttpSession session = request.getSession();
		
		/*
		 * 2. Session 삭제하기
		 * 	1)세션 자체를 삭제하는것이 아니고 개별적인 세션 데이터를 삭제하기
		 * 	  형식) Session객체.removeAttribute("삭제할 key값");  
		 * 
		*/
		
		//session.removeAttribute("testSession");
		
		/*
		 * 	2)세션 자체를 삭제하기
		 * 	  형식) Session객체.invalidate();  
		 * 
		*/
		
		session.invalidate();
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>세션삭제하기</title>");
		out.println("<body>");
		out.println("<h2>session이 삭제 되었습니다.</h2>");
		out.println("<a href='"+request.getContextPath()+"/03/sessionJsp.jsp'>시작문서로 이동하기</a>");
		out.println("</body></html>");
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
