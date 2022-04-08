package kr.or.ddit.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadFileList
 */
@WebServlet("/uploadFileList.do")
public class UploadFileList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UploadFileList() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//사용자가 업로드한 파일이 저장될 서버쪽의 폴더경로 지정
		String uploadPath = "d:/d_other/uploadFiles";
		
		//저장될 폴더가 없으면 생성한다.
		File fdir = new File(uploadPath);
		if(!fdir.exists()) {
			//폴더생성
			fdir.mkdirs();
		}
		
		// upload한 파일이 저장되는 폴더의 파일목록을 가져와 List에 담는다.
		File[] allFiles = fdir.listFiles();
		List<FileInfo> fileList = new ArrayList<>();
		
		for(File f : allFiles) {
			FileInfo finfo = new FileInfo();
			finfo.setFileName(f.getName());
			finfo.setFileSize((int)Math.ceil(f.length()/1024.0));
			finfo.setStatus("Success");
			
			fileList.add(finfo);
			
		}
		request.setAttribute("fileList", fileList);
		request.getRequestDispatcher("/basic/upload/uploadFileList.jsp")
		.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
