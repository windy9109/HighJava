package cumtrip.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cumtrip.admin.service.PhotoService;
import cumtrip.vo.S_photoVO;

/**
 * Servlet implementation class Roomupload
 */
@WebServlet("/roomupload.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024*10,
		maxFileSize = 1024*1024*30,
		maxRequestSize = 1024*1024*50
		)
public class Roomupload extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		S_photoVO vo = new S_photoVO();
		PhotoService service = PhotoService.getInstance();
		String roomno = request.getParameter("roomno");
		String stayno = request.getParameter("stayno");
		List<Fileinfo> list = new ArrayList<Fileinfo>();
		String uploadPath = "d:/연습용산출물/traveler/stay/"+stayno;
		
		File fdir = new File(uploadPath);
		if(!fdir.exists()) {
			fdir.mkdirs();
		}
		
		String fileName = ""; //파일명이 저장될 변수명 
	
		 int result = 0;
		 //전체 Part객체 개수만큼 반복 	
		 for(Part part : request.getParts()) {
			 // 1개의 업로드 파일 정보를 구한다. 
			 fileName = extractFilename(part);
			
			 if(!fileName.equals("")) {
			 
				 Fileinfo finfo = new Fileinfo();
				 finfo.setFileName(fileName);
				 finfo.setFileSize((int)Math.ceil((part.getSize()/1024.0)));
				 try {
					 //Upload된 파일을 서버쪽 저장장소에 저장한다. 
					 part.write(uploadPath+File.separator+fileName);
					 finfo.setStatus("Success");
				} catch (IOException e) {
					finfo.setStatus("fail : " +e.getMessage());
				}
				 list.add(finfo); // 파일 정보를 List에 추가
				vo.setSpho_path(fileName);
				result = service.insertroomphoto(vo);
			 }
		 }

		 response.sendRedirect(request.getContextPath()+"/admin/selectstay.jsp?result="+result);
		
		
	}
	private String extractFilename(Part part) {
		String fileName = "";
		
		//각 Part의 Content-Dispostion의 값 구하기 
		String contentDispostion =
				part.getHeader("Content-Disposition");
		String[] items = contentDispostion.split(";");
		for(String item : items) {
			// 파일 정보 찾기 
			if(item.trim().startsWith("filename")) {
				// fileName="test1.txt"
				fileName = item.substring(item.indexOf("=")+2,item.length()-1);
			}
		}
		
		return fileName;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

