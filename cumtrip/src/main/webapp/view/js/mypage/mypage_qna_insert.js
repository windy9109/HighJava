$(function() {
		
		
		
	
		$('#modisend').on('click', function() {
		subject = $('#modiForm0 #subject').val();
		content = $('#modiForm0 #content').val();
			$.ajax({
				url: '/cumtrip/MypageQnaInsert.do',
				data: { "subject" : subject,
					"content" : content },
				type: 'post',
				success: function(res){
						alert("글쓰기성공");
						location.href = "./mypage_qna.jsp";
				},
				error: function(xhr){
					alert(subject = $('#modiForm0 #subject').val());
					alert(content = $('#modiForm0 #content').val());
					alert("상태: "+xhr.status);
/*					if(xhr.status == 500){ 
						alert("로그인 상태가 아닙니다.");
						location.href = "../index.jsp" };*/
				},
				dataType: 'json'
			})
			
			
		})
	})