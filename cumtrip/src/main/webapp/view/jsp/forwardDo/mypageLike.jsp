<%@page import="cumtrip.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

List<MemberVO> list = (List<MemberVO>)request.getAttribute("mypagelike");

if(list.size() == 0){
%>
{
	"status" : "0"
}

<% 
}else{
%>
[
<% 
		for(int i=0; i<list.size(); i++){
		MemberVO vo = list.get(i);
		if(i>0){ out.print(","); } 
			
%>
			

	{
		"mem_email" : "<%= vo.getMem_email() %>", 
		"Mre_title" : "<%= vo.getMre_title() %>", 
		"Mre_date" : "<%= vo.getMre_date() %>", 
		"Mr_like" : "<%= vo.getMr_like() %>",
		"mid_name" : "<%= vo.getMid_name() %>",
		"Mre_no" : "<%= vo.getMre_no() %>",
		"mid_no" : "<%= vo.getMid_no() %>"
	}

<%  
} 
%>
] 

<% } %>