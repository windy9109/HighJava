package cumtrip.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cumtrip.main.service.IMemberService;
import cumtrip.main.service.MemberServicelmpl;
import cumtrip.vo.AttractionVO;
import cumtrip.vo.MattractVO;
import cumtrip.vo.MemberVO;


@WebServlet("/MainMattractionInsert2.do")
public class MainMattractionInsert2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
	    HttpSession session = request.getSession();
		IMemberService service = MemberServicelmpl.getInstance();
		
		MattractVO vo = new MattractVO();
		
	    String[] attrnum = request.getParameterValues("attr");

		MemberVO mavo = (MemberVO) session.getAttribute("loginMember");
		
		
		service.taste_delect(mavo.getMem_email());
		

		String email = mavo.getMem_email();
		vo.setMem_email(email);
	    for(int i = 0 ; i< attrnum.length; i++) {
	    vo.setAttr_no(Integer.parseInt(attrnum[i]));
	    int result = service.mattractinsert(vo);
	    }
		response.sendRedirect("/cumtrip/view/jsp/mypage/mypage_trip.jsp");
		
		
		
	}

}
