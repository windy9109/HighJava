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

import cumtrip.main.service.IMemberService;
import cumtrip.main.service.MemberServicelmpl;
import cumtrip.vo.MemberVO;

/**
 * Servlet implementation class Mypagelike_trip
 */
@WebServlet("/Mypageliketrip.do")
public class Mypagelike_trip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Mypagelike_trip() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		MemberVO sessionValue = (MemberVO)session.getAttribute("loginMember");

		
		//2.service객체 얻기
		IMemberService service = MemberServicelmpl.getInstance();

		
		Map<String, String> vo3 = new HashMap<String, String>();
		vo3.put("id1",sessionValue.getMem_email());
		vo3.put("id2",sessionValue.getMem_email());
		
		//3.service메소드 호출하기
		List<MemberVO> res = service.likeMypage02(vo3);
		
		
		Gson gson = new Gson();

		String jsonData = gson.toJson(res);
		out.write(jsonData);
		response.flushBuffer();
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		HttpSession session = request.getSession();
		
		MemberVO sessionValue = (MemberVO)session.getAttribute("loginMember");

		sessionValue.setMid_no(request.getParameter("number_no"));
		
		//2.service객체 얻기
		IMemberService service = MemberServicelmpl.getInstance();

		
		//3.service메소드 호출하기
		int res = service.likeMypageDelete03(sessionValue);
		
		
		
		
		request.setAttribute("res1", res);
	
		request.getRequestDispatcher("view/jsp/forwardDo/result2.jsp").forward(request, response);
		
	}

}
