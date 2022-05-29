package cumtrip.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cumtrip.admin.service.MemberService;
import cumtrip.vo.A_adminVO;

/**
 * Servlet implementation class Uploadquestion
 */
@WebServlet("/uploadquestion.do")
public class Uploadquestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
				MemberService service = MemberService.getInstance();
			String qno = 	request.getParameter("qno");
			String answer = request.getParameter("answer");
			A_adminVO vo = new A_adminVO();
			System.out.println(qno);
			System.out.println(answer);
			vo.setQa_no(qno);
			vo.setAd_content(answer);
			
			int result = service.uploadquestion(vo);
			System.out.println(result);
			
			response.sendRedirect(request.getContextPath()+"/admin/qna.jsp");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
