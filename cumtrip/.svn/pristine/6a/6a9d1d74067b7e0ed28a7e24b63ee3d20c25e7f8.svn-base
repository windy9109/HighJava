<%@page import="cumtrip.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
List<MemberVO> list = (List<MemberVO>)request.getAttribute("res1");

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
		
		"cart_no"     : "<%= vo.getCart_no() %>",
		"stay_name"   : "<%= vo.getStay_name() %>",
		"room_grade"  : "<%=  vo.getRoom_grade() %>",
		"pay_date"    : "<%=  vo.getPay_date() %>",
		"cart_in"     : "<%=  vo.getCart_in() %>",
		"cart_out"     : "<%=  vo.getCart_out() %>",
		"pway_name"   : "<%=  vo.getPway_name() %>",
		"refund_date" : "<%=  vo.getRefund_date() %>",
		"cart_check"  : "<%=  vo.getCart_check() %>",
		"pay_status"  : "<%=  vo.getPay_status() %>",
		"term" : "<%= vo.getTerm() %>",
		"refund_no" : "<%= vo.getRefund_no() %>",
		"refund_date" : "<%= vo.getRefund_date() %>"
		
	}

<%  
} 
%>
] 

<% } %>