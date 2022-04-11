<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.0.min.js"></script>
<script>

$(function() {
	
	//리스트처리(자바의 List에서는 배열로 변환한다.)
	$("#listBtn").on("click", function() {
		$.ajax({
			url: "<%= request.getContextPath()%>/memberList.do",
			type: "get",
		//	data: "choice=list",
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
					str += "번호: "+ v.mem_id;
					str += "이름: "+ v.mem_name;
					str += "전화: "+ v.mem_pass;
					str += "번호: "+ v.mem_tel;
					str += "이름: "+ v.mem_addr;
					str += "전화: "+ v.mem_photo;
					
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

<input type="button" value="확인" id="listBtn">
<div class="result"></div>





</body>
</html>