package kr.or.ddit.memberWeb.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		 out.println("<h2>계산 결과</h2>");
		 
//		MemberWebService service = MemberWebServiceImpl.getInstance();
//		List<MemberWebVO> list = service.selectAll();
		
		
		//response.sendRedirect(request.getContextPath()+"/memberList.jsp");

	//request.setAttribute("listDo", list);
		request.getRequestDispatcher("/memberList.jsp")
		.forward(request, response);
	
	//jsp파일로보냄
	//response.sendRedirect(request.getContextPath()+"/memberList.jsp");
		
		 //다른 서블릿파일로 보냄
		//RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath()+"/memberList.do");
		//rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
