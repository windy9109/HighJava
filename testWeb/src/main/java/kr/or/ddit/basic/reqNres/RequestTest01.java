package kr.or.ddit.basic.reqNres;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest01
 */
@WebServlet("/requestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestTest01() {
        super();
        // TODO Auto-generated constructor stub
    }

	//Request객체 관련 예제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식으로 전달되는 데이터의 문자 인코딩 방식 설정
		request.setCharacterEncoding("utf-8");
		
		// 전달되는 데이터 받기
		//getParameter("파라미터명") ==> 해당파라미터에 설정된 '값'을 가져온다.
		//						  ==> 가져오는 '값'의 자료형은 무조건 'String'이다.
		 String userName = request.getParameter("userName");
		 String job =  request.getParameter("job");
		 
		 //.getParameterValue("파라미터명")
		 // 		==> '파라미터명'이 같은것이 여러개 일 경우에 사용한다.
		 // 		==> 가져오는 '값'의 자료형은 'String[]'이다.
		 
		 // getParamenterValues()메서드를 이용해서 'hobby'로
		 // 설정된 form의 체크박스 값들을 모두 가져오기
		 
		 String[] hobbies = request.getParameterValues("hobby");
		 
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html; charset=utf-8");
		 PrintWriter out = response.getWriter();
		 
		 out.println("<!DOCTYPE html>");
		 out.println("<html><head><meta charset='utf-8'>");
		 out.println("<title>Request객체 연습</title></head>");
		 out.println("<body>");
		 
		 out.println("<h2>Request 테스트 결과</h2>");
		 out.println("<table border = '1'>");
		 out.println("<tr><td>이름</td>");
		 out.println("<td>"+userName+"</td></tr>");
		 out.println("<tr><td>직업</td>");
		 out.println("<td>"+job+"</td></tr>");
		 out.println("</body></html>");
		 
		 out.println("<tr><td>취미</td>");
		 out.println("<td>");
		 if(hobbies != null) {
			 for(int i=0; i< hobbies.length; i++) {
				 out.println(hobbies[i]+"<br>");
			 }
			 out.println("<hr>");
			  
			 //향상된for문
			 for(String hobb : hobbies) {
				 out.println(hobb +"<br>");
			 }
			 
		 }else {
			 out.println("선택한 취미가 없습니다.");
		 }
		 out.println("</table>");
		 
		 
		 //request객체에서 제공하는 메서드
		 out.println("<h2>Request객체 제공 매서드</h2>");
		 out.println("<ul>");
		 out.println("<li>클라이언트 주소: "+request.getRemoteAddr() +"</li>");
		 out.println("<li>요청메서드: "+ request.getMethod()+"</li>");
		 out.println("<li>ContextPath: "+request.getContextPath()+"</li>");
		 out.println("<li>프로토콜:"+ request.getProtocol()+"</li>");
		 out.println("<li>URL정보:"+request.getRequestURL()+"</li>");
		 out.println("<li>URI정보:"+request.getRequestURI()+"</li>");
		 out.println("</ul><hr>");
		 
		 out.println("<br><hr><br>");
		 
		 //전송된 모든 파라미터명 구하기
		 // 		==> getParameterNames()메서드
		 //				반환값: Emumeration<String>형
		 Enumeration<String> params = request.getParameterNames();
		 out.println("<h2>전송된 파라미터명들...</h2>");
		 out.println("<ul>");
		 while(params.hasMoreElements()) {
			 String name = params.nextElement();
			 out.println("<li>"+name+"</li>");
		 }
		 out.println("</ul><hr>");
		 out.println("<br><hr><br>");
		 
		 
		 //getParameterMap() ==> 전송된 모든 파라미터를 Map객체에 담아서 반환한다.
		 // 		이 메서드에서 반환하는 Map객체는 key값은 파라미터명이고
		 //			자료형은 String이다.
		 //			value값은 해당 파라미터에 저장된 '값'이고 자료형은 String[]형이다
		 out.println("<h2>getParameterMap()의 결과</h2>");
		 out.println("<table border = '1'>");
		 out.println("<table border = '1'>");
		 
		 out.println("<tr><td>파라미터 name</td><td>파라미터 value</td></tr>");
		 
		 Map<String, String[]> paramMap = request.getParameterMap();
		 for(String paramName: paramMap.keySet()) {
			 //파라미터 name출력 
			 out.println("<tr><td>"+paramName+"</td>");
			 //파라미터 value값 구하기
			 String[] paramValue = paramMap.get(paramName);
			 out.println("<td>");
			 //파라미터값이 없는경우
			 if(paramValue == null || paramValue.length == 0) {
				 continue;
			 }else if(paramValue.length == 1){ //파라미터가 배열이 아닌경우
				 out.println(paramValue[0]);
			 }else {
				 for(int i=0; i<paramValue.length; i++) {
					 out.println(paramValue[i]+"<br>");
				 }
			 }
			 out.println("</td></tr>");
			 
		 }
		 out.println("</table>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
