package cumtrip.main.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.border.Border;

import cumtrip.main.service.BoardServiceImpl;
import cumtrip.main.service.IBoardService;
import cumtrip.vo.BoardVo;
import cumtrip.vo.MemberVO;

/**
 * Servlet implementation class HitUpdate
 */
@WebServlet("/HitUpdate.do")
public class HitUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HitUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		MemberVO sessionValue = (MemberVO)session.getAttribute("loginMember");

		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardVo vo = new BoardVo();
		
		vo.setMem_email(sessionValue.getMem_email());
		vo.setQa_title(subject);
		vo.setQa_content(content);
		vo.setQ_number(num);
		
		
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		
		int res = service.updateHit(vo);
		
		
		
		request.setAttribute("res1",  res);
		request.getRequestDispatcher("view/jsp/forwardDo/result2.jsp").forward(request, response);
		
		
	}

}
