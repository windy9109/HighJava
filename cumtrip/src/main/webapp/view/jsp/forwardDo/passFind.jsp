<%@page import="cumtrip.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

List<MemberVO> id = (List<MemberVO>)request.getAttribute("passFind");
String mail = null;

for(MemberVO vo : id){
	mail = vo.getMem_email();
}

if(id.size() == 0){
	//사용가능
%>

	{
		"flag" : "존재하지 않는 회원이거나 입력값이 일치하지 않습니다.",
		"status" : "0"
	}


	<% } else{ %>

	{
		"flag" : "존재하는 회원입니다.",
		"sendMail" : "<%= mail %>",
		"status" : "1"
	}

<%  } %>