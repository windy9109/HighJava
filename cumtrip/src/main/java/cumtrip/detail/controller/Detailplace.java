package cumtrip.detail.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cumtrip.admin.service.StayService;
import cumtrip.detail.service.DetailService;
import cumtrip.vo.MiddleVO;
import cumtrip.vo.RoomVO;

/**
 * Servlet implementation class Detailplace
 */
@WebServlet("/detailplace.do")
public class Detailplace extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		String midno = request.getParameter("midno");
		
		DetailService service = DetailService.getInstance();
		MiddleVO vo   = service.seletectdetail(midno);
		
		Gson gson = new Gson();

		String jsonData = gson.toJson(vo);
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
