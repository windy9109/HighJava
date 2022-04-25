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
<script src="<%= request.getContextPath() %>/view/js/mypage/mypage_taste.js"></script> 

<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script  src="<%=request.getContextPath()%>/view/js/typeahead.bundle.js"></script>

<!-- 로딩중 -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/css/fakeLoader.css">
<script src="<%= request.getContextPath() %>/view/js/fakeLoader.js"></script>
<style>
.modal-dialog{
    max-width: 800px;
    width: 800px;
}
</style>
</head>
<body>

<header id="header"><!-- 상단 헤더 불러오기 --></header>
<div class="mypage_wrap_topHead">
	<div class="mypage_wrap_tBox f1" style="font-size: 2.0em;">
		마이페이지 > 여행취향
	</div>
</div>
<div class="mypage_wrap">
	<div class="mypage__wrapSub">
		<div class="mypage__wrap_topBox">
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_index.jsp" class="f4">고객정보</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_like.jsp" class="f4">좋아요</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_trip.jsp" style="background: #111; color:#fff;" class="f4">여행취향</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_pay.jsp" class="f4">결제내역확인</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_review.jsp" class="f4">작성리뷰조회</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_qna.jsp" class="f4">1:1문의</a></span>
		</div>
		<div class="mypage_boxContain">
			 <h3 class="mypage_Trip_h3 f1">여행취향 정보수정</h3>
			     <div class="modal-dialog">
				      <div class="modal-content">
				      
				        <!-- Modal Header -->
				        <div class="modal-header">
				          <h4 class="modal-title">취향을 선택해 주세요.</h4>
				        </div>
				        
				        <!-- Modal body -->
				        <form action = "<%=request.getContextPath()%>/MainMattractionInsert2.do" id="attrsubmit">
				        <div class="modal-body">
							<ul style="list-style: none;">
								<li><input type="checkbox" name="attr" id="a2" value="1" /> <label
								for="a2"><span>힐링</span></label></li>
				
								<li><input type="checkbox" name="attr" id="a3" value="2" /> <label
								for="a3"><span>연인</span></label></li>
				
								<li><input type="checkbox" name="attr" id="a4" value="3"/> <label
								for="a4"><span>개인</span></label></li>
								
								<li><input type="checkbox"  name="attr"id="a5" value="4"/> <label
								for="a5"><span>공원</span></label></li>
								
								<li><input type="checkbox" name="attr" id="a6" value="5" /> <label
								for="a6"><span>관광</span></label></li>
								
								<li><input type="checkbox"  name="attr" id="a7" value="6"/> <label
								for="a7"><span>플렉스</span></label></li>
								
								<li><input type="checkbox" name="attr" id="a8" value="7" /> <label
								for="a8"><span>레저</span></label></li>
							</ul>
							<div class="modal-footer" style="place-content: center;">
					          <input type="submit" class="btn btn-primary" id="check" value="확인">
					          <input type="reset" class="btn btn-danger" data-dismiss="modal" value="취소">
					        </div>
						</div>
				        </form>
				        <!-- Modal footer -->

				        
				        </div>
				      </div>
		</div>
	</div>
</div>
<footer id="footer"><!-- 하단불러오기 --></footer>

<!-- 로딩 -->
 <div class="fakeLoader"></div>
 <script src="<%= request.getContextPath() %>/view/js/fakeLoader_speed.js"></script>
 
</body>
</html>