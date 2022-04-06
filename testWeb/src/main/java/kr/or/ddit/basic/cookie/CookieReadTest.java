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


@WebServlet("/cookieReadTest.do")
public class CookieReadTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CookieReadTest() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * - 저장된 쿠키 읽어오기
		 * 	 1) 전체 쿠키정보를 request객체를 통해서 가져온다.
		 * 		==> 가져온 쿠키정보들은 배열에 저장된다.
		 * 	 형식) Cookie[] 쿠키배열변수 = request.getCookie(); 
		 * 
		*/
		
		Cookie[] cookieArr = request.getCookies();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>쿠키값 확인</title></head>");
		out.println("<body>");
		out.println("<h3>저장된 쿠키 데이터 확인하기</h3>");
		if(cookieArr == null || cookieArr.length == 0) {
			out.println("<h3>저장된 쿠키가 하나도 없습니다.</h3>");
		}else {
			// 2) 쿠키 배열에서 해당쿠키 정보를 구해온다.
			for(Cookie cookie: cookieArr) {
				//'쿠키변수' 구하기 ==> getName() 메서드이용
				String cookieName = cookie.getName();
				//'쿠키값' 구하기 ==> getValue() 메서드이용
				// ==> URLDecoder.decod()메서드로 디코딩해서 사용한다.
				String cookieValue = URLDecoder.decode(cookie.getValue(), "utf-8");
				out.println("쿠키변수: "+cookieName+"<br>");
				out.println("쿠키값: "+cookieValue+"<hr>");
				
			}
		}
		out.println("<a href='"+request.getContextPath()+"/02/cookTestJSP.jsp'>시작문서로 가기</a>");
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
