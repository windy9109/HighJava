package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hotell {
	
	private Scanner sc = new Scanner(System.in); 
	private Map<Integer, Room> list = new HashMap<Integer, Room>();
	
	
	
	public static void main(String[] args) {
		
		new Hotell().start();
		

	}
	
	public int start() {
		System.out.println("\n*********************************************\n"
				+ "       호텔문을 열었습니다. 어서오십시요.\n"
				+ "*********************************************");
		
		System.out.println("-----------------------------------------------------------\n"
				+ "어떤 업무를 하시겠습니까?\n"
				+ "1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료\n"
				+ "-----------------------------------------------------------");
		
		System.out.println("선택 >");
		int input = sc.nextInt();
		switch(input) {
		case 1: checkIn(); break; //체크인
		case 2: checkout(); break; //체크아웃
		case 3: view(); break; //객실상태
		case 4: System.exit(input); break; //업무종료
		default: System.out.println("잘못입력했습니다. 다시입력해주세요");
		return start();
		}
		return start();
	}
	
	//체크인
	public int checkIn(){
		System.out.println("----------------------------------------------\n"
				+ "   체크인 작업\n"
				+ "----------------------------------------------");

		System.out.println(" * 201~209 : 싱글룸\n"
						+ " * 301~309 : 더블룸\n"
						+ " * 401~409 : 스위트룸\n"
						+ "----------------------------------------------\n"
						+ "방 번호 입력 >>");

		int input = sc.nextInt();		
		if( input>=201 && input<=209 && !list.containsKey(input)) {
			System.out.println("누구를 체크인 하시겠습니까?"
					+ "이름입력>>");
			String name2 = sc.nextLine();
			String name = sc.nextLine();
			list.put(input, new Room(input, "싱글룸", name));
			System.out.println("체크인이 완료되었습니다.");
		}else if( input>=301 && input<=309 && !list.containsKey(input) ){
			System.out.println("누구를 체크인 하시겠습니까?"
					+ "이름입력>>");
			String name2 = sc.nextLine();
			String name = sc.nextLine();
			list.put(input, new Room(input, "더블룸", name));
			System.out.println("체크인이 완료되었습니다.");
		}else if( input>=401 && input<=409 && !list.containsKey(input)){
			System.out.println("누구를 체크인 하시겠습니까?"
					+ "이름입력>>");
			String name2 = sc.nextLine();
			String name = sc.nextLine();
			list.put(input, new Room(input, "스위트룸", name));
			System.out.println("체크인이 완료되었습니다.");
		}else if(list.containsKey(input)){
			System.out.println("이미등록된 객실입니다.");
		}
		else{
			System.out.println(input+"호 객실은 존재하지 않습니다.");
		}
		
		
		return start();
	}
	
	//체크아웃
	public int checkout() {
		
		System.out.println("----------------------------------------------\n"
				+ "   체크아웃 작업\n"
				+ "----------------------------------------------\n"
				+ "체크아웃 할 방 번호를 입력하세요."
				+ "방번호 입력>>");
		int input = sc.nextInt();
		if(list.containsKey(input)) {
			list.remove(input);
			System.out.println("체크아웃성공!");
		}else if( list.containsKey(input) && list.get(input).getName().isEmpty() ){
			System.out.println(input+"호 객실에는 체크인 한 사람이 없습니다.");
		}else {
			System.out.println(input+"호 객실은 존재 하지않습니다.");
		}
		
		return start();
	}
	
	
	//객실상태
	public int view() {
		
		System.out.println("\n"
				+ "----------------------------------------------\n"
				+ "		현재 객실 상태\n"
				+ "----------------------------------------------\n"
				+ "방 번호	 방 종류	 투숙객 이름\n"
				+ "----------------------------------------------");
		for( Integer key : list.keySet()) {
			System.out.println(list.get(key).getNum()+"\t"+list.get(key).getType()+"\t"+list.get(key).getName());
		}
		return start();
	}
	
	

}


class Room{
	private int num;
	private String type;
	private String name;
	
	public Room(int num, String type, String name) {
		super();
		this.num = num;
		this.type = type;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Room [num=" + num + ", type=" + type + ", name=" + name + "]";
	}
	
	
	
	
	
}






