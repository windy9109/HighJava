package kr.or.ddit.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/jsonController.do")
public class JsonController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		//응답데이터가 JSON데이터 일경우 ContentType을 아래와 같이 변경한다.
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String choice = request.getParameter("choice");
		
		//gson 객체생성
		Gson gson = new Gson();
		
		//json으로 변환된 문자열이 저장될 변수 선언
		String jsonData = null;
		
		switch (choice) {
		case "string":
			String str = "안녕하세요";
			//전송할 데이터를 json 형태의 문자열로 변환한다.
			//gson toJson()객체의 메서드이용
			jsonData = gson.toJson(str);
			break;
		//배열처리
		case "array":
			int[] arr = {10, 20, 30, 40, 50};
			jsonData = gson.toJson(arr);
			
			break;
			
		//배열처리
		case "object":
			SampleVO svo = new SampleVO(100, "홍길동", "010-1234-5678");
			jsonData = gson.toJson(svo);
			
			break;
			
		//배열처리
		case "list":
			ArrayList<SampleVO> list = new ArrayList<SampleVO>();
			list.add(new SampleVO(11, "이순신", "010-1234-1234"));
			list.add(new SampleVO(12, "강감찬", "010-1234-1234"));
			list.add(new SampleVO(13, "성춘향", "010-1234-1234"));
			jsonData = gson.toJson(list);
			
			break;
			
		//배열처리
		case "map":
			HashMap<String, String> map = new HashMap<>();
			map.put("name", "이몽룡");
			map.put("tel", "010-6789-1234");
			map.put("addr", "대전시 유성구 구암동");
			
			jsonData = gson.toJson(map);
			
			break;
				

		}
		
		System.out.println("jsonData => "+jsonData);
		//jsp로 보내기
		out.write(jsonData);
		//버퍼비우기(모든데이터)
		response.flushBuffer();
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
