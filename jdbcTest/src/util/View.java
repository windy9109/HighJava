package util;

public interface View {
	
	
	
	int MAIN = 0; //시작 화면
	int LOGIN = 1; // 로그인 화면
	int JOIN = 2; // 회원가입 화면

	int HOME = 3; // 홈(메인) 화면
	
	int MANAGER_LOGIN = 7; //전문가 로그인 
	int MANAGER_HOME = 8;  //전문가 홈
	
	int MANAGER_PRODUCT_BOARD = 9; //전문가용 제품 게시판
	int MANAGER_FREE_BOARD = 10;    //전문가용 자유 게시판
	
	int MANAGER_MEMBER = 11; //전문가용 회원 목록(활동정지)
	int MANAGER_STOP_INSERT = 12; //활동정지등록
	int MANAGER_STOP_DELETE = 13; //황동정지해제

	int MANAGER_ADMEMBER_INSERT = 20; //광고주 계정등록
	
	int MANAGER_QUESTIONS_LIST = 14; //전문자용 문의사항
	int MANAGER_QUESTIONS_ANSWER = 15; //문의사항 답변
	int NOTICE_INSERT = 1600; //전문가용 공지사항 등록 화면
	int NOTICE_UPDATE = 1601; //전문가용 공지사항 등록 화면
	int NOTICE_DELETE = 1602; //전문가용 공지사항 등록 화면
	
	
	int MANAGER_NOTICE_LIST = 1700; //전문가용 공지 리스트
	
	
	int MYPAGE_MAIN = 110; //마이페이지 메인
	int MYPAGE_QUESTIONS = 190; //1:1문의 페이지
	int QUESTIONS_SEND = 191; //문의 전송
	int QUESTIONS_RECIVE = 192;  //보낸 문의 리스트
	int QUESTIONS_VIEW = 193;   //문의내용 확인하기
	
	int AD_LOGIN = 99999;
	int ADVERTISEMENT_MAIN = 300;//광고주 메인
	int MYPAGE_CLIENT_MAIN = 301;//광고주 마이페이지
	int MYPAGE_ADVERTISEMENT = 302; //광고 내역 확인하기
	int ADVERTISEMENT_INSERT =303; //광고등록
	int ADVERTISEMENT_PROD_UPDATE = 304;//광고수정
	int ADVERTISEMENT_VIEW = 305;
	
	
	int CLIENT_INSERT= 306; //광고주 정보 입력 및 수정
	
	
	

	int PRODBOARD = 201; //상품 게시판 메인
	int PRODBOARD_READ = 202; //상품 게시판 조회
	int PRODBOARD_SERCH = 203; //상품 게시판 검색
	int PRODBOARD_CREATE = 204; //상품 게시판 검색
	
	int FREEBOARD = 251;
	int FREEBOARD_READ = 252;
	int FREEBOARD_SERCH = 253;
	int FREEBOARD_CREATE = 254;	
	
	int ADVERTISEMENTBOARD_READ = 255;
	
	int SEARCHED_MEMBER = 280;
	
	//int MANAGER_LOGIN = 3;
	//int MANAGER_HOME = 7;
	
	int NOTICEBOARD = 500;
	int NOTICE_LIST = 501;
	
	int MYPAGE_UPDATE = 111; //1.마이페이지 회원정보수정
	
	int MYPAGE_UPDATE_NICKNAME = 112; //1-1.닉네임수정
	int MYPAGE_UPDATE_PASS = 113; //1-2.패스워드
	int MYPAGE_UPDATE_ADDR = 114; //1-3.주소
	int MYPAGE_UPDATE_TELL = 115; //1-4.전화
	int MYPAGE_UPDATEMENU = 124; //비밀번호확인 페이지

	int MYPAGE_CART = 116; //2.마이페이지 판매내역
	int MYPAGE_INTITEMS = 117; //3.관심상품모아보기
	int MYPAGE_REVIEW = 118;	//4.리뷰평점
	
	int MYPAGE_BLOCK = 119;//5.차단목록
	int MYPAGE_UNBLOCK_CHECK = 120; //5-5.차단목록상세페이지
	int DOBLOCK = 127; //차단하기
	int FREE_DOBLOCK =128; //자유게시판차단
	
	int MYPAGE_MESSAGE_SEND = 121; //제품게시판에서 메세지 보내기
	int MYPAGE_MESSAGE_LIST = 125; //6.메세지함 목록
	
	int MYPAGE_CHATTING = 122; //6-1.채팅방
	int MYPAGE_CATTING_SEND =126; //채팅보내기
	
	//int MYPAGE_QUESTIONS = 123;//7.1:1문의
	
	
	
	int REVIEW_WRITE = 123456;

}





