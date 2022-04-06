<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>


<form action="<%= request.getContextPath() %>/cookieLoginServlet.do" method="get" name="form">


<!-- jsp문서(login 폼이 있는 문서)에서 쿠키를 확인해서 값을 셋팅하는 작업을 수행한다. -->
<%
String cooking = ""; //쿠키값이 저장될변수
String chk = ""; //체크박스 체크용
	Cookie[] cookieArr = request.getCookies(); // 쿠키정보가져오기
	if(cookieArr != null) {

		for(  Cookie cookie0: cookieArr ){	
			if("cookid".equals(cookie0.getName())){
				// 2) 쿠키 배열에서 해당쿠키 정보를 구해온다.
				
					//'쿠키변수' 구하기 ==> getName() 메서드이용
					String cookieName = cookie0.getName();
					//'쿠키값' 구하기 ==> getValue() 메서드이용
					// ==> URLDecoder.decod()메서드로 디코딩해서 사용한다.
					String cookieValue = cookie0.getValue();
					cooking = cookieValue;
					chk = "checked";
				
			}
		}
	}
	
	

%>

ID: <input type="text" name="id" id="id" value="<%= cooking %>">
<br>
PASS: <input type="text" name="pass" id="pass">
<br>
<input type="checkbox" name="save" id="save" <%= chk %>> id 기억하기
<br>
<input type="submit" value="Login">

</form>

</body>
</html>