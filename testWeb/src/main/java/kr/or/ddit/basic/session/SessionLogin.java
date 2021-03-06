package kr.or.ddit.basic.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionLogin
 */
@WebServlet("/sessionLogin.do")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SessionLogin() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//사용자가 입력한 id와 pass를 파라미터로 받는다.
		String memid = request.getParameter("memid");
		String mempass = request.getParameter("mempass");
		
		//파라미터로 받은 데이터를 VO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memid);
		memVo.setMem_pass(mempass);
		
		//DB처리를 위한 Dao객체 생성
		MemberDao memDao = MemberDao.getInstance();
		
		//DB처리를 수행하고 결과를 받아서 VO객체에 저장한다.
		MemberVO loginMemberVo = memDao.getMember(memVo);
		
		//로그인 성공여부 확인
		if(loginMemberVo != null) { //로그인 성공시
			//session 객체생성
			HttpSession session = request.getSession();
			//session에 로그인 성공 vo객체를 저장한다.
			session.setAttribute("loginMember", loginMemberVo);
			
		}
		//처음 시작한 jsp문서로 이동한다.
		response.sendRedirect(request.getContextPath()+"/03/sessoinLogin.jsp");
		
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
