$(function(){
	
		$.ajax({
		url: '/cumtrip/Mypage_Pay.do',
		type: 'post',
		success: function(res){
			
				str = "";
				if(res.status == "0"){
					str += '<h5>데이터가 없습니다</h5>';
					$('.mypage_payBox_span').html(str);
				}else{
					$.each(res, function(i, v){
					
						
						//현재날짜구하기
						let today = new Date();
						// 년도 getFullYear()
						let year = today.getFullYear(); 
						// 월 getMonth() (0~11로 1월이 0으로 표현되기 때문에 + 1을 해주어야 원하는 월을 구할 수 있다.)
						let month = today.getMonth() + 1
						// 일 getDate()
						let date = today.getDate(); 
						today0 = year + '-' + month + '-' + date;




						if(v.pay_date != "null"){ pay_date = v.pay_date }else{ pay_date = "-" }
						if(v.pway_name != "null"){ pway_name = v.pway_name }else{ pway_name = "-" }
						if(v.pay_status == "null"){ pay_status = '결제전<br><a href="#" class="mypage_PayBottom" sytle="color:white !important;">결제하기</a>' }
						else if(v.pay_status == "y" || v.pay_status == "Y"){ pay_status = "결제완료" }
						if(v.cart_check == "n" || v.cart_check == "N"){ cart_check = '-' }
						else if(v.cart_check == "f" || v.cart_check == "F"){ cart_check = '취소완료' }
						else if(v.cart_check == "y" || v.cart_check == "Y" && v.term > 7){ cart_check = '<a href="#" class="mypage_PayBottom mypage_PayBottom_cancel" sytle="color:white !important;">결제취소</a>'} 
						else if( v.cart_check == "y" || v.cart_check == "Y" && v.term < 7){ cart_check = '결제취소불가' }
						if(v.refund_date == "null"){ refund = "-" }else{ refund = "환불예정일: "+v.refund_date }
						
						str += '<li class="mypage_boxPay_li">';
						str += '	<div class="m_Pay_no f4">'+v.cart_no+'</div>';
						str += '	<div class="m_Pay_stay_name f4">'+v.stay_name+'('+v.room_grade+')</div>';
						str += '	<div class="m_Pay_date f4">'+pay_date+'</div>';
						str += '	<div class="m_Pay_cart_in f4">'+v.cart_in+'~'+v.cart_out+'</div>';
						str += '	<div class="m_Pay_pway_name f4">'+pway_name+'</div>';
						str += '	<div class="m_Pay_status f4">'+pay_status+'</div>';
						str += '	<div class="m_Pay_2 f4">';
						str += cart_check;
						str += '	</div>';
						str += '	<div class="m_Pay_3 f4">'+refund+'</div>';
						str += '</li>';
		                                                                                 
				
					}) 
				}	                                                                      
	
				$('.mypage_payBox_span').html(str);	
			
		},
		error: function(xhr){
/*			if(xhr.status == 500){ 
				alert("로그인 상태가 아닙니다.");
				location.href = "../index.jsp" 
				
				}*/
		},
		dataType: 'json'
	})
	
	
	
	
		$('.mypage_payBox_span').on('click', '.mypage_PayBottom_cancel', function(){
		
	/*		CART_CHECK = f
			REFUND_NO = 번호주기
			REFUND_DATE = 7일후 찍기*/
			cart_no0 = $(this).parents('.mypage_boxPay_li').find('.m_Pay_no').text();
			
			$.ajax({
			url: '/cumtrip/mypage_payUdate.do',
			data: { "cart_no0" : cart_no0 },
			type: 'post',
			success: function(res){                                                                      
				
			},
			error: function(xhr){
				if(xhr.status == 500){ 
					alert("로그인 상태가 아닙니다.");
					location.href = "../index.jsp" 
					
					}
			},
			dataType: 'json'
		})
		
		
		
		$.ajax({
			url: '/cumtrip/mypage_payUdate.do',
			data: { "cart_no0" : cart_no0 },
			type: 'get',
			success: function(res){

				alert("결제취소성공");
				location.href = "mypage_pay.jsp";
				                                                                      
				
			},
			error: function(xhr){
				if(xhr.status == 500){ 
					alert("로그인 상태가 아닙니다.");
					location.href = "../index.jsp" 
					
					}
			},
			dataType: 'json'
		})
		
	
	
	

	})
	

	
	
})