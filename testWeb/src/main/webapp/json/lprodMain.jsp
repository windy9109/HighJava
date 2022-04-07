<%@page import="kr.or.ddit.json.LprodVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%= request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	//리스트 처리
	$("#lprodBtn").on("click", function() {
		$.ajax({
			url: "<%= request.getContextPath()%>/lprodController.do",
			type: "get",
			success: function(data) { //응답데이터 처리 함수
				
				let str = "<table border='1'>";	
				str += "<tr><td>LPROG_ID</td>";	
				str += "<td>LPROG_GU</td>";	
				str += "<td>LPROG_NM</td></tr>";	
				
				$.each(data, function(i,v) {
					str += "<tr>";
					str += "<td>id: "+ v.lprod_id+"</td>";
					str += "<td>gu: "+ v.lprod_gu+"</td>";
					str += "<td>nm: "+ v.lprod_nm+"</td></tr>";
					
				})
				str += "</table>";	
				
				$("#result").html(str);
			},
			error: function() {
				alert("오류");	
			},
			dataType: "json" //응답으로 오는 데이터의 종류
			
		})
	})
	
	
	$("#lprodBtn2").on("click", function() {
		
		location.href = "<%= request.getContextPath() %>/lprodList2.do"
		
	
			
	})
	
	
})
</script>
</head>
<body>

<!-- 
	DB의 LPROD테이블의 전체 데이터를 가져와 화면에 출력하시오.
 -->
<form>
	<input type="button" id="lprodBtn" value="Lprod자료 가져오기(ajax)">
	<input type="button" id="lprodBtn2" value="Lprod자료 가져오기(non ajax)">
</form>

<h3>lprod 자료목록</h3>
<div id="result"></div>

</body>
</html>