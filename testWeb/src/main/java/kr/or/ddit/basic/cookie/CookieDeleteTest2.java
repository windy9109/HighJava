package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieDeleteTest2.do")
public class CookieDeleteTest2 extends HttpServlet {

	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
			- 저장된 쿠키정보 삭제하기
			==> 쿠키데이터의 삭제는 남은 쿠키의 유지시간을 0으로 설정하는 방법을 사용한다.
			==> 쿠키의 수명은 쿠키를 저장하는 assCookie()메서드를 호출하기 전에 
				해당쿠키객체의 setMaxAge()메서드를 이용하여 유지시간을 0으로 설정한다.
			형식) Cookie cookie 변수 = new Cookie("쿠키변수","쿠키값");
				 cookie변수.setMaxAge(시간);
				 	==> 시간이 0이면 쿠키가 바로 삭제되고, 시간이 음수이면 
				 		웹브라우저가 닫할때 쿠키가 삭제된다.	 	
		*/
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookieArr = request.getCookies();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>쿠키값 삭제</title></head>");
		out.println("<body>");
		out.println("<h3>저장된 쿠키 데이터 삭제하기</h3>");
		if(cookieArr == null || cookieArr.length == 0) {
			out.println("<h3>저장된 쿠키가 하나도 없습니다.</h3>");
		}else {
			// 2) 쿠키 배열에서 해당쿠키 정보를 구해온다.
			for(Cookie cookie: cookieArr) {
				//'쿠키변수' 구하기 ==> getName() 메서드이용
				String cookieName = cookie.getName();
				//해당 쿠키변수가 삭제하려는 쿠키변수인지 확인한다.
				// 예) 쿠키변수가 'gender'인 쿠키정보 삭제하기
				if("count".equals(cookieName)) {
					//해당쿠키를 찾았으면 유지시간을 0으로 설정한 후 다시저장한다.
					cookie.setMaxAge(0);
					//현재쿠키저장
					response.addCookie(cookie);
					out.println("<h3>count가 초기화 되었습니다.</h3>");
				}
				
			}
		}
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
