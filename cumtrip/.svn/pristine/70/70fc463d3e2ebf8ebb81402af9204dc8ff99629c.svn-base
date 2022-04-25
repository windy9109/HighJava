package cumtrip.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cumtrip.admin.service.MemberService;
import cumtrip.main.service.IMemberService;
import cumtrip.main.service.MemberServicelmpl;
import cumtrip.vo.MemberVO;

/**
 * Servlet implementation class mypage_payUdate
 */
@WebServlet("/mypage_payUdate.do")
public class mypage_payUdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public mypage_payUdate() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String cart_no0 = request.getParameter("cart_no0");
		
		IMemberService service = MemberServicelmpl.getInstance();
		
		Object res = service.mypage_payUdate01(cart_no0);
		
		//4.결과값을 request에 저장하기
		request.setAttribute("res1", res);
		//5. jsp로 forward
		request.getRequestDispatcher("view/jsp/forwardDo/result3.jsp").forward(request, response);
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String cart_no0 = request.getParameter("cart_no0");
		
		IMemberService service = MemberServicelmpl.getInstance();
		int res = service.mypage_payUdate02(cart_no0);
		
		//4.결과값을 request에 저장하기
		request.setAttribute("res1", res);
		//5. jsp로 forward
		request.getRequestDispatcher("view/jsp/forwardDo/result2.jsp").forward(request, response);
		
		
	}




}
