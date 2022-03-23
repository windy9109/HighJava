package board.controller;

import java.util.List;
import java.util.Scanner;

import board.service.BoardService;
import board.service.BoardServiceImpl;
import board.vo.BoardVo;

public class BoardController {
	
	
	private Scanner scan = new Scanner(System.in);
	//service의 객체데이터를 불러옴
	private BoardService service;
	
	//생성자
	private BoardController(){
		//service 객체 생성(싱글톤 패턴)
		service = BoardServiceImpl.getInstance();
	}
	
	public int displayMenu() {
		System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
		int sc = scan.nextInt();
		
		return sc;
	} 
	
	
	
	
	public int choice() {
		System.out.println("1.수정  2.삭제  0.뒤로가기");
		int sc = scan.nextInt();
		
		return sc;
	} 
	
	
	public int choice2( int boardNo ) {
		while(true) {
			int chice = choice();
			switch(chice) {
			case 1: updateBoard( boardNo );//수정
				break;
			case 2: deletBoard( boardNo );//삭제
				break;
			case 0: //작업끝
				System.out.println("작업끝...");
				System.exit(0);
				break;
			default: 
				System.out.println("번호를 잘못입력했습니다. 다시입력해주세요");
			}
		
		}
	} 
	
	
	
	public String serchChoice() {
		System.out.println("검색 작업\n"
				+ "--------------------------------------------\n"
				+ "- 검색할 제목 입력 :");
		scan.nextLine(); //입력버퍼비우기
		String sc = scan.nextLine();
		
		return sc;
	} 
	
	
	public int displayMenuDetail() {
		System.out.println("조회할 글번호를 입력해주세요");
		int sc = scan.nextInt();
		
		return sc;
	} 
	
	public int start(){
		
		while(true) {
			int chice = displayMenu();
			switch(chice) {
			case 1: insertBoard();//새글작성
				break;
			case 2: viewBoard();//게시글보기
				break;
			case 3: serch();//검색
				break;
			case 0: //작업끝
				System.out.println("작업끝...");
				System.exit(0);
				break;
			default: 
				System.out.println("번호를 잘못입력했습니다. 다시입력해주세요");
			}
		
		}
	}
	
	//새글작성
	public void insertBoard() {
		
		System.out.println();
		System.out.println("추가할 회원 정보 입력");
		
		
		System.out.println("제목 >>");
		String boardTitle = scan.next();
		
		System.out.println("작성자 >>");
		String boardId = scan.next();
		
		System.out.println("내용>>");
		String boardContain = scan.next();
		

		
		//입력한 데이터를 VO객체에 저장한다.
		BoardVo boardVo = new BoardVo();
		boardVo.setBorad_title(boardTitle);
		boardVo.setMem_id(boardId);
		boardVo.setContent(boardContain);
		
		int cnt = service.insertBoard(boardVo);
		
		if(cnt>0) {
			System.out.println("게시물 추가 성공~~");
		}else {
			System.out.println("게시물 추가 실패~~");
		}
		
	}
	
	
	//목록출력
	public void viewBoard() {
		
		//글번호, 글제목, 작성자, 작성날짜, 조회수, 내용		
		//BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CNT, BOARD_CONTENT	
		List<BoardVo> boardList = service.getAllView();
		System.out.println("-------------------------------------------------------------\n"
				+ " No	        제 목            작성자 	조회수   \n"
				+ "-------------------------------------------------------------");
		if( boardList == null || boardList.size() == 0) {
			System.out.println("출력할 자료가 하나도 없습니다.");
		}else {
			for(BoardVo boardVo : boardList) {
				
				int boardNo = boardVo.getBorad_no();
				String boardId = boardVo.getMem_id();
				String boardTitle = boardVo.getBorad_title();
				String boardDate = boardVo.getBoard_date();
				String boardViewCount = boardVo.getBorad_viewCount();
				//String boardContent = boardVo.getContent();
				
				System.out.println(boardNo+"\t"+boardTitle+"\t"+boardId+"\t"+boardViewCount);
			}
			
			//자료가 있을경우 상세페이지 호출요청
			detailBoard();
			
		}
		

		
	}
	
	
	
	//상세페이지 출력
	public void detailBoard() {
		
		int input = displayMenuDetail();
		
		//글번호, 글제목, 작성자, 작성날짜, 조회수, 내용		
		//BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CNT, BOARD_CONTENT	
		List<BoardVo> boardList = service.getAllView();
		int boardNo = 0;
			for(BoardVo boardVo : boardList) {
				
				boardNo = boardVo.getBorad_no();
				String boardId = boardVo.getMem_id();
				String boardTitle = boardVo.getBorad_title();
				String boardDate = boardVo.getBoard_date();
				String boardViewCount = boardVo.getBorad_viewCount();
				String boardContent = boardVo.getContent();
				
				System.out.println(boardNo+"\t"+boardTitle+"\t"+boardId+"\t"+boardViewCount);
				System.out.println("-------------------------------------------------------------");
				System.out.println(boardContent);
			}
			
		//게시물 작업선택
		choice2(boardNo);
		

	}
	
	
	
	//검색
	public void serch() {
		String word = serchChoice();
		
		
		//글번호, 글제목, 작성자, 작성날짜, 조회수, 내용		
		//BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CNT, BOARD_CONTENT	
		List<BoardVo> boardList = service.serch(word);
		System.out.println("-------------------------------------------------------------\n"
				+ " No	        제 목            작성자 	조회수   \n"
				+ "-------------------------------------------------------------");
		if( boardList == null || boardList.size() == 0) {
			System.out.println("출력할 자료가 하나도 없습니다.");
		}else {
			for(BoardVo boardVo : boardList) {
				
				int boardNo = boardVo.getBorad_no();
				String boardId = boardVo.getMem_id();
				String boardTitle = boardVo.getBorad_title();
				String boardDate = boardVo.getBoard_date();
				String boardViewCount = boardVo.getBorad_viewCount();
				//String boardContent = boardVo.getContent();
				
				System.out.println(boardNo+"\t"+boardTitle+"\t"+boardId+"\t"+boardViewCount);
			}

			//자료가 있을경우 상세페이지 호출요청
			detailBoard();
		}
		
		
	}
	


	
	//삭제
	public void deletBoard( int boardNo ) {
		
		
		System.out.println();
		//System.out.println("삭제하시겠습니까?");
		
		
		int cnt = service.deleteBoard(boardNo);

		if(cnt>0) {
			System.out.println("게시물 삭제 성공~~");
		}else {
			System.out.println("게시물 삭제 실패~~");
		}
	
	}
	
	
	//수정
	public void updateBoard( int boardNo ) {
		
		System.out.println();
		System.out.println("추가할 회원 정보 입력");
		
		
		System.out.println("제목 >>");
		String boardTitle = scan.next();
		
		System.out.println("내용>>");
		String boardContain = scan.next();
		

		
		//입력한 데이터를 VO객체에 저장한다.
		BoardVo boardVo = new BoardVo();
		boardVo.setBorad_title(boardTitle);
		boardVo.setContent(boardContain);
		
		int cnt = service.updateBoard(boardVo);
		
		if(cnt>0) {
			System.out.println("게시물 수정 성공~~");
		}else {
			System.out.println("게시물 수정 실패~~");
		}

		
		
	}
	
	
	
	public static void main(String[] args) {
		
		new BoardController().start();
		

	}

}
