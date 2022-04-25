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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import cumtrip.main.service.BoardServiceImpl;
import cumtrip.main.service.IBoardService;
import cumtrip.vo.BoardVo;
import cumtrip.vo.MemberVO;

/**
 * Servlet implementation class List
 */
@WebServlet("/List.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1. 요청시 전송 데이터 받기 - page 번호 받기, stype, sword
		int rqpage = Integer.parseInt(request.getParameter("page"));
		
		String rqtype = request.getParameter("stype");
		String rqword = request.getParameter("sword");

		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		MemberVO sessionValue = (MemberVO)session.getAttribute("loginMember");
		
		
//		System.out.println("rqword==> "+rqword);
//		System.out.println("rqtype==> "+rqtype);
//		System.out.println("rqpage==> "+rqpage);
		
		//2. service객체 얻기 
		IBoardService service = BoardServiceImpl.getInstance();
		
		
		//page관련 작업 - 전체 글갯수, 총페이지수
		//한페이지당 출력할 글갯수, 한 화면에 출력할 페이지 갯수
		Map<String, Object> pmap = service.getPageInfo(rqpage, rqtype, rqword);
		int startval = (int)pmap.get("start");
		int endval = (int)pmap.get("end");
		int startpage = (int)pmap.get("startpage");
		int endpage = (int)pmap.get("endpage");
		int totalpage = (int)pmap.get("totalpage");
		
		
		//paramete Map생성
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", startval);
		map.put("end", endval);
		map.put("stype", rqtype);
		map.put("sword", rqword);
		map.put("mem_email", sessionValue.getMem_email());
		
		
		//3. service메소드 호출하기 - 결과값 받기
		List<BoardVo> list = service.selectList(map);
		

		//4. 결과값으로 응답 데이터 생성 - html, text, xml, Json 데이터 
		JsonObject obj = new JsonObject();
		obj.addProperty("totalp", totalpage);
		obj.addProperty("startp", startpage);
		obj.addProperty("endp", endpage);
		
		Gson gson = new Gson();
		
		JsonElement ele = gson.toJsonTree(list);
				
		obj.add("datas", ele);
		response.setContentType("application/json; charset=utf-8");
	
		
		out.print(obj);
		out.flush();
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
