package kr.or.ddit.basic.mvc.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import kr.or.ddit.basic.mvc.service.IMemberService;
import kr.or.ddit.basic.mvc.service.MemberServiceImpl;
import kr.or.ddit.basic.mvc.vo.MemberVO;
import kr.or.ddit.util.CryptoUtil;


/*
 * 1. 회원정보중에서 회원 ID는 양방향 암호화로 변환하여 DB에 저장하고 화면에 보여줄때는 원래의 데이터로 복원하여 보여준다.
 * 2. 비밀번호는 단방향 알고리즘으로 암호화 하여 DB에 저장한다.
 * 
 * 
*/

public class MemberController {
	private Scanner scan = new Scanner(System.in);
	private IMemberService service;
	public String encryptedStr;
	public String decryptedStr;
    String key = "a1b3c34dsfkjs834";
	
	//생성자
	private MemberController(){
		//service = new MemberServiceImpl();
		service = MemberServiceImpl.getInstance();
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
				+ " *   6. 자료수정3	\n"
				+ " *   0. 작업 끝...\n"
				+ " *   \n"
				+ " * -------------------------\n"
				+ " * 원하는 작업번호 >");
		int sc = scan.nextInt();
		return sc;
	}
	
	
	
	public int start() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		
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
			case 5: updateMember2();//수정2
				break;
			case 6: updateMember2();//수정3
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
	
	
	private void updateMember2(){
		int input;
		String updateField = null;
		String updateTitle = null;
	
		System.out.println();
		System.out.println("수정할 회원 아이디를 입력하세요");
		String memId = scan.next();
		int count = service.getMemberCount(memId);
		if(count == 0) {
			System.out.println(memId+"는 없은 회원 입니다.");
			System.out.println("수정작업을 마칩니다.");
			return;
		}
		do{System.out.println("수정을 원하는 항목을 입력해주세요.");
		System.out.println("1. 비밀번호  2.회원이름  3. 전화번호  4. 회원주소");
		 input = scan.nextInt();
			switch(input) {
			case 1: updateField = "mem_pass";//비밀번호
					updateTitle = "비밀번호";
				break;
			case 2: updateField = "mem_name";//비밀번호
					updateTitle = "회원이름";
				break;
			case 3: updateField = "mem_tel";//비밀번호
					updateTitle = "전화번호";
				break;
			case 4: updateField = "mem_addr";//비밀번호
					updateTitle = "회원주소";
				break;
			default: System.out.println("수정항목을 잘못 선택했습니다. 다시선택해주세요.");
				updateMember2();
				}
		}while(input<0 || input>5);
		
		System.out.println();
		System.out.println("새로운"+updateTitle+" >> ");
		scan.nextLine();
		String updateData = scan.nextLine();
		
		//수정 작업에 필요한 정보를 Map객체에 셋팅한다.
		//key값 정보 ==> 회원ID(memid), 수정할 컬럼명(field), 수정할데이터(data)
		Map<String, String>ParamMap = new HashMap<String, String>();
		
		ParamMap.put("memid", memId); //회원 ID
		ParamMap.put("field", updateField); //수정할 컬럼명
		ParamMap.put("data", updateData); //수정할 데이터
		
		int cnt = service.updateMember2(ParamMap);
		
		if(cnt >0) {
			System.out.println("수정성공~");
		}else {
			System.out.println("수정실패~");		
		}
		
	
		
	}
	
	

	
	
	//회원정보를 추가(입력)하는 메서드
	//db에 직접 접근하면 안됌
	private int insertMember() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		System.out.println();
		System.out.println("추가할 회원 정보 입력");
		
		
		//자료추가에서 '회원 id'는 중복되지 않는다.
		//(중복되면 다시 입력받는다.)
		int count = 0; //입력한 회원 id의 개수가 저장될 변수
		String memId = scan.next(); //회원 ID가 저장될 변수
		
		
		//암호화에 사용하는 key값 설정(16자리 이상으로 한다.)
		String result = CryptoUtil.sha512(memId);
	    encryptedStr = CryptoUtil.encryptoAE256(memId, key);
	   
		
	    
		//자료추가에서 '회원 id'는 중복되지 않는다.
		//(중복되면 처음으로)
		int cnt = 0;
		List<MemberVO> memList = service.getAllMember();
			for(MemberVO memVo: memList) {
				//복호화
				decryptedStr = CryptoUtil.decryptoAE256(memVo.getMem_id(), key);
				//복호화한 id와 입력받은 id비교
				if(decryptedStr.equals(memId)) {
					System.out.println(memId+"는 있는 회원 입니다.");
					return start();
				}						
			}


		
		
		
//		do {
//			System.out.println("회원ID >> ");
//			memId = scan.next();
//			count = service.getMemberCount(memId);
//			if(count>0) {
//				System.out.println(memId+"는 이미 등록된 id입니다.");
//				System.out.println("다른 회원 id를 입력하세요");
//			}
//			
//		}while(count>0);
		
	   
	    
		System.out.println("비밀번호 >>");
		String result2 = scan.next();
		String memPass = CryptoUtil.sha512(result2);
		
		System.out.println("회원이름 >>");
		String memName = scan.next();
		
		System.out.println("전화번호>>");
		String memTel = scan.next();
		
		scan.nextLine(); //입력버퍼비우기
		System.out.println("회원주소>>");
		String memAddr = scan.nextLine();
		
		//입력한 데이터를 VO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(encryptedStr);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		cnt = service.insertMember(memVo);
		
		if(cnt>0) {
			System.out.println("회원정보 추가 성공~~");
		}else {
			System.out.println("회원정보 추가 실패~~");
		}
		return 0;
		
		
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
		private void deleteMember() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
			System.out.println();
			System.out.println("삭제할 회원정보를 입력하세요.");
			System.out.println("삭제할 회원 ID >> ");
			String memId;
			
			List<MemberVO> memList = service.getAllMember();
			//자료추가에서 '회원 id'는 중복되지 않는다.
			//(중복되면 다시 입력받는다.)
			int count = 0; //입력한 회원 id의 개수가 저장될 변수
			int cnt = 0;
			do {
			
				memId = scan.next();
				
				for(MemberVO memVo: memList) {
					//복호화
					decryptedStr = CryptoUtil.decryptoAE256(memVo.getMem_id(), key);
					//복호화한 id와 입력받은 id비교
					if(decryptedStr.equals(memId)) {
						cnt = service.deletMenber(memVo.getMem_id());
					}						
				}
				if(cnt == 0) {
					System.out.println(memId+"는 없는 회원 입니다. 다시입력해주세요.");	
				}
				
			}while(cnt==0);

			if(cnt>0) {
				System.out.println("회원정보 삭제 성공~~");
			}else {
				System.out.println("회원정보 삭제 실패~~");
			}
			
		}
		
		
		//회원 전체정보를 출력하는 메서드
		private void displayMember() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
			
			
			List<MemberVO> memList = service.getAllMember();
			System.out.println();
			System.out.println("-----------------------------");
			System.out.println("ID   비밀번호 	회원이름		전화번호 		회원주소");
			System.out.println("-----------------------------");


			
			if(memList == null || memList.size() == 0) {
				System.out.println("출력할 자료가 하나도 없습니다.");
			}else {
				for(MemberVO memVo: memList) {
					
					//복호화
					decryptedStr = CryptoUtil.decryptoAE256(memVo.getMem_id(), key);
					//출력
					String memId = decryptedStr;
					String memPass = memVo.getMem_pass();
					String memName = memVo.getMem_name();
					String memTel = memVo.getMem_tel();
					String memAddr = memVo.getMem_addr();
					
					System.out.println(memId+"\t"+memPass+"\t"+memName+"\t"+memTel+"\t"+memAddr);
					
				}
			}
			
			
			
		}
		
	
	
	public static void main(String[] args) throws Exception {
		new MemberController().start();

	}

}
