package cumtrip.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cumtrip.main.service.BoardServiceImpl;
import cumtrip.main.service.IBoardService;
import cumtrip.main.service.IMemberService;
import cumtrip.main.service.MemberServicelmpl;
import cumtrip.vo.BoardVo;
import cumtrip.vo.MemberVO;

/**
 * Servlet implementation class MypageQnaInsert
 */
@WebServlet("/MypageQnaInsert.do")
public class MypageQnaInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MypageQnaInsert() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		MemberVO sessionValue = (MemberVO)session.getAttribute("loginMember");
		String title = request.getParameter("subject");
		String content = request.getParameter("content");
		
		//2.service객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();

		
		BoardVo vo = new BoardVo();
		vo.setMem_email(sessionValue.getMem_email());
		vo.setQa_title(title);
		vo.setQa_content(content);
		
		
	
		
		//3.service메소드 호출하기
		Object res = service.insertQnaMypage(vo);
		
		
		request.setAttribute("res1", res);
		request.getRequestDispatcher("view/jsp/forwardDo/result3.jsp").forward(request, response);
		
	}

}
