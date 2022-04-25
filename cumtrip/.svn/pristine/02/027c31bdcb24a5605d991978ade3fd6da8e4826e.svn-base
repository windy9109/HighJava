$(function(){
	$.ajax({
		url: '/cumtrip/mypage_taste.do',
		type: 'post',
		success: function(res){
			
				str = "";
				attr_tag = null;
				attr_tag2 = null;
				$.each(res, function(i, v){
						
						 
						if(attr_tag != v.attr_tag){
							attr_tag = v.attr_tag	
							str += '<div class="m_Trip_no f4">';
							str += '<div class="erewo1">'+attr_tag+'</div>';
							str += '<div class="tit_fge1">추천 장소</div>';
							str += '</div>';
						}		
						str += '<div class="m_Trip_name f4">'+v.mid_name+'</div>';


				}) 
			
		        
					str += '<div class="mypage_boxTrip_bBoX">';
					str += '<a href="#" class="mypage_TripBottom f4" style="color: white !important;">여행취향 수정</a>';
					str += '</div>'; 
				
				   
		               
                                               
	
				$('.mypage_trip_taste').html(str);	
			
		},
		error: function(xhr){
/*			if(xhr.status == 500){ 
				alert("로그인 상태가 아닙니다.");
				location.href = "../index.jsp" 
				
				}*/
		},
		dataType: 'json'
	})
	
	$('.mypage_trip_taste').on('click','.mypage_TripBottom', function(){
		location.href="mypage_trip_update.jsp";
	})
	

	
})