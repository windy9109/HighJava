<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 연습</title>
</head>
<body>

<% 

// JSP문서에서는 세션 객체가 'session'이라는 이름으로 이미 생성되어있다. 

%>

<a href="<%= request.getContextPath() %>/sessionAddTest.do">
session 정보저장하기</a>
<br><hr><br>

<a href="<%=request.getContextPath() %>/sessionReadTest.do">
session 정보확인하기</a>
<br><hr><br>

<a href="<%=request.getContextPath() %>/sessionDeleteTest.do">
session 정보삭제하기</a>
<br><hr><br>

</body>
</html>