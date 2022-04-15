$(function(){
	
	
	
	
	//아이디찾기
	
	$('#find_id_form').on('submit',function(){
		
		find_name = $('#find_name').val().trim();
		find_tel = $('#find_tel').val().trim();
		
		if( find_name.length == 0 || find_tel.length == 0 ){
			if(find_name.length == 0 ){
				alert("이름을 입력해주세요");
			}
			if(find_tel.length == 0 ){
				alert("전화번호를 입력해주세요");
			}	
		}else{
			
				$.ajax({
				url : '/cumtrip/FindIDpass.do',
				data: { 
					"flag" : 1,
					"find_name": find_name,
					"find_tel" : find_tel
				 },
				type: 'get',
				success: function(res){
					if(res.status == 1){
						alert("아이디는 "+res.sendMail+"입니다");	
						location.href ="index.jsp";
					}
					if(res.status == 0){
						alert(res.flag);	
					}
					
				},
				error: function(vhr){
					alert("상태: "+vhr.status)
				},
				dataType: 'json'
				
			})
		
		}
		
		
		return false;
		
	})
	
	q_mail = null;
	
	//인증메일 보내기
	$('#find_mail_sendButton').on('click', function(){
		
		find_mail = $('#find_mail').val().trim();
		if( find_mail.length == 0 ){
			alert("메일을 입력해주세요.");
		}else{
			$.ajax({
				url: '/cumtrip/MailSend.do',
				data: { "mem_email": find_mail },
				type: 'post',
				success: function(res) {
					alert("인증메일을 성공적으로 보냈습니다.");
					q_mail = res.num;
					
				},
				error: function(vhr) {
					alert("상태: "+vhr.status)
				},
				dataType: 'json'	
			})
		}
		
		return false;
		
		
	})
	
	
	
	//비밀번호 찾기
	$('#find_pass_form').on('submit',function(){
		
		find_name = $('#find_name').val().trim();
		find_mail = $('#find_mail').val().trim(); 
		find_mail_sendText = $('#find_mail_sendText').val().trim();
		//비밀번호를 변경할 아이디
		setPassMail = find_mail;
		if(find_name.length == 0 || find_mail.length == 0 || find_mail_sendText.length == 0){
			if(find_name.length == 0){
				alert("이름을 입력해주세요");
			}
			if(find_mail.length == 0){
				alert("아이디 메일을 입력해주세요");
			}	
			if(find_mail_sendText.length == 0){
				alert("인증번호를 입력해주세요");
			}
		}else{
			$.ajax({
			url : '/cumtrip/FindIDpass.do',
			data: { 
				"flag" : 2,
				"find_name": find_name,
				"find_mail" : find_mail
			 },
			type: 'get',
			success: function(res){
				if(res.status == 1 && q_mail == find_mail_sendText ){
					alert("비밀번호 변경을 진행합니다.");
					setPassMail = res.sendMail;
					location.href ="findPassSet.jsp?mem_mail="+setPassMail;
					
				}
				if(res.status == 0 || q_mail != find_mail_sendText || q_mail == null){
					if(res.status == 0) { 
						alert(res.flag); 
					}
					if(q_mail != find_mail_sendText ){
						alert("인증번호가 일치하지 않습니다.");
					}
					if(q_mail == null){
						alert("인증메일을 보내주세요.");
					}
				}
				
			},
			error: function(vhr){
				alert("상태: "+vhr.status)
			},
			dataType: 'json'
			
		})
		
		}
		
		
		return false;
		
	})
	
/*	setPassMail = $('.passSet_NameSpan').text();
	
	$('#eo1').on('click', function(){
		alert("111"+setPassMail);
	})*/
	

	
	//비밀번호 변경
	$('#find_passSet_form').on('submit', function(){
		
		setPassMail = $('.passSet_NameSpan').text();
		set_passWord = $('#set_passWord').val();
			
		$.ajax({
			url : '/cumtrip/FindIDpass.do',
			data: { 
				"flag" : 3,
				"setPassMail": setPassMail,
				"set_passWord" : set_passWord
			 },
			type: 'get',
			success: function(res){
				alert(res.flag);
				location.href ="index.jsp";
			
			},
			error: function(vhr){
				alert("상태: "+vhr.status)
			},
			dataType: 'json'
			
		})
		return false;
		
	})
	
	

	
	
})





