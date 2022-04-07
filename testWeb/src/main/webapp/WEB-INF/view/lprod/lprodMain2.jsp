<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.json.LprodList2"%>
<%@page import="kr.or.ddit.json.LprodVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%
	List<LprodVO> lprod2 = (List<LprodVO>)request.getAttribute("selectLprod");
%>

</head>
<body>

			
 			
		<h2>Lprod</h2>
		<table border = '1'>
		<tr><td>id</td>
		<td>gu</td>
		<td>nm</td></tr>
		<% 
		
		for(LprodVO lprod: lprod2){
			%>
			
		<tr><td><%=lprod.getLprod_id()%></td>
		<td><%=lprod.getLprod_gu()%></td>
		<td><%=lprod.getLprod_nm()%></td></tr>
			
			<%
			
		}
		
		%>
		</table>

</body>
</html>