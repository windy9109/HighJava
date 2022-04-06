package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("id");
		String userPass = request.getParameter("pass");
		String userSave = request.getParameter("save");

		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
//		out.println("<!DOCTYPE html>");
//		out.println("<head><meta charset='utf-8'>");
//		out.println("<title></title>");
//		out.println("<body>");
//		out.println("<h2>전송결과</h2>");
//		out.println("<table border = '1'>");
//		out.println("<tr><td>ID</td><td>"+userId+"</td></tr>");
//		out.println("<tr><td>PASS</td><td>"+userPass+"</td></tr>");
//		out.println("</table>");
		
	
		


			
			
			//쿠키저장하기
			if(userSave != null) {
				
				//쿠키에 저장된 값을 가져온다
				Cookie[] cookie = request.getCookies();
				
				
				Cookie idCookie = new Cookie("cookid", userId);
				response.addCookie(idCookie);
				
				//현재 id값이 저장될 변수
				String cookid = null; 
				for(  Cookie cook: cookie ) {
					//count = count+Integer.parseInt(cookie0.getValue());
					if("cookid".equals(cook.getName())) {
						//현재 방문값을 count에 저장한다.
						cookid = cook.getValue();
					}
				}
				
				out.println("</body></html>");
			
			}
			
			
			//쿠키지우기
			if( userSave == null) {
				
				
				Cookie[] cookieArr = request.getCookies();
					// 2) 쿠키 배열에서 해당쿠키 정보를 구해온다.
					for(Cookie cookie: cookieArr) {
						//해당 쿠키변수가 삭제하려는 쿠키변수인지 확인한다.
						// 예) 쿠키변수가 'gender'인 쿠키정보 삭제하기
						if("cookid".equals(cookie.getName())) {
							//해당쿠키를 찾았으면 유지시간을 0으로 설정한 후 다시저장한다.
							cookie.setMaxAge(0);
							//현재쿠키저장
							response.addCookie(cookie);
							
						}
						
					}
				
				
			}
			
			
			//로그인성공여부
			if(userId != null && userPass != null) {
				if(userId.equals("test") && userPass.equals("1234")) {
					//리다이렉트
					response.sendRedirect(request.getContextPath()+"/02/cookieMain.jsp");
	
					
				}else {
					//리다이렉트
					response.sendRedirect(request.getContextPath()+"/02/cookieLogin.jsp");
	
	
				}	
			}
			
			
			
	}
		
		
		



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
