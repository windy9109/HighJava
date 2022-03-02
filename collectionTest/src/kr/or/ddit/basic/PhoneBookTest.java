package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTest {
	
	private Scanner sc = new Scanner(System.in);
	private HashMap<String, Phone> phonebook = new HashMap<String, Phone>();
	
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


	public static void main(String[] args) {

		new PhoneBookTest().start();
		

	}
	
	//시작
	public int start() {
		
		
		System.out.println("1.전화번호 등록\n"
				+ "2.전화번호 수정\n"
				+ "3.전화번호 삭제\n"
				+ "4.전화번호 검색\n"
				+ "5.전화번호 전체 출력\n"
				+ "0.프로그램 종료");
		int input = sc.nextInt();

	//	PhoneBookTest view = new PhoneBookTest(); 
		
		switch(input) {
		case 1: New(); //등록
		case 2: Update(); //수정
		case 3: Delete(); //삭제
		case 4: Select(); //검색
		case 5: View(); //전체출력
		case 0: System.out.println("시스템을 종료합니다.");
			System.exit(input); break;
			default:System.out.println("잘못입력했습니다. 다시입력해주세요");
			return start();
		}
		return start();
		
		
	}
	
	//수정
	public int Update() {
		System.out.println("수정할 전화번호를 입력해주세요.");
		System.out.println("이름>> ");
		String name = sc.nextLine();
		System.out.println("주소>> ");
		String addr = sc.nextLine();
		System.out.println("전화번호>> ");
		int tel = sc.nextInt();
		
		phonebook.put(name, new Phone(name, addr, tel));
		
		return start();
		
	}
	
	//삭제
	public int Delete() {
		
		
		System.out.println("삭제할 사람의 이름을 입력해주세요");
		System.out.println("이름>> ");
		String name = sc.nextLine();
		
		phonebook.remove(name);
		
		
		return start();
		
	}
	
	//검색
	public int Select() {
		
		System.out.println("검색할 사람의 이름을 입력해주세요");
		System.out.println("이름>> ");
		String name = sc.nextLine();
		System.out.println("-----------------------------------------");
		System.out.println("번호    이 름    전 화 번 호      주    소");
		System.out.println("-----------------------------------------");	
		phonebook.get(name);
		
		return start();
		
	}

	
	//조회
	public int View() {
		
		System.out.println("-----------------------------------------");
		System.out.println("번호    이 름    전 화 번 호      주    소");
		System.out.println("-----------------------------------------");	
		for(Phone key: phonebook.values()) {
			Phone value = phonebook.get(key);
			System.out.println(key+": "+value);
		}
		return start();

		
	}
	
	
	//등록
	public int New() {
		
		System.out.println("새롭게 등록할 전화번호를 입력해주세요.");
		System.out.println("이름>> !");
		String name = sc.nextLine();
		String name1 = sc.nextLine();
//		outer:while(true) {
//
//			if(phonebook.containsKey(name)) { //만약 키가 있다면
//				System.out.println("이미 등록된 사람입니다.");
//			}else {
//				break outer;
//			}
//		}
		System.out.println("주소>> !!");
		String addr = sc.nextLine();
		System.out.println("전화번호>> !!!");
		int tel = sc.nextInt();
		phonebook.put(name,new Phone(name, addr, tel));	
		System.out.println("등록성공");
		
		
		return start();
		
	} 
	
	

}




class Phone{
	private String name;
	private String addr;
	private int tel;
	
	public Phone(String name, String addr, int tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
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

	@Override
	public String toString() {
		return "Phone [name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
	}
	

	
	
	
	
}