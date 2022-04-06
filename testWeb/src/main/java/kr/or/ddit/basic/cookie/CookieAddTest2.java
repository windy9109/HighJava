package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieAddTest
 */
@WebServlet("/cookieAddTest2.do")
public class CookieAddTest2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		/*
		 * - Cookie 저장하는 방법
		 * 		==> 하나의 쿠키는 4kb(4096byte)까지 저장 가능하다.
		 * 		==> 한 도메인당 20개, 총 300개 까지 저장가능하다.
		 * 
		 * 
		 * 1) Cookie객체를 생성한다. ==> '쿠키변수'와 '쿠키값'은 문자열로 지정한다.
		 * 형식) Cookie cookie변수 ==> new Cookie("쿠키변수","쿠키값");
		 * 		==> 쿠키값으로 한글을 사용할 경우에는 URLEncoder.encode()메서드로 
		 * 			인코딩한후 저장한다.
		 * 
		*/
		
		
		//한글일때
		
		
		/*
		 * 2) 쿠키의 속성을 설정한다.
		 * 	  - 쿠키변수.setPath("적용경로");  
		 * 		  ==> 지정한 경로와 그 하위 경로에서 해당 쿠키를 사용할수 있다.
		 * 			생략하면 저장할 당시의 경로가 기본값으로 설정된다.
		 * 	  - 쿠키변수.setMaxAge(유지시간); ==> 단위(초)	
		 * 		  ==> -1: 브라우저가 종료될때까지 유지된다.(기본값)
		 * 		  ==> 0: 즉시 쿠키가 삭제된다.
		 * 		  ==> 양수값: 쿠키 유지시간
		 * 	  - 쿠키변수.setDomain("적용도메인명");
		 * 		  ==> 예) ".ddit.or.kr" ==> www.ddit.or.kr, mail.ddit.or.kr
		 * 	  - 쿠키변수.setSecure(보안여부); ==> true:적용, false:미적용(기본값)
		 * 
		 * 3) response객체를 이용해서 쿠키를 웹브라우저로 보내면 웹브라우저가 이 쿠키를 받아서 저장한다.
		 * 		형식) response.addCookie(1번에서 만든 쿠키변수);
		 * 
		 * 
		*/
		
		
		//쿠키에 저장된 count값을 가져온다
		Cookie[] cookie = request.getCookies();

		//현재 count값이 저장될 변수
		int count = 0; 
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>count증가하기</title></head>");
		out.println("<body>");
		
		for(  Cookie cookie0: cookie ) {
			//count = count+Integer.parseInt(cookie0.getValue());
			if("count".equals(cookie0.getName())) {
				//현재 방문값을 count에 저장한다.
				count = Integer.parseInt(cookie0.getValue());
			}
			
		}
		
		count++;// 현재 count값을 증가한다.
		//증가된 count 값을 쿠키에 저장한다.
		out.println("<h3>어서오세요 당신은"+count+"번째 방문입니다.</h3>");
		
		Cookie countCookie = new Cookie("count", String.valueOf(count));
		response.addCookie(countCookie);
		//해당쿠키를 찾았으면 유지시간을 0으로 설정한 후 다시저장한다.
		//cookie0.setMaxAge(0);
		//현재쿠키저장
		
		out.println("<hr>");
		out.println("<a href='"+request.getContextPath()+"/cookieAddTest2.do'>카운트 증가하기</a>");
		//webapp가 ContextPath 자리임
		out.println("<a href='"+request.getContextPath()+"/02/cookTestJSP2.jsp'>시작문서로 가기</a>");
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
