package kr.or.ddit.fileupload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/fileDownLoad.do")
public class FileDownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//다운로드할 파일명을 파라미터로 구한다.
		String fileName = request.getParameter("filename");
		
		//사용자가 업로드한 파일이 저장될 서버쪽의 폴더경로 지정
		String uploadPath = "d:/d_other/uploadFiles";
		
		//저장될 폴더가 없으면 생성한다.
		File fdir = new File(uploadPath);
		if(!fdir.exists()) {
			//폴더생성
			fdir.mkdirs();
		}
		
		
		String filePath = uploadPath + File.separator + fileName;
		File file = new File(filePath);
		
		if(file.exists()) {  //다운로드할 파일이 있을때....
			response.setContentType("application/octet-stream; charset=UTF-8");
			
			//response의 헤더에 다운로드할 파일명을 설정한다.
			String headerkey = "Content-Disposition";
			//String headerValue = "attachment; filename=\""+fileName+"\"";
			String headerValue = "attachment; "+ getEncodedFileName(request, fileName);
			response.setHeader(headerkey, headerValue);
			
			//스트림객체를 이용해서 입출력을 진행한다.
			BufferedOutputStream bos = null;
			BufferedInputStream bis = null;
			
			
			try {
				//출력용 스트림 객체생성 ==> response객체 이용
				bos = new BufferedOutputStream(response.getOutputStream());
				
				//파일입력용 스트림객체 생성
				bis = new BufferedInputStream(new FileInputStream(file));
				
				byte[] temp = new byte[1024];
				int len = 0;
				
				//byte배열을 이용해서 파일내용을 읽어와 출력용 스트림으로 출력한다.
				while((len=bis.read(temp))>0) {
					bos.write(temp, 0, len);
				}
				
				bos.flush();
				
			} catch (IOException e) {
				System.out.println("입출력오류: "+ e.getMessage());
			}finally {
				if(bis != null) try { bis.close();} catch (IOException e) {}
				if(bos != null) try { bos.close();} catch (IOException e) {}
				
			}
			
			
		}else {	 //다운로드할 파일이 있을때...
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().println("<h3>"+fileName+"파일은 존재하지 않습니다.</h3>");
			
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	
	
	//다운로드 파일명의 한글깨짐 방지 메서드
	private String getEncodedFileName(HttpServletRequest request, String fileName) {
		String encodeFilename = null;
		
		//웹브라우저의 종류 구분하기
		String userAgent = request.getHeader("User-Agent");
		System.out.println("userAgent ==> "+userAgent );
		
		try {
			//MSIE 10이하
			if(userAgent.contains("MSIE") || userAgent.contains("Trident")) {
				encodeFilename = "filename=\""+URLEncoder.encode(fileName, "utf-8")
				.replaceAll("\\+","\\ ")+"\"";
				
			}else {  //MSIE이외의 웹브라우저
				encodeFilename = "filename*=utf-8''"+URLEncoder.encode(fileName,"utf-8")
				.replaceAll("\\+", "%20");
				
			}
			
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("지원하지 않는 인코딩 방식입니다.");
		}
		
		return encodeFilename;
		
	}
	
	
	
}
