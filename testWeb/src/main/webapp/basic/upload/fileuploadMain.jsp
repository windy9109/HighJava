<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet 파일업로드 연습</title>
</head>
<body>
	<h2>File Upload연습</h2>
	<!-- 
		파일을 업로드 하기위한 form태그 구성방법
		1. 파일업로드는  무조건 post방식
		2. enctype에 multipart/form-data 를 설정해야한다.
	-->
	<form action="<%= request.getContextPath() %>/fileUploadTest.do" method="post" enctype="multipart/form-data" >
		이름: <input type="text" name="username"><br><br>
		Upload File1 : <input type="file" name="fileUpload1"><br><br>
		<!-- multiple옵션이 있다면 여러개의 파일을 한번에 선택할수있다. -->
		Upload File2 : <input type="file" name="fileUpload2" multiple><br><br>
		<input type="submit" value="Update">
	
	
	</form>
	
	<hr>
	
	<a href="<%= request.getContextPath() %>/uploadFileList.do">전체 upload한 파일 목록보기</a>
	
</body>
</html>