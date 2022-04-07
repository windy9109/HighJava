package kr.or.ddit.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class LprodList2
 */
@WebServlet("/lprodList2.do")
public class LprodList2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LprodList2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		//응답데이터가 JSON데이터 일경우 ContentType을 아래와 같이 변경한다.
		//response.setContentType("application/json; charset=UTF-8");
		
		 response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		
		LprodDao lprodDao = LprodDao.getInstance();
		List<LprodVO> selectLprod = lprodDao.getLprodList();
		
	
		 
		 request.setAttribute("selectLprod", selectLprod);
		 //view페이지로 포워딩한다.
		 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/lprod/lprodMain2.jsp");
		// response.sendRedirect(request.getContextPath()+"/json/lprodMain.jsp");
		 rd.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
