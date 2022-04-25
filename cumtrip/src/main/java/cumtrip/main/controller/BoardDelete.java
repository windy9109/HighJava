package cumtrip.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cumtrip.main.service.BoardServiceImpl;
import cumtrip.main.service.IBoardService;
import cumtrip.vo.BoardVo;
import cumtrip.vo.MemberVO;



/**
 * Servlet implementation class BoardDelete
 */
@WebServlet("/BoardDelete.do")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardDelete() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		MemberVO sessionValue = (MemberVO)session.getAttribute("loginMember");
		
		int rqnum = Integer.parseInt(request.getParameter("num"));
		
		
		BoardVo vo = new BoardVo();
		
		vo.setMem_email(sessionValue.getMem_email());
		vo.setQ_number(rqnum);
		
		System.out.println("delete1: "+sessionValue.getMem_email());
		System.out.println("delete2: "+rqnum);
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		
		int num = service.deleteBorad(vo);
		
		
		request.setAttribute("res1",  num);
		request.getRequestDispatcher("view/jsp/forwardDo/result2.jsp").forward(request, response);
		
		
		
	}

}
