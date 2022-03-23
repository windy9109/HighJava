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
	
	public int start(){
		
		while(true) {
			int chice = displayMenu();
			switch(chice) {
			case 1: insertBoard();//새글작성
				break;
			case 2: viewBoard();//게시글보기
				break;
			case 3: deletBoard();//검색
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
	
	public int insertBoard() {
		
		
		return 0;
	}
	
	
	//출력
	public int viewBoard() {
		
		List<BoardVo> boardList = service.getAllView();
		System.out.println("-------------------------------------------------------------\n"
				+ " No	        제 목            작성자 	조회수   \n"
				+ "-------------------------------------------------------------");
		if( boardList == null || boardList.size() == 0) {
			System.out.println("출력할 자료가 하나도 없습니다.");
		}else {
			for(BoardVo boardVo : boardList) {
				
				int memNo = boardVo.getBorad_no();
				String memId = boardVo.getMem_id();
				
				
			}
		}
		
		
		
		
		return 0;
	}
	
	
	
	public int deletBoard() {
		
		return 0;
	}
	
	
	public static void main(String[] args) {
		
		new BoardController().start();
		

	}

}
