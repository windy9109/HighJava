package cumtrip.submain.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<<< HEAD:cumtrip/src/main/java/cumtrip/submain/controller/TAllPhoto.java
@WebServlet("/TPhoto.do")
public class TAllPhoto extends HttpServlet {
========
@WebServlet("/reviewphoto.do")
public class FPhoto extends HttpServlet {
>>>>>>>> c2f2a6fbe0cc12547d7201f74cd377ea94314f8e:cumtrip/.svn/pristine/c6/c6f4dd6c6990e376bd4bc7b99bb2d2e34b8e98fe.svn-base
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String filename = request.getParameter("filename");
		String dowloadPath = "d:/연습용산출물/traveler/space/";
		String filePath = dowloadPath + File.separator+filename;
		
		File file = new File(filePath);
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		if(file.exists()) { // file이 있으면
			try {
				// 출력용 스트림
				bos = new BufferedOutputStream(response.getOutputStream());
				
				// 입력용 스트림
				bis = new BufferedInputStream(new FileInputStream(file));
				
				byte[] temp = new byte[1024];
				int len = 0;
				while((len = bis.read(temp)) > 0) {
					bos.write(temp, 0, len);
				}
				bos.flush();
				
			} catch (IOException e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
				if(bis != null) try { bis.close(); } catch(IOException e) {}
				if(bos != null) try { bos.close(); } catch(IOException e) {}
			}
			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
