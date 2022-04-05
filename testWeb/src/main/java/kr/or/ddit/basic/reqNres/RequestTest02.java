package kr.or.ddit.basic.reqNres;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest02
 */
@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestTest02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 전달되는 데이터 받기
		//getParameter("파라미터명") ==> 해당파라미터에 설정된 '값'을 가져온다.
		//						  ==> 가져오는 '값'의 자료형은 무조건 'String'이다.
		 String num01 = request.getParameter("number01");
		 String num02 =  request.getParameter("number02");
		 String cal = request.getParameter("cal");
		 
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html; charset=utf-8");
		 PrintWriter out = response.getWriter();
		Double total = 0.0;
		 
			if(cal.equals("+")) total = (Math.round((Double.parseDouble(num01)+Integer.parseInt(num02))*10)/10.0);
			if(cal.equals("-")) total = (Math.round((Double.parseDouble(num01)-Integer.parseInt(num02))*10)/10.0);
			if(cal.equals("*")) total = (Math.round((Double.parseDouble(num01)*Integer.parseInt(num02))*10)/10.0);
			if(cal.equals("/") && !num02.equals("0")) total = (Math.round((Double.parseDouble(num01)/Integer.parseInt(num02))*10)/10.0);
			if(cal.equals("%") && !num02.equals("0")) total = (Math.round((Double.parseDouble(num01)%Integer.parseInt(num02))*10)/10.0);
			

		 
		 out.println("<!DOCTYPE html>");
		 out.println("<html><head><meta charset='utf-8'>");
		 out.println("<title>Request객체 연습</title></head>");
		 out.println("<body>");
		 out.println("<h2>계산 결과</h2>");
		if(total != 0.0) out.println("<div>"+num01+cal+num02+"</div> ="+total);
		if(cal.equals("/") && num02.equals("0") || cal.equals("%") && num02.equals("0") ) out.println("계산불능");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
