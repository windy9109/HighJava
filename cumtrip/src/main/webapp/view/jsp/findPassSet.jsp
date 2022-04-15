<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%    
    request.setCharacterEncoding("UTF-8");
    String mem_mail = request.getParameter("mem_mail");
%>

<!DOCTYPE html>
<html>
<head>
<title>CUM TRIP</title>
<link rel="stylesheet" href="../css/main.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="../js/main.js"></script> 
<script src="../js/findIDpass.js"></script> 
</head>
<body>
	<header id="header"><!-- 상단 헤더 불러오기 --></header>
	<contain>
		<div class="Page_rwrap">
			<h3>CUM TRIP</h3>
			<h1>비밀번호 변경</h1>
			<div class="passSet_Name"><span class="passSet_NameSpan"><%= mem_mail %></span>님의 비밀번호를 변경합니다.</div>
			<div class="Page_p">변경할 비밀번호를 입력해주세요.</div>
			<form id="find_passSet_form">
				<label>새 비밀번호</label>
				<input type="text" name="set_passWord" id="set_passWord"><br>
				<label>새 비밀번호 재입력</label>
				<input type="text" id="set_passWord2"><br>
				<div class="passSet_box"></div>
				<input type="submit" value="비밀번호변경">
			</form>
		</div>
	</contain>
	<footer id="footer"><!-- 하단불러오기 --></footer>
</body>
</html>