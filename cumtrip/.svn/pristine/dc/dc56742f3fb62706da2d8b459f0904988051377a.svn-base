package cumtrip.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cumtrip.admin.service.MemberService;
import cumtrip.detail.dao.DetailDao;
import cumtrip.main.service.IMemberService;
import cumtrip.main.service.MemberServicelmpl;
import cumtrip.vo.MattractVO;
import cumtrip.vo.MemberVO;
import cumtrip.vo.SubPrintVO;


@WebServlet("/MainMattraction.do")
public class MainMattraction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		IMemberService service = MemberServicelmpl.getInstance();
		
	
		HttpSession session = request.getSession();
		MemberVO mavo = (MemberVO) session.getAttribute("loginMember");
		String email = mavo.getMem_email();
		String result = service.mattractcheck(email);
		
		
		
		Gson gson =  new Gson();
		String jsondata = gson.toJson(result);
		out.write(jsondata);
		out.flush();

	
		
		
	}

}
