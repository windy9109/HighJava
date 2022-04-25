package cumtrip.detail.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cumtrip.detail.service.DetailService;
import cumtrip.vo.MemberVO;
import cumtrip.vo.Mr_likesVO;

@WebServlet("/InsertMrlikes.do")
public class InsertMrlikes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		DetailService service = DetailService.getInstance();
		Mr_likesVO vo = new Mr_likesVO();
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("loginMember");
		
		String midno = request.getParameter("midno");
		String email = memvo.getMem_email();
		String mreno = request.getParameter("mreno");
		
		vo.setMre_no(mreno);
		vo.setMem_email(email);
		
		int result = service.insertmrlikes(vo);
		
		Gson gson = new Gson();
		String jsondata =  gson.toJson(vo);
		
		out.write(jsondata);
		response.flushBuffer();
		
		response.sendRedirect("/cumtrip/view/jsp/detailpage.jsp?midno="+midno+"");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
