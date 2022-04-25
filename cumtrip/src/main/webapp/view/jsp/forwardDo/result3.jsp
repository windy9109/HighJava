<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <% 
    
    Object res = (Object)request.getAttribute("res1");
    //String input = (String)request.getAttribute("res2");
    //if(res.equals(input))
    
    if(res == null){
	%>
    
    {
    	"sou" : "0"
    	
    }
    	
   	<% }else{ %>
    
    {
    	"sou" : "1"
    }
    
    	
    <% }
    
    
    %>