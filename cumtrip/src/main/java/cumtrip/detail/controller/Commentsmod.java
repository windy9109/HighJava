package cumtrip.detail.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cumtrip.detail.service.DetailService;
import cumtrip.vo.M_commentVO;
import cumtrip.vo.S_commentVO;

/**
 * Servlet implementation class Commentsmod
 */
@WebServlet("/commentsmod.do")
public class Commentsmod extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		String scono = request.getParameter("scono");
		String ccomment = request.getParameter("ccomment");
		S_commentVO vo = new S_commentVO();
		DetailService service = DetailService.getInstance();
		vo.setSco_no(scono);
		vo.setSco_content(ccomment);
		
		int result   = service.commentsmod(vo);
		
		Gson gson = new Gson();

		String jsonData = gson.toJson(result);
		out.write(jsonData);
		response.flushBuffer();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
