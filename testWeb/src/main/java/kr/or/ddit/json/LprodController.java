package kr.or.ddit.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class LprodController
 */
@WebServlet("/lprodController.do")
public class LprodController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		//응답데이터가 JSON데이터 일경우 ContentType을 아래와 같이 변경한다.
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//gson 객체생성
		Gson gson = new Gson();
		
		//json으로 변환된 문자열이 저장될 변수 선언
		String jsonData = null;
		
		LprodDao lprodDao = LprodDao.getInstance();
		List<LprodVO> selectLprod = lprodDao.getLprodList();
		
	//	List<LprodVO> list = new ArrayList<LprodVO>();
		
		
		jsonData = gson.toJson(selectLprod);
		
		System.out.println("jsonData => "+jsonData);
		//jsp로 보내기
		out.write(jsonData);
		//버퍼비우기(모든데이터)
		response.flushBuffer();
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
