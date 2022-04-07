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
				
				let str = "리스트 데이터";	
				$.each(data, function(i,v) {
					str += "<hr>";
					str += "id: "+ v.lprod_id+"<br>";
					str += "gu: "+ v.lprod_gu+"<br>";
					str += "nm: "+ v.lprod_nm+"<br>";
					
				})
				$("#result").html(str);
			},
			error: function() {
				alert("오류");	
			},
			dataType: "json" //응답으로 오는 데이터의 종류
			
		})
	})
	
})
</script>
</head>
<body>

<!-- 
	DB의 LPROD테이블의 전체 데이터를 가져와 화면에 출력하시오.
 -->
<form>
	<input type="button" id="lprodBtn" value="Lprod자료 가져오기">
</form>

<h3>lprod 자료목록</h3>
<div id="result"></div>

</body>
</html>