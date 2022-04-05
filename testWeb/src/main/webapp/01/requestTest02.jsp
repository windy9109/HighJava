<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/testWeb/requestTest02.do" method="get">
<input type="text" name="number01" id="number01">
<select name="cal">
	<option value="+" >+</option>
	<option value="-" >-</option>
	<option value="*" >*</option>
	<option value="/" >/</option>
	<option value="%" >%</option>
</select>
<input type="text" name="number02" id="number02">
<input type="submit" value="전송">
</form>
</body>
</html>