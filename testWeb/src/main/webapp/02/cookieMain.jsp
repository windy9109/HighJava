<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 
	'id체크하기' 체크박스를 체크한 후 'Login'버튼을 클릭하면 
	입력했던 'ID'값을 쿠키에 저장하고, 쿠키에 'ID'값이 저장되어있으면 
	'ID'입력창에 쿠키에 저장되었던 'ID'값이 나타나도록하고, 
	체크박스도 체크가 되도록한다.

	체크박스를 해제한 후 로그인을 하면 쿠키에 저장된 'ID'값을 삭제하고
	체크박스도 해제된 상태가 되도록한다.
	
	로그인 성공은 ID와 Password가 'test','1234'이고,
	로그인이 성공하면 'cookieMain.jsp'로 이동하고 실패하면 
	'cookieLogin.jsp'로 이동한다.
	
	해당내용을 처리하는 서블릿의 URL은 '/cookieLoginServlet.do'이다.
	쿠키삭제기능도 포함
 -->

<h3>cookie연습용 main페이지 입니다.</h3>
<a href="<%= request.getContextPath() %>/02/cookieLogin.jsp">Login 창으로 이동</a>

<body>

</body>
</html>