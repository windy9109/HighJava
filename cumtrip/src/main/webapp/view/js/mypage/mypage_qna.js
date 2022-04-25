currentPage = 1;
reply = { }; //객체 생성, 
board = { };

$(function() {
	typevalue="";
	wordvalue="";
	listServer();
	
	//search 검색 이벤트
	$('#search').on('click', function() {
		typevalue = $('#stype option:selected').val().trim();
		wordvalue = $('#sword').val().trim();
		
		currentPage = 1;
		listServer();
		
	})
	
	//listServer();
	
	
	//page번호 클릭하는이벤트
	$('#pagelist').on('click', '.pnum', function() {
		currentPage = $(this).text();
		listServer();
	}) 
	
	//이전버튼 클릭하는이벤트
	$('#pagelist').on('click', ".prev", function() {
		currentPage = parseInt($('.pager a').first().text())-1;
		//alert(currentPage);
		listServer();
	})
	
	
	//다음버튼 클릭하는이벤트
	$('#pagelist').on('click', ".next", function() {
		currentPage = parseInt($('.pager a').last().text())+1;
		//alert(currentPage);
		listServer();
	})
	
	//수정,삭제,등록버튼 이벤트
	//댓글삭제, 댓글수정
	
	$('.container').on('click','.action', function() {
		actionName = $(this).attr('name');
		actionIdx = $(this).attr('idx');
		
		if(actionName == "modify"){
			//수정창 띄우기 - 수정할 내용(원래내용)들을 출력
			bcard = $(this).parents('.card');
			subject = $(bcard).find('h5').text();
			writer = $(bcard).find('.bwr').text();
			cont = $(bcard).find('.p3').html();
			cont = cont.replace(/<br>/g, "\n");
			
			$('#modiModal #writer').val(writer);
			$('#modiModal #subject').val(subject);
			$('#modiModal #mail').val(mail);
			$('#modiModal #content').val(cont);
			$('#modiModal #num').val(actionIdx);
			
			$('#modiModal #writer').prop('disabled', true);
			
			
		}else if(actionName == "delete"){

			
			boardDelete();
			
		}else if(actionName == "reply"){
			alert(actionIdx+"번글에 댓글을 답니다.");
			
			//입력한 내용- cont
			//글번호 - qa_no
			//이름 - name
			//객체로 저장 - reply = {}
			//객체에 동적으로 속성들을 추가
			//reply.cont = "";
			//reply.name="";
			//reply.qa_no = actionIdx
			
			
			cont = $(this).prev().val();
			name = String.fromCharCode(Math.random()*26+65);
			name += String.fromCharCode(Math.random()*26+97);
			name += parseInt(Math.random()*100+1);
			
			reply.cont = cont;
			reply.name = name;
			reply.qa_no = actionIdx;
			
			replyInsert(this);
			$(this).prev().val("");
			
			
		}else if(actionName == "title"){
			
			//댓글 리스트 출력
			replyList(this);
		
			//조회수 증가
			//vclass = $(this).parents('.card').find('.show').attr('calss');
			
			//alert(vclass);
			if(typeof vclass == "undefined"){
				//readHit(this);
			}
			
			
		}else if(actionName == "r_delete"){
			replyDelete(this);
		}else if(actionName == "r_modify"){
			//댓글 수정폼의 css속성값을 가져온다.
			if($('#modifyform').css('display') != "none"){
				//다른곳에 수정폼이 이미 열려있다.
				//수정폼을 body로 다시 append
				//원래 내용을 원래위치로 환원
				
				replyReset();
				
			}
			
			
			// 원래내용(수정할 내용) 가져오기 - <br>포함
			p3cont = $(this).parents('.rcode').find('.p3').html();
			
			// \n으로 변경
			p3temp = p3cont.replace(/<br>/g,"\n");
			
			$('#modifyform textarea').val(p3temp);
			
			$(this).parents('.rcode').find('.p3').empty().append($('#modifyform'));
			
			$('#modifyform').show();
			
			
		}
		
		
	})
	
	
	function replyReset(){
		//p3찾기
		vp3 = $('#modifyform').parent();
		
		//수정폼을 body로 이동, 감추기
		$('body').append($('#modifyform'));
		$('#modifyform').hide();
		
		//원래데이터 환원
		$(vp3).html(p3cont)
		
	}
	
	//댓글 수정창에서 취소버튼 클릭 이벤트
	$('#btnreset').on('click', function() {
		replyReset();
	})
	
	
	$('#btonk').on('click', function() {
		//수정입력 내용 가져오기 = \r\n이 포함되어 있다.
		modiCont = $('#modifyform textarea').val();
		
		//환원할 위치 = p3
		vp3 = $('#modifyform').parent();
		
		//수정폼을 body로 이동, 감추기
		$('body').append($('#modifyform'));
		$('#modifyform').hide();
		
		//modiCont 내용을 <br>태그로 바꿔서 p3위치에 표시
		modishow = modiCont.replace(/\r/g,"").replace(/\n/g,"<br>");
		
		//vp3.html(modishow);
		
		//DB에서 수정
		reply.renum = actionIdx;
		reply.cont = modiCont;
		replyUpdate();
		
		
	})
	
	
	//글수정 모달창에서 내용을 수정 후에 전송 버튼 클릭
	$('#modisend').on('click', function() {
		
		//수정내용을 가져온다.
		alert(actionIdx+"번 글을 수정하러 갑니다.");
		wr = $('#modiModal #writer').val();
		sub = $('#modiModal #subject').val();
		mail = $('#modiModal #mail').val();
		cont = $('#modiModal #content').val();
		
		//객체에 저장
		board.writer = wr;
		board.subject = sub;
		board.mail = mail;
		board.content = cont;
		board.num = actionIdx;
		
		//서버로보내기
		boardUpdate();
		
		//-----------db에서 수정 성공하면 나중에 할일 ------------
		//ajax의 success 부분에서 코딩할일 ---------------------
		//입력한 내용을 card본문으로 다시 출력한다.
		
		cont = cont.replace(/\r/g,"").replace(/\n/g, "<br>");
		
		$(bcard).find('a').text(sub);
		$(bcard).find('.bwr').text(wr);
		$(bcard).find('.bma').text(mail);
		$(bcard).find('.p3').text(cont);
		
		//창닫기
		$('#modiModal').modal('hide');
		

		
		
	})
	
	
})