<%@page import="kr.or.ddit.memberWeb.VO.MemberWebVO"%>
<%@page import="java.util.List"%>
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

List<MemberWebVO> memberList = (List<MemberWebVO>)request.getAttribute("listDo");


%>
<table border="1">
	<tr>
		<td>ID</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>전화</td>
		<td>주소</td>
	</tr>
	
<%-- <% 
	for( MemberWebVO memberList0 : memberList){
%>
	
	<tr>
		<td><%= memberList0.getMem_id() %></td>
		<td><%= memberList0.getMem_pass() %></td>
		<td><%= memberList0.getMem_name() %></td>
		<td><%= memberList0.getMem_tel() %></td>
		<td><%= memberList0.getMem_addr() %></td>
	</tr>

<% 
	}

%> --%>

</table>

</body>
</html>