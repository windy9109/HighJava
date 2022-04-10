package kr.or.ddit.memberWeb.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.memberWeb.Service.MemberWebService;
import kr.or.ddit.memberWeb.Service.MemberWebServiceImpl;
import kr.or.ddit.memberWeb.VO.MemberWebVO;

/**
 * Servlet implementation class MemberWebController
 */
@WebServlet("/memberList.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberList() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		request.setCharacterEncoding("utf-8");
//		
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		
//		 out.println("<h2>계산 결과</h2>");
//		 
//		String jsonData = null;
//		//gson 객체생성
//		Gson gson = new Gson();
//			
//			
//		MemberWebService service = MemberWebServiceImpl.getInstance();
//		List<MemberWebVO> list = service.selectAll();
//		
//		
//		jsonData = gson.toJson(list);
//		
//		System.out.println("jsonData => "+jsonData);
//		//jsp로 보내기
//		out.write(jsonData);
//		//버퍼비우기(모든데이터)
//		response.flushBuffer();
		
		
		
		
		//2. service 객체 얻기
		MemberWebService service = MemberWebServiceImpl.getInstance();
		
		//3. service 메소드 호출하기 결과값 return 받기
		List<MemberWebVO> list = service.selectAll();
		
		//4. request에 결과 값을 저장
		//request.setAttribute("listvalue", list);
		
		//5. jsp로 위임(forward)하여 응답데이터 생성하기(출력또는 json 데이터)
		//request.getRequestDispatcher("0401/sido.jsp").forward(request, response);
		
		Gson gon = new Gson();
		String result = gon.toJson(list);
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(result);
		out.flush();
		
		
		
		//response.sendRedirect(request.getContextPath()+"/memberList.jsp");

	//request.setAttribute("listDo", list);
		
		 
		 //foreward 실행
	//	 request.getRequestDispatcher("/memberList.jsp")
	//	.forward(request, response);
	
		 
		 
	//jsp파일로보냄
	//response.sendRedirect(request.getContextPath()+"/memberList.jsp");
		
		 //다른 서블릿파일로 보냄
		//RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath()+"/memberList.do");
		//rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
