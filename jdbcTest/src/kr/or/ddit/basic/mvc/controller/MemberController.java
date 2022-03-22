package kr.or.ddit.basic.mvc.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.basic.mvc.service.IMemberService;
import kr.or.ddit.basic.mvc.service.MemberServiceImpl;
import kr.or.ddit.basic.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberController {
	private Scanner scan = new Scanner(System.in);
	private IMemberService service;
	
	//생성자
	public MemberController(){
		service = new MemberServiceImpl();
	}
	
	//메뉴를 출력하고 선택한 작업번호를 반환하는 메서드
	private int displayMenu() {
		System.out.println(" *  -------------------------\n"
				+ " *  	== 작업 선택 ==\r\n"
				+ " *   1. 자료추가		\n"
				+ " *   2. 자료수정		\n"
				+ " *   3. 자료삭제		\n"
				+ " *   4. 전체 자료 출력	\n"
				+ " *   5. 자료수정2	\n"
				+ " *   0. 작업 끝...\n"
				+ " *   \n"
				+ " * -------------------------\n"
				+ " * 원하는 작업번호 >");
		int sc = scan.nextInt();
		return sc;
	}
	
	
	
	public int start() {
		
		while(true) {
			int chice = displayMenu();
			switch(chice) {
			case 1: insertMember();//추가
				break;
			case 2: updateMember();//수정
				break;
			case 3: deleteMember();//삭제
				break;
			case 4: displayMember();//전체출력
				break;
			case 5: updateMember2();//전체출력
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
	
	//원하는 항목만 수정하는 메뉴
	private void updateMember2(){
		
	}
	
	
	//회원정보를 추가(입력)하는 메서드
	//db에 직접 접근하면 안됌
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보 입력");
		
		//자료추가에서 '회원 id'는 중복되지 않는다.
		//(중복되면 다시 입력받는다.)
		int count = 0; //입력한 회원 id의 개수가 저장될 변수
		String memId; //회원 ID가 저장될 변수
		do {
			System.out.println("회원ID >> ");
			memId = scan.next();
			count = service.getMemberCount(memId);
			if(count>0) {
				System.out.println(memId+"는 이미 등록된 id입니다.");
				System.out.println("다른 회원 id를 입력하세요");
			}
			
		}while(count>0);
		
		System.out.println("비밀번호 >>");
		String memPass = scan.next();
		
		System.out.println("회원이름 >>");
		String memName = scan.next();
		
		System.out.println("전화번호>>");
		String memTel = scan.next();
		
		scan.nextLine(); //입력버퍼비우기
		System.out.println("회원주소>>");
		String memAddr = scan.nextLine();
		
		//입력한 데이터를 VO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		int cnt = service.insertMember(memVo);
		
		if(cnt>0) {
			System.out.println("회원정보 추가 성공~~");
		}else {
			System.out.println("회원정보 추가 실패~~");
		}
		
		
	}
	
	
	
	
	//전체 회원 정보를 수정하는 메서드
		private void updateMember() {
			System.out.println();
			System.out.println("수정할 회원 정보를 입력하세요...");
			System.out.println("회원 ID>> ");
			//자료추가에서 '회원 id'는 중복되지 않는다.
			//(중복되면 다시 입력받는다.)
			int count = 0; //입력한 회원 id의 개수가 저장될 변수
			String memId = scan.next(); //회원 ID가 저장될 변수
			count = service.getMemberCount(memId);
			if(count == 0) {
				System.out.println(memId+"는 없는 id입니다.");
				return;
			}
				

			
			
			System.out.println();
			System.out.println("수정할 내용을 입력하세요");
			System.out.println("새로운 비밀번호 >> ");
			String newMemPass = scan.next();
			
			System.out.println("새로운 회원이름");
			String newMemName = scan.next();

			System.out.println("새로운 회원 전화번호");
			String newMemTel = scan.next();
			
			System.out.println("새로운 회원주소");
			String newMemAddr = scan.next();
			
			
			//입력한 데이터를 VO객체에 저장한다.
			MemberVO memVo = new MemberVO();
			memVo.setMem_id(memId);
			memVo.setMem_pass(newMemPass);
			memVo.setMem_name(newMemName);
			memVo.setMem_tel(newMemTel);
			memVo.setMem_addr(newMemAddr);
			
			int cnt = service.updateMember(memVo);
			
			if(cnt>0) {
				System.out.println("회원정보 수정 성공~~");
			}else {
				System.out.println("회원정보 수정 실패~~");
			}
			
			
			
			
		}
		
		
		//회원정보를 삭제하는 메서드
		private void deleteMember() {
			System.out.println();
			System.out.println("삭제할 회원정보를 입력하세요.");
			System.out.println("삭제할 회원 ID >> ");
			String memId;
			
			//자료추가에서 '회원 id'는 중복되지 않는다.
			//(중복되면 다시 입력받는다.)
			int count = 0; //입력한 회원 id의 개수가 저장될 변수
			do {
				scan.nextLine();
				memId = scan.nextLine();
				count = service.getMemberCount(memId);
				if(count>0) {
					System.out.println(memId+"는 이미 등록된 id입니다.");
					System.out.println("다른 회원 id를 입력하세요");
				}
				
			}while(count>0);
			
			
//			MemberVO memVo = new MemberVO();
//			memVo.setMem_id(memId);
			
			int cnt = service.deletMenber(memId);

			if(cnt>0) {
				System.out.println("회원정보 삭제 성공~~");
			}else {
				System.out.println("회원정보 삭제 실패~~");
			}
			
		}
		
		
		//회원 전체정보를 출력하는 메서드
		private void displayMember() {
			
			List<MemberVO> memList = service.getAllMember();
			System.out.println();
			System.out.println("-----------------------------");
			System.out.println("ID   비밀번호 	회원이름		전화번호 		회원주소");
			System.out.println("-----------------------------");

			if(memList == null || memList.size() == 0) {
				System.out.println("출력할 자료가 하나도 없습니다.");
			}else {
				for(MemberVO memVo: memList) {
					
					String memId = memVo.getMem_id();
					String memPass = memVo.getMem_pass();
					String memName = memVo.getMem_name();
					String memTel = memVo.getMem_tel();
					String memAddr = memVo.getMem_addr();
					
					System.out.println(memId+"\t"+memPass+"\t"+memName+"\t"+memTel+"\t"+memAddr);
					
				}
			}
			
			
			
		}
		
	
	
	public static void main(String[] args) {
		new MemberController().start();

	}

}
