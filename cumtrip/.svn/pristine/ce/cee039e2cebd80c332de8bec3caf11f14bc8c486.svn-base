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
        <title>qna</title>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
         <link href="css/styles.css" rel="stylesheet" />
        <script href="js/jquery.serializejson.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
       
       
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    	  
   <script type="text/javascript">
   $(function(){
	   $.ajax({
		   url: '/cumtrip/qselectall.do', 
		   type : 'get',
		   async:false,
		   success : function(res){
			   str ="";
			  
                $.each(res, function(i, v){
                	
            str += '<tr>';
            str +=    '<td class="qno">'+v.qa_no+'</td>';
            str +=     '<td>'+v.qa_title+ '</td>';
            str +=     '<td class="email">'+v.mem_email+ '</td>';
            str +=     '<td>'+v.qa_date+ '</td>';
            str +=     '<td><input type="button" class="detail" value="세부 조회 및 답변"></td>';
            str +=   '</tr>';
           
			  	})
            
                $('#table').html(str);
		   },
		   error: function(xhr){
			   
		   },
		   dataType: 'json'
	   })
	   
	  
   })
   	
	$(document).on('click','.detail', function(){
		qno = $(this).parents('tr').find('.qno').text();
		$.ajax({
			url: '/cumtrip/selectoneq.do',
			type: 'get',
			data : {"qno" : qno},
			success : function(res){
				
			 str = '<div class="modal" id="myModal">';
			 str+= '<div class="modal-dialog"><div class="modal-content"><div class="modal-header">';
		     str+=     '<h4 class="modal-title">1:1문의 세부조회</h4>'                                              ;
		     str+=     '<button type="button" class="close" data-dismiss="modal">&times;</button>'               ;
		     str+=   '</div>'                                                                                    ;
		     str+=   '<div class="modal-body">'                                                                  ;
		     
		     str+= '<form action ="/cumtrip/uploadquestion.do" id="upload">'                                                                                     ;
		     str+= '<table>'                                                                                     ;
		     str+= 	'<tr>'                                                                                       ;
		     str+= 		'<td>작성자 : '+res.mem_email+ '</td>'  ;
		     str+= 	'</tr>'                                                                                     ;
		     str+= 	'<tr>'                                                                                       ;
		     str+= 		'<td>제목 : '+res.qa_title+'</td>' 
		     str+= 	'</tr>' ;
		     str+= 	'<tr>'                                                                                       ;
		     str+= 		'<td>작성일 : '+res.qa_date+'<input type="hidden" name="qno" value="'+qno+'"></td>'                                                                          ;
		     str+= 	'</tr>'                                                                                      ;
		     str+= 	'<tr>'                                                                                       ;
		     str+= 		'<td><h4>문의 내용</h4></td>'                                                                      ;
		     str+= 	'</tr>'                                                                                      ;
		     str+= 	'</tr>'                                                                                      ;
		     str+= 	'<tr>'                                                                                       ;
		     str+= 		'<td><textarea cols="50" rows="7"   readonly name="answer" >'+res.qa_content+'</textarea></td>'                                                                      ;
		     str+= 	'</tr>';
		     str+= 	'</tr>'                                                                                      ;
		     str+= 	'<tr>'                                                                                       ;
		     str+= 		'<td><h3>관리자 답변<h3></td>'                                                                      ;
		     str+= 	'</tr>';
		     str+= 	'</tr>'                                                                                      ;
		     str+= 	'<tr>'                                                                                       ;
		     str+= 		'<td><textarea cols="50" rows="7" placeholder="친절하게 답변해주세요."></textarea></td>'                                                                      ;
		     str+= 	'</tr>';
		     str+= '</table>';
		     str +="</form>";
		     str+=   '</div>'                                                                                    ;
		     str+=   '<div class="modal-footer">';
		     str+=     '<button type="button" class="btn btn-success" id="submit">답변 등록</button>'        ;
		     str+=     '<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>'        ;
		     str+=   '</div>    </div> </div>  </div>'                                                           ;
		  $('#display').html(str);
		  $('#myModal').show();
			},
			error: function(xhr){
				alert(xhr.status);
			},
			dataType: 'json'
		})
	$(document).on('click', '#submit',function(){
		$('#upload').submit();
		
	})	
		
	$(document).on('click', '.btn-danger', function(){
		  $('#myModal').hide();
	})
	$(document).on('click', '.close', function(){
		  $('#myModal').hide();
	})
	$(document).on('click', '#mod',function(){
		$('#modify').submit();
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
                        <h1 class="mt-4">회원</h1>
                        <ol class="breadcrumb mb-4">
                        </ol>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                1:1문의사항
                            </div>
                      
                      <div class="card-body">
                      
                      	   <table id="datatablesSimple">
                      	   	<thead>
                      	   		<tr>
                      	   		 	<th>문의 번호</th>
                      	   		 	<th>문의 제목</th>
                      	   		 	<th>작성자</th>                      	   		
                      	   		 	<th>문의 날짜</th>
                      	   		 	<th>세부조회</th>                      	   		
                      	   		</tr>
                      	   	</thead>
                      	   	<tfoot>
                      	   		<tr>
                      	   		 	<th>문의 번호</th>
                      	   		 	<th>문의 제목</th>
                      	   		 	<th>작성자</th>                      	   		
                      	   		 	<th>문의 날짜</th>
                      	   		 	<th>세부조회</th>                      	   		
                      	   		</tr>
                      	   	</tfoot>
                      	   	<tbody id='table'>
                      	   	</tbody>
                      	   </table>
                      </div>
                      </div>
                      </div>
                      <div id='display'></div>
                      </main>
                      </div></div>
                      
                  
 		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
       
        
</body>
</html>