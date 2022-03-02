package kr.or.ddit.basic;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTest3 {

	private HashMap<String, Phone3> phoneBookMap;
	private Scanner scan;
	
	public PhoneBookTest3(){
		phoneBookMap = new HashMap<String, Phone3>();
		scan =new Scanner(System.in);
		
	} 
	
	//프로그램을 시작하는 메서드
	public void phoneStart() {

		
		while(true) {
			int choice = displayMenu();
			switch(choice) {	
				case 1: insert(); break; //등록 //break 대신 return을 써야함
				case 2: update(); break; //수정
				case 3: delete(); break; //삭제
				case 4: search(); break;//검색
				case 5: displayAll(); break; //전체목록
				case 0: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("작업번호를 잘못 입력했습니다.");
				System.out.println("다시입력해주세요");
			}
		}
	}
	
	//전화번호 정보를 수정하는 메서드
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력해주세요.");
		System.out.println("이름>>");
		String name =scan.next();
		//입력한 사람의 이름이 전화번호 정보에 없으면...
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name+"씨는 등록되지 않은 사람입니다.");
			System.out.println("수정작업을 마칩니다.");
			return;
		}
		
		System.out.println("새로운 전화번호>>");
		String newTel = scan.next();
		System.out.println("새로운 주소>>");
		String newAddr = scan.next();
		phoneBookMap.put(name, new Phone3(name, newAddr, newTel));
		System.out.println(name+"씨의 전화번호 정보를 수정완료!");
		
		
	}
	
	
	//전화번호 정보를 삭제하는메서드
	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호를 입력하세요...");
		System.out.println("이름>>");
		String name = scan.next();
		
		//입력한 사람의 이름이 전화번호에 없으면...
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name+"씨는 등록되지 않은 이름입니다.");
			System.out.println("삭제작업을 마칩니다.");
			return;
		}
		phoneBookMap.remove(name);
	}
	
	//전화번호 정보를 검색하는 메서드
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호를 입력하세요");
		System.out.println("이름>>");
		String name = scan.next();
		
		
		//입력한 사람의 이름이 전화번호 정보에 없으면....
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name+"씨는 이미 등록되지 않은 이름입니다.");
			System.out.println("검색작업을 마칩니다.");
			return; //return을 쓰지 않는 다면 else를 써줘야함
		}
		
		Phone3 p = phoneBookMap.get(name);
		System.out.println(name+"씨의 전화번호 정보");
		System.out.println("========================");
		System.out.println("이  름:"+p.getName());
		System.out.println("전화번호:"+p.getTel());
		System.out.println("주  소:"+p.getAddr());
		System.out.println("========================");
		
	}
	
	
	//메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
	public int displayMenu() {
		System.out.println("------------------------");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체목록");
		System.out.println("0. 시스템 종료");
		System.out.println("------------------------");
		System.out.println("번호입력>>");
		int  num = scan.nextInt();
		return num;
		
	}
	
	
	//새로운 전화번호를 반환하는 메서드
	private void insert() {
		System.out.println();
		System.out.println("새롭게 등록할 전화번호를 입력하세요");
		System.out.println("이름>>");
		String name = scan.next();
		
		//이미 등록된 사람인지 출력하는 메서드
		if(phoneBookMap.containsKey(name)) {
			System.out.println(name+"씨는 이미 등록된 이름입니다.");
			return; //return을 쓰지 않는 다면 else를 써줘야함
		}
		System.out.print("전화번호>>");
		String tel = scan.next();
		System.out.print("주소>>");
		String addr = scan.next();
		
		
		Phone3 p = new Phone3(name, addr, tel);
		
		phoneBookMap.put(name, new Phone3(name, addr, tel));
		
		return;
		
	}
	
	
	
	
	
	
	//전화번호 정보 전체 자료를 출력하는 메서드
	private void displayAll() {
		System.out.println();
		//모든 key값 가져오기
		Set<String> phoneKeySet =phoneBookMap.keySet();
		
		System.out.println("----------------------------");
		System.out.println("번호  이름   전화번호   주소");
		System.out.println("----------------------------");
		if(phoneKeySet.size() == 0 ) {
			System.out.println("등록된 전화번호가 하나도 없습니다.");
		}else {
			int cnt =0; //번호 출력용 변수
			for(String name : phoneKeySet) {
				cnt++;
				Phone3 p = phoneBookMap.get(name);
				System.out.println(cnt+" "+name+" "+p.getTel()+" "+p.getAddr());
			}
		}
	
		System.out.println("------------------------------");
		System.out.println("");
		return;
		
	}

	
	
	
	
	
	public static void main(String[] args) {
		new PhoneBookTest3().phoneStart();
	}

}


class Phone3{
	private String name;
	private String addr;
	private String tel;
	public Phone3(String name, String addr, String tel) {
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Phone [name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
	}
	
	
	
	
} 