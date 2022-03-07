package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 문제) 이름,주소,전화번호를 맴버로 갖는 Phone클래스를 만들고,
 * 		Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 * 
 * 		전화번호 정보는 Map에 저장하여 관리한다.
 * 		(key값은 입력받은 사람의 '이름'으로 하고,
 * 		value값은 'Phone클래스의 인스턴스'로 한다.)
 * 
 * 		아래메뉴의 기능을 모두 작성하시오.
 * 		(삭제, 검색 기능은 '이름'을 입력받아 처리한다.)
 * 
 */

public class PhoneBookTest2 {
	
	//Scanner전역선언
	private Scanner sc = new Scanner(System.in); 
	//Phone class 에 있는 변수들을 HashMap에 담는다.
	Map<String, Phone2> list = new HashMap<String, Phone2>();
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new PhoneBookTest2().start();
		
	}
	
	
	public int start(){
		
		System.out.println("1.전화번호등록\n"
				+ "2.전화번호 수정\n"
				+ "3.전화번호 삭제\n"
				+ "4.전화번호 검색\n"
				+ "5.전화번호 전체 출력\n"
				+ "0.프로그램종료");
		int input = sc.nextInt();
		
		switch(input) {
		case 1: return add(); //전화번호 등록
		case 2: return modify(); //전화번호 수정
		case 3: return delete(); //전화번호 삭제
		case 4: return select(); //전화번호 검색
		case 5: return view(); //전화번호 전체출력
		case 0: System.out.println("프로그램을 종료합니다"); System.exit(input); break; //프로그램 종료
		default: System.out.println("잘못입력했습니다. 다시입력해주세요");
		return start();
			
		}
		return start();
		
	}
	
	//등록
	public int add() {
		System.out.println("새롭게 등록할 전화번호를 입력해주세요");
		System.out.println("이름을 입력해주세요");
		sc.nextLine();
		String name1 = sc.nextLine();
		System.out.println("주소를 입력해주세요");
		String addr = sc.nextLine();
		System.out.println("전화번호를 입력해주세요");
		int tel = Integer.parseInt(sc.nextLine());
		list.put(name1, new Phone2(name1,addr,tel)); //Phone2 class 변수를 굳이..? 만들어줘야할까?
		System.out.println("등록성공!");
		return start();
	}
	
	//수정
	public int modify() {
		
		System.out.println("이름을 입력해주세요");
		sc.nextLine();	//입력버퍼 비우기
		String rename = sc.nextLine();
		
		
		if( list.containsKey(rename) ) {
			System.out.println("수정할 주소를 입력해주세요");
			String addr = sc.nextLine();
			System.out.println("수정할 전화번호를 입력해주세요"); //0의 연속입력불가
			int tel = Integer.parseInt(sc.nextLine());
			//방법1
			//주소변경
			list.get(rename).setAddr(addr);
			//전화번호변경
			list.get(rename).setTel(tel);
			
			//방법2
			//list.put(rename, new Phone2(rename,addr,tel));
			System.out.println("수정성공!");
			
		}else{
			System.out.println("등록되지 않은 이름입니다.");
		}
		return start();
	}
	
	/*
	 * Scanner객체의 입력메서드 특징
	 * - next(), nextInt(), nextDouble(),....등
	 * 		=> 사이띄기, Tab키, Enter키를 구분 문자로 분리해서 분리된 자료만 읽어간다.
	 * - nextLine()
	 * 		=> 한줄 단위로 입력한다. 즉, 자료를 입력하고 enter키를 누르면 enter키까지 읽어간다.
	 * - Scanner 는 입력한값이 입력버퍼에 먼저 저장된후 차례로 꺼내와서 처리된다.
	 * 
	*/
	
	//삭제
	public int delete() {
		System.out.println("삭제할 이름을 입력해주세요");
		sc.nextLine();
		String name2 = sc.nextLine();
		list.remove(name2);
		System.out.println("삭제성공!");
		return start();
	}
	
	//검색
	public int select() {
		
		System.out.println("검색 할 이름을 입력해주세요");
		sc.nextLine();  //인식못함
		String name2 = sc.nextLine();
		System.out.println(list.get(name2));
		return start();
	}
	
	//전체출력
	public int view() {
		for( String key : list.keySet()) {
			System.out.println(list.get(key));
		}
		return start();
	}
}




class Phone2{
	private String name;
	private String addr;
	private int tel;
	
	
	public Phone2(String name, String addr, int tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "Phone [name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	

	
	
}
