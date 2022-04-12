<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%= request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script>

$(function() {
	
	//리스트처리(자바의 List에서는 배열로 변환한다.)
	$("#listBtn").on("click", function() {
		$.ajax({
			url: "<%=request.getContextPath()%>/memberList.do",
			type: "get",
		//	data: "choice=list",
			success: function(data) { //응답데이터 처리 함수
				str = "<table border='1'><tr><td colspan='5' style='text-align: right;'><input type='button' value='회원추가' id='insert' name='insert'></td></tr>";
				str += "<tr><td>아이디:</td><td>이름:</td><td>패스워드:</td><td>전화:</td><td>주소:</td></tr>";
			
				$.each(data, function(i,v) {
					str += "<tr><td><a href='<%=request.getContextPath()%>/memberList.jsp'>"+v.mem_id+"</a></td>";
					str += "<td>"+v.mem_name+"</td>";
					str += "<td>"+v.mem_pass+"</td>";
					str += "<td>"+v.mem_tel+"</td>";
					str += "<td>"+v.mem_addr+"</td>";
					
				})
				
				str += "</table>";
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
<div id="result"></div>





</body>
</html>