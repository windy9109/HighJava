<%@page import="cumtrip.vo.MemberVO"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html >
<html>
 <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>addstay</title>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
         <link href="css/styles.css" rel="stylesheet" />
        <script href="js/jquery.serializejson.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
<style type="text/css">
label{
	width: 50px;
	font-weight:  bold;
}
.rom{
	width : 200px;
	margin : 0px 30px;
}
</style>    	  
  	  
   <script type="text/javascript">

			$(function(){
				
				$.ajax({
					url: "/cumtrip/staymain.do",
					type: 'get',
					success : function(res){
						str = "";
						$.each(res, function(i,v){
						str += '<option value="'+v+'" >'+v+'</option>';
							})
						$('#codedetail').html(str);	
					},
					error: function(xhr){
						alert(xhr.status);
					},
					dataType: 'json'
				})
				
				$('#addroom').on('click',function(){
					
					res = "<div>"
					res += '<label>룸넘버</label><input type=text name="roomnum" class="rom">'
					res += '<label>등급</label><input type=text name="grade" class="rom">'
					res += '<label>가격</label><input type=text name="cost" class="rom">'
					res += "</div>"
					
					$('#room').append(res);
				})
				$('#deleteroom').on('click', function(){
					
					$('#room').children().last().remove();
					
				})
			})
   </script> 

   
    </head>
    <body class="sb-nav-fixed">
    
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.html">cumtrip admin</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
           
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
        
                          
                            <div class="sb-sidenav-menu-heading">MENU</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#member" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                회원관리
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="member" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="membertable.jsp">회원정보</a>
                                    <a class="nav-link" href="attraction.jsp">취향정보</a>
                                    <a class="nav-link" href="review.jsp">게시글</a>
                                    <a class="nav-link" href="qna.jsp">관리자 문의사항</a>
                                  
                                    
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#space" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                관광명소
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            
                            <div class="collapse" id="space" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="selectspace.jsp">관광명소 조회</a>
                                    <a class="nav-link" href="addspace.jsp">관광명소 추가</a>
                                </nav>
                            </div>
                            
                             <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#restaurant" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                음식점
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="restaurant" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="selectrestaurant.jsp">음식점 조회</a>
                                    <a class="nav-link" href="addrestaurant.jsp">음식점 추가</a>
                                </nav>
                            </div>
                             <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#stay" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                숙소
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="stay" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="selectstay.jsp">숙소 조회</a>
                                    <a class="nav-link" href="addstay.jsp">숙소 추가</a>
                                    <a class="nav-link" href="bookstay.jsp">숙소 예약 조회</a>
                                </nav>
                            </div>
                            
                             <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#recommend" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                추천여행코스
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="recommend" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="selectrecommend.jsp">추천여행코스 조회</a>
                                    <a class="nav-link" href="addrecommend.jsp">추천여행코스 추가</a>
                                </nav>
                            </div>
                        </div></div>
                </nav>
            </div>
            
             <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">숙소 추가</h1>
                        <ol class="breadcrumb mb-4">
                        </ol>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                입력창 
                            </div>
                            
                      <div class="card-body">
	                      	 <div class="table-responsive">
	                      	 <form action="<%=request.getContextPath()%>/insertstay.do" method = "post" enctype="multipart/form-data">
                        <table class="table">
                            <tbody>
                            <tr style="line-height:32px;">
                                <td>숙소 이름</td>
                                <td>
                                    <input type="text" name="name" id="name"  class="form-control">
                                </td>
                                <td>숙소 주소</td>
                                <td>
                                    <input type="text" name="location"  id="location" class="form-control">
                                </td>                        
                            </tr>
                            <tr>
                                <td>X좌표</td>
                                <td>
                                    <input type="text" name="xsite" id="xsite" class="form-control">
                                </td>
                                <td>Y좌표</td>
                                <td>
                                    <input type="text" name="ysite" id="ysite" class="form-control">
                                </td>
                            </tr>
                          
                            <tr>
        
                                <td>세부분류코드</td>
                                   <td> <select name ="codedetail" id="codedetail">
                                    	
                                    </select>
                                </td>
                               <td>사진 업로드</td>
                               <td><input type="file" name="file" id="file" multiple></td>
                            </tr>
                            <tr>
                            <td>숙소 설명</td>
                                <td>
                                  <textarea rows="10" cols="30" name ="content" id="content"></textarea>                                 
                                </td>
                             </tr>
                  
                             <tr><td><input type="button" value="룸추가" id="addroom" >
                             <input type="button" value="룸제거" id="deleteroom" >
                             </td></tr>
                            </tbody>
                        </table>
                        <div><h4>룸 정보 입력창</h4></div>
                        <div id='room'></div>
                        <div style ="text-align: right">
                        <input type="submit" value="등록하기" class="btn btn-success">
                        <input type="reset" value="취소" class="btn btn-danger">
                        </form>
                        </div>
                    </div>
                      </div>
                      </div>
                      </div>
                      <div id='display'></div>
                      </main></div></div>


 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
       
        
</body>
</html>