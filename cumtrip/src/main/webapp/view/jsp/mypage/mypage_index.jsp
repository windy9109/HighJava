<%@page import="cumtrip.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYPAGE</title>
<link rel="shortcut icon" type="image/x-icon" href="../../images/titleLogo.png">
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/css/main.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/css/font.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<%= request.getContextPath() %>/view/js/main.js"></script> 
<script src="<%= request.getContextPath() %>/view/js/mypage/mypage_index.js"></script> 

<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script  src="<%=request.getContextPath()%>/view/js/typeahead.bundle.js"></script>


<!-- 로딩중 -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/css/fakeLoader.css">
<script src="<%= request.getContextPath() %>/view/js/fakeLoader.js"></script>
<%MemberVO vo = (MemberVO) session.getAttribute("loginMember"); %>
<script type="text/javascript">

$(function(){
	$('#inputsubmit').on('click',function(){
		$('#input').submit();
		
	})
	
})
</script>

<body>
	<header id="header"><!-- 상단 헤더 불러오기 --></header>
	<div class="mypage_wrap_topHead">
		<div class="mypage_wrap_tBox f1" style="font-size: 2.0em;">
			마이페이지 > 정보조회
		</div>
	</div>
	<div class="mypage_wrap">
		<div class="mypage__wrapSub">
			<div class="mypage__wrap_topBox">
				<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_index.jsp" style="background: #111; color:#fff;">고객정보</a></span>
				<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_like.jsp" class="f4">좋아요</a></span>
				<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_trip.jsp" class="f4">여행취향</a></span>
				<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_pay.jsp" class="f4">결제내역확인</a></span>
				<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_review.jsp" class="f4">작성리뷰조회</a></span>
				<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_qna.jsp" class="f4">1:1문의</a></span>
			</div>
			<div class="mypage_boxContain">
				
			</div>
		</div>
	</div>
	<footer id="footer"><!-- 하단불러오기 --></footer>
	
	<div class="modal" id="myModal">
			<div class="modal-dialog"><div class="modal-content"><div class="modal-header">
		    <h4 class="modal-title">회원 사진 변경</h4>                                           
		    <button type="button" class="close" data-dismiss="modal">&times;</button>
		    </div>                                                                                   
		    <div class="modal-body">                                                                  
		  	<form id="input" action='/cumtrip/updatemphoto.do' method="post"  enctype="multipart/form-data" >
		    <table>                                                                          
		     <tr>                                                                                    
		     <td style="text-align: left"><label>현재 사진</label></td>                                                                   
		    </tr>  
		    <tr>
		     <td id="currentphoto" ><img src="/cumtrip/Mphoto.do?filename=<%=vo.getMem_photo()%>"></td>                       
		 	</tr>
		     <tr>                                                                                 
		     <td  style="text-align: left; font-weight: bold">변경사진<input type="file" name="file"> </td>                                                             
		     </tr>                                                                                                                                                                        
		    </table>
		 		     </form>   
		    </div>                                                                          
		     <div class="modal-footer">
<<<<<<< HEAD
		    <input type="button" value="입력" id="inputsubmit" class="btn btn-success" style="width: 50px; line-height: 30px; float: right"></div>';> 
		    <button type="button" class="btn btn-danger" data-dismiss="modal" style="width: 50px; line-height: 30px; float: right"></div>';>Close</button>  
=======
		    <input type="button" value="입력" id="inputsubmit" class="btn btn-success" style=" line-height: 30px; float: right">
		    <button type="button" class="btn btn-danger" data-dismiss="modal" style=" line-height: 30px; float: right">Close</button>
>>>>>>> c2f2a6fbe0cc12547d7201f74cd377ea94314f8e
		     
		   </div></div></div></div> 
		

<!-- 로딩 -->
 <div class="fakeLoader"></div>
 <script src="<%= request.getContextPath() %>/view/js/fakeLoader_speed.js"></script>
	
</body>
</html>