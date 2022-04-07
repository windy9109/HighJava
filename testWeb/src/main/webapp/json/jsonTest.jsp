<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax를 이용한 json데이터 처리하기</title>
<script src="<%= request.getContextPath()%>/js/jquery-3.6.0.min.js">
</script>
<script type="text/javascript">
$(function() {
	//문자열을 처리
	$("#strBtn").on("click", function() {
		$.ajax({
			url: "<%= request.getContextPath()%>/jsonController.do",
			type: "get",
			data: "choice=string",
			success: function(data) { //응답데이터 처리 함수
				let str = "문자열 데이터<hr>"
					str += data;
				$("#result").html(str);
			},
			error: function(vhr) {
				alert("오류"+vhr.status);	
			},
			dataType: "json" //응답으로 오는 데이터의 종류
			
		})
	})
	
	//----------------------------------------------------
	
	//문자열을 처리
	$("#arrayBtn").on("click", function() {
		$.ajax({
			url: "<%= request.getContextPath()%>/jsonController.do",
			type: "get",
			data: "choice=array",
			success: function(data) { //응답데이터 처리 함수
				let str = "배열데이터<hr>";
				$.each(data, function(i, v) {
					str += i + "번째데이터: "+ v + "<br>";
				});
				$("#result").html(str);
			},
			error: function(vhr) {
				alert("오류"+vhr.status);	
			},
			dataType: "json" //응답으로 오는 데이터의 종류
			
		})
	})
	
	//----------------------------------------------------------
	
	//객체처리
		$("#objBtn").on("click", function() {
		$.ajax({
			url: "<%= request.getContextPath()%>/jsonController.do",
			type: "get",
			data: "choice=object",
			success: function(data) { //응답데이터 처리 함수
				//{ "num":100, "name":"홍길동", "tel":"010-1234-5678" }
				let str = "객체 데이터<hr>";
				str += "번호: "+data.num +"<br>";
				str += "이름: "+data.name +"<br>";
				str += "전화: "+data.tel +"<br>";
				$("#result").html(str);
			},
			error: function(vhr) {
				alert("오류"+vhr.status);	
			},
			dataType: "json" //응답으로 오는 데이터의 종류
			
		})
	})
	
	
	//----------------------------------------------------------
	
	//리스트처리(자바의 List에서는 배열로 변환한다.)
	$("#listBtn").on("click", function() {
		$.ajax({
			url: "<%= request.getContextPath()%>/jsonController.do",
			type: "get",
			data: "choice=list",
			success: function(data) { //응답데이터 처리 함수
			/*
				[
					{ "num":100, "name":"홍길동", "tel":"010-1234-5678" }
					{ "num":200, "name":"홍길서", "tel":"010-1234-0987" }
					{ "num":300, "name":"홍길남", "tel":"010-1234-8765" }
				]
			*/
				let str = "리스트 데이터";
				
				$.each(data, function(i,v) {
					str += "<hr>";
					str += i + "번째 자료<br>";
					str += "번호: "+ v.num;
					str += "이름: "+ v.name;
					str += "전화: "+ v.tel;
					
				})
				$("#result").html(str);
			},
			error: function(vhr) {
				alert("오류"+vhr.status);	
			},
			dataType: "json" //응답으로 오는 데이터의 종류
			
		})
	})
	
	
	
	//----------------------------------------------------------
	
	//Map 처리 (자바의 Map은 JSON에서는 객체형으로 변환된다.)
	$("#mapBtn").on("click", function() {
		$.ajax({
			url: "<%= request.getContextPath()%>/jsonController.do",
			type: "get",
			data: "choice=map",
			success: function(data) { //응답데이터 처리 함수
			/*		
				{ 키값1: value값1, 키값2: value값2, 키값3: value값3 }
			*/
				let str = "map 데이터";
					str += "<hr>";
					str += "번호: "+ data.name+"<br>";
					str += "이름: "+ data.tel+"<br>";
					str += "전화: "+ data.addr+"<hr>";
					
					
				//방법2
				
				$.each(data, function(i, v) {
					//data가 객체형이면 i에는 변수명, v에는 데이터 값이 저장된다.
					str += i + "==>" + v+ "<br>";
				})
					
			
				$("#result").html(str);
			},
			error: function(vhr) {
				alert("오류"+vhr.status);	
			},
			dataType: "json" //응답으로 오는 데이터의 종류
			
		})
	})
	
	
	
	
	
})
</script>
</head>
<body>

<form>
	<input type="button" id="strBtn" value="문자열">
	<input type="button" id="arrayBtn" value="배열">
	<input type="button" id="objBtn" value="객체">
	<input type="button" id="listBtn" value="리스트">
	<input type="button" id="mapBtn" value="Map객체">
</form>

<hr>
<h3>응답 결과 출력</h3>
<div id ="result"></div>

</body>
</html>