<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/main.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="../js/main.js"></script> 
<script src="../../admin/js/typeahead.bundle.js"></script>
  
<script>  
 $(document).ready(function(){
    // Defining the local dataset
    var citys = ['서울특별시', '서울특별시 종로구', '서울특별시 중구', '서울특별시 용산구', '서울특별시 성동구', '서울특별시 광진구', '서울특별시 동대문구', '서울특별시 중랑구', '서울특별시 성북구', '서울특별시 강북구'
    	,'서울특별시 도봉구','서울특별시 노원구','서울특별시 은평구','서울특별시 서대문구','서울특별시 마포구','서울특별시 양천구','서울특별시 강서구','서울특별시 구로구','서울특별시 금천구','서울특별시 영등포구','서울특별시 동작구','서울특별시 관악구','서울특별시 서초구'
    	,'서울특별시 강남구','서울특별시 송파구','서울특별시 강동구','부산광역시 중구','부산광역시 서구','부산광역시 동구','부산광역시 영도구','부산광역시 부산진구','대구광역시 중구','대구광역시 동구','대구광역시 서구','대구광역시 남구'
    	,'대구광역시 북구','인천광역시 중구','인천광역시 동구','인천광역시 미추홀구','인천광역시 연수구','인천광역시 남동구','광주광역시 동구','광주광역시 서구','광주광역시 남구','광주광역시 북구','광주광역시 광산구'
    	,'대전광역시 동구','대전광역시 중구','대전광역시 서구','대전광역시 유성구','대전광역시 대덕구','울산광역시 중구','울산광역시 남구','울산광역시 동구','울산광역시 북구','울산광역시 울주군','세종특별자치시'
    	,'수원시','고양시','용인시','성남시','부천시','안산시','화성시','남양주시','안양시','평택시','의정부시','파주시','시흥시','김포시','광명시','광주시','군포시','이천시','오산시','하남시'
    	,'양주시','구리시','안성시','포천시','의왕시','여주시','양평군','동두천시','과천시','가평군','연천군',''];
    
    // Constructing the suggestion engine
     var citys = new Bloodhound({
        datumTokenizer: Bloodhound.tokenizers.whitespace,
        queryTokenizer: Bloodhound.tokenizers.whitespace,
        local: citys
       
    });
    
    
    // Initializing the typeahead
     $('.typeahead').typeahead(null, {
         name: 'countries',
         limit: 100,    // 입력하면 아래에 나오는 예시 갯수 
         minLength: 1, // 검색창의 자동완성 기능 글자 나오는 설정 (숫자가 올라갈수록 숫자만큼 글자를 입력해야 미리보기가 나옴)
         source: citys
         
     });
    	
   

    
});  
</script> 
  
  
    
<style>


.bs-example {
	font-family: sans-serif;
	position: relative;
	margin: 100px;
}
.typeahead, .tt-query, .tt-hint {
	box-shadow: 2px 3px 5px 0px;  	
	outline: medium none;	
}

.typeahead:focus {
	border: 2px solid #0097CF;
}

.tt-hint {/* 입력창에 나오는 예시 검색어 색상변경 가능 */
	color: #999999; 
    margin-left: 2px;
    margin-top: 2px;
}
.tt-menu { /* 입력하면 아래 지역별 입력창 폼  */
	background-color: #FFFFFF;
	border: 1px solid rgba(0, 0, 0, 0.2);
	border-radius: 8px;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
	margin-top: 12px;
	padding: 8px 0;
	width: 422px;
	overflow: scroll;
    max-height: 400px;
}
.tt-suggestion { /* 자동완성 창  */
	font-size: 20px;  
    padding: 3px 20px;
    font-weight: bold;
    text-align: left;
    border-bottom: 1px solid #dae0e5;
}
.tt-suggestion:hover {  /* 자동완성 창 마우스 올리면 효과 */
	cursor: pointer;
	background-color: #E0E0E0;
	
}


.twitter-typeahead{ /*검색 창 부모 (검색 창 크기 조절은 여기서)   */
    width: 60%; /*.mainsch width에 영향줌 */
}
.mainsch{ /*검색 창 자식  */ 
	border-style: none;
    border-radius: 80px;
     width: 100%; 
    line-height: 50px;  /*.icon에 margin-top 영향줌 */
    padding-left: 40px;
 	padding-right: 17px;
}

.icon {/* 검색창 안의 돋보기 모양   */
    background-image: url(../images/돋보기.png);
    width: 20px;
    height: 20px;
    position: absolute;
    background-size: 100% 100%;
    margin-left: 15px;
    margin-top: 15px;  
    z-index: 1;
}    

</style>  
  
  <script type="text/javascript">
  	$(function){
  		ajax.({
  			url : "/cumtrip/detailplace.do",
  			type :'get',
  			success : function(res){
  				
  			},
  			error: function(xhr){
  				
  			},
  			dataType: 'json'
  		  			
  		})
  		
  		
  	}
  
  </script>
</head>
<body>

<header id="header"><!-- 상단 헤더 불러오기 -->
	  <article style="margin: 5px 18%;">
	   <div class="box" style="display:table; width: 100%;">
	    <div class="backgroundimg">
	     <span class="icon"></span>
		  <input type="search" autocomplete="off" spellcheck="false"  class="mainsch typeahead tt-query" 
		  placeholder="어디로 가시나요?" >
		</div>
	   </div>
	  </article>
</header>

<div id ="name">
<p>유성온천 야외 족욕체험장</p>
<a href="">웹사이트 접속</a>
 </div>
	<div id = "intro">

	</div>
	
	<div id = "photo">
	
	
	</div>



<footer id="footer"><!-- 하단불러오기 --></footer>
		<!-- Copyright(c)2021 Hong -->

</body>
</html>