<%@page import="kr.or.ddit.basic.session.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<% 
	//JSP문서에서 세션은 'session'이라는 이름으로 이미 생성되어 있다.
	MemberVO loginMemVo = (MemberVO)session.getAttribute("loginMember");

%>

<% 

if(loginMemVo == null){ //로그인관련 세션이 없을때
%>

<form action="<%= request.getContextPath() %>/sessionLogin.do" method="get">
<table border="1" style="margin: 0 auto;">
	<tr>
		<td>ID:</td>
		<td><input type="text" name="memid" placeholder="id를 입력하세요"></td>
	</tr>
	<tr>
		<td>PASS:</td>
		<td><input type="text" name="mempass" placeholder="PassWord를 입력하세요"></td>
	</tr>
	<tr colspan="2" style="text-align: center;">
		<td>PASS:</td>
		<td><input type="submit" value="Login"></td>
	</tr>
</table>
</form>

<%	
}else{  //로그인관련 세션이 있을때(로그인이 되었을때)
	

%>

	<h3><%= loginMemVo.getMem_id() %>님 반갑습니다</h3>
	<a href="<%= request.getContextPath() %>/sessionLogout.do">로그아웃</a>

<%	
}

%>

</body>
</html>