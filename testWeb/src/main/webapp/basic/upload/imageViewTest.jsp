<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>IMG태그의 src속성에 서블릿으로 이미지 처리하기</h3>
<hr>

<img src="<%= request.getContextPath() %>/images/chopa.jpg" width="300">
<hr>

<img src="<%= request.getContextPath() %>/imageSrcView.do?filename=chopa.jpg" width="300">


</body>
</html>