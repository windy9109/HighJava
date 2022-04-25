<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYPAGE</title>
<link rel="shortcut icon" type="image/x-icon" href="../../images/titleLogo.png">
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/css/main.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<%= request.getContextPath() %>/view/js/main.js"></script> 
<script src="<%= request.getContextPath() %>/view/js/mypage/QNA_board.js"></script>
<script src="<%= request.getContextPath() %>/view/js/mypage/mypage_qna.js"></script>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script  src="<%=request.getContextPath()%>/view/js/typeahead.bundle.js"></script>


<style>
.collapse:not(.show){
display: block !important;
}

p{
	padding: 5px;
	margin: 5px;
	
}
.p1{
	width: 70%;
	float: left;
	
}
.p2{
	width: 25%;
	float: right;
	text-align: right;
}
hr{
clear: both;
}

input[name=ready]{
height: 55px;
vertical-align: top;
}

.container{
    margin-top: 0;
    padding-top: 0;
    padding-bottom: 0px;
}
.hgf21{
    margin-top: 50px;
}

h1{
margin-left: 50px; 
}

.navbar{
margin: 5px 25px;
}
.pagelist{
margin-left: 20%;
height: 50px;
}
.pagination{
	float: left;
	width: 100px;
	
}
#pagelist{
margin: auto;
    display: table;
    padding-top: 40px;
}
.rcode{
    background: #fff5d9;
	margin: 2px;
	padding: 3px;

}

#modifyform{
display: none;
}

#write{
    background-color: #FF9614;
    border-color: white;
    border-radius: 10px;
    font-family: 'twayair', sans-serif;
    color: white;
    line-height: 30px;
    text-align: center;
    padding: 15px;
    width: initial;
}
</style>




<!-- 로딩중 -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/css/fakeLoader.css">
<script src="<%= request.getContextPath() %>/view/js/fakeLoader.js"></script>
</head>
<body>

<header id="header"><!-- 상단 헤더 불러오기 --></header>
<div class="mypage_wrap_topHead">
	<div class="mypage_wrap_tBox f1" style="font-size: 2.0em;">
		마이페이지 > 1:1문의
	</div>
</div>
<div class="mypage_wrap">
	<div class="mypage__wrapSub">
		<div class="mypage__wrap_topBox">
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_index.jsp">고객정보</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_like.jsp">좋아요</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_trip.jsp">여행취향</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_pay.jsp">결제내역확인</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_review.jsp">작성리뷰조회</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_qna.jsp" style="background: #111; color:#fff;">1:1문의</a></span>
		</div>
		<div class="mypage_boxContain">
		
						<h1 class="f1 hgf21">1:1문의</h1>
					
						<br><br>
					   	<!-- list 출력 -->
						<div class="container">
						</div>
						
				<a href="./mypage_qna_Insert.jsp" id="write">글쓰기</a>
				
					<div id="pagelist"></div>
				<!-- 게시판시작 -->
					<div id ="modifyform">
							<textarea rows="3" cols="30"></textarea>
							<input type="button" value="확인" id="btonk" style="line-height: 30px;"></div>
							
					
						
						</div>
					
					<br><br>
				
					
					
					
					<!-- The Modal -->
					<div class="modal" id="modiModal">
					  <div class="modal-dialog">
					    <div class="modal-content">
					
					      <!-- Modal Header -->
					      <div class="modal-header">
					        <h4 class="modal-title f1" style="color:white !important;">문의글 수정</h4>
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
					      </div>
					
					      <!-- Modal body -->
					      <div class="modal-body">
					        <form id="modiForm">
					        	<label class="f4">작성자</label>
					        	<input type="text" name="writer" id="writer"><br>
					        	<label class="f1">제목</label>
					        	<input type="text" name="subject" id="subject"><br>
					        	<label class="f1">내용</label><br>
					        	<textarea name="content" id="content" rows="10" cols="50"></textarea>
					        	<input type="hidden" name="num" id="num">
					        </form>
					       </div>
					
					      <!-- Modal footer -->
					      <div class="modal-footer">
					      	<input type="button" value="입력" id="inputsubmit" class="btn btn-success" style="background-color: #FF9614; border-color: white; width: 120px;"> 
		    				<button type="button" class="btn btn-danger" data-dismiss="modal" style="background-color: #FF9614; border-color: white; border-radius: 10px; width: 120px;">Close</button>  
		    
					      </div>
					
					    </div>
					  </div>
					</div>
				
				<!-- 게시판 마침 -->
				
				
		</div>
	</div>
</div>

<footer id="footer"><!-- 하단불러오기 --></footer>

<!-- 로딩 -->
 <div class="fakeLoader"></div>
 <script src="<%= request.getContextPath() %>/view/js/fakeLoader_speed.js"></script>
 
</body>
</html>