package kr.or.ddit.basic.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
 * 
 * 		추가조건)
 * 		1) '6. 전화번호 저장' 메뉴를 추가하고 구현한다.
 * 			(저장파일명은 'phoneData.dat'로 한다.)
 * 		2) 프로그램이 시작될때 저장된 파일이 있으면 그 데이터를 읽어와 Map에 저장한다.
 * 		3) 프로그램을 종료할때 Map의 데이터가 수정되거나 추가 또는 
 * 			삭제되면 저장한 후 종료되도록 한다.
 * 
 * 
 * 
 * 		메뉴예시)
 * 		1.전화번호등록
		2.전화번호 수정
		3.전화번호 삭제
		4.전화번호 검색
		5.전화번호 전체 출력
		6.전화번호 저장
		0.프로그램종료

 * 
 * 
 */

public class PhoneBookTest2 {
	
	//Scanner전역선언
	private Scanner sc = new Scanner(System.in); 
	//Phone class 에 있는 변수들을 HashMap에 담는다.
	Map<String, Phone2> list = new HashMap<String, Phone2>();
	private String fileName ="d:/d_other/phone.dat";
	
	// 데이터가 변경되었는지 여부를 나타내는 변수 선언
	// 데이터가  
	private boolean dataChange;
	


	//생성자
	public PhoneBookTest2() {
		this.sc = sc;
		this.list = load();
		//파일이 없거나 잘못되었을때...
		if(list == null) {
			list = new HashMap<String, Phone2>();
		}
		
		this.fileName = fileName;
	}


	
	
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
				+ "6.전화번호 저장\n"
				+ "0.프로그램종료");
		int input = sc.nextInt();
		
		switch(input) {
		case 1: return add(); //전화번호 등록
		case 2: return modify(); //전화번호 수정
		case 3: return delete(); //전화번호 삭제
		case 4: return select(); //전화번호 검색
		case 5: return view(); //전화번호 전체출력
		case 6: return save(); //전화번호 저장
		case 0: if( dataChange == true ) { save(); }
			System.out.println("프로그램을 종료합니다"); System.exit(input); break; //프로그램 종료
		default: System.out.println("잘못입력했습니다. 다시입력해주세요");
		return start();
			
		}
		return start();
		
	}
	
	//저장된 전화번호가 정보 파일을 읽어오는 메서드
	// 반환값: 파일에서 읽어온 데이터( Map객체 )
	 private HashMap<String, Phone2> load(){
		 //읽어온 데이터가 저장될 변수 선언
		 HashMap<String, Phone2> pMap = null;
		 
		 File file = new File(fileName);
		 if(!file.exists()) { //저장된 파일이 없으면...
			 return null; 
		 }
		 ObjectInputStream ois = null;
		 try {
			//입력용 스트림객체 생성
			 ois = new ObjectInputStream(
					 new BufferedInputStream(
							 new FileInputStream(file)
					  )
				   );
			 //파일 내용을 읽어서 변수에 저장한다.
			 pMap =(HashMap<String, Phone2>)ois.readObject();
			 
			 
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}finally {
			if(ois != null) {
				try {
					//사용했던 스트림 닫기
					ois.close();
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}
		}
		 
		 
		 return pMap;
		 
	 }
	
	
	 
	 
	//전화번호 정보를 파일로 저장하는 메서드
	private int save(){
		ObjectOutputStream oos = null;
		try {
			//객체출력용 스트림객체 생성
			oos = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(fileName)));
			
			//Map객체를 파일로 저장한다.
			oos.writeObject(list);
			System.out.println("저장이 완료되었습니다.");
			dataChange = false;
			
		} catch (IOException e) {
			System.out.println("저장실패");
			e.printStackTrace();
		}finally {
			//사용했던 스트림객체 닫기
			if(oos!=null) {
				try {
					oos.close();
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}
		}
		return 0;
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
		dataChange = true;
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
			dataChange = true;
			
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
		dataChange = true;
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



//Phone2객체 직렬화
class Phone2 implements Serializable{
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
