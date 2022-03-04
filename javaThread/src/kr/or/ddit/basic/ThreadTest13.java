package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashMap;

/*
* 	10마리의 말들이 경주하는 경마 프로그램 작성하기
* 	말은 Horse라는 이름의 스레드 클래스로 작성하는데
* 	이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
*	그리고, 이 클래스에는 등수를 오름차순으로 처리할수있는 내부정렬기준이 있다.
*	(Compare 인터페이스 구현)
*
*	경기구간은 1~50구간으로 되어있다.
*	경기가 끝나면 등수 순으로 출력한다.
*	
*	경기가 진행 중일때는 중간중간에 말들의 위치를 아래와 같이 나타낸다.
*	
*	예)
*	01번말: -------->---------------------------------
*	02번말: ----------->------------------------------
*   ...
*   10번말: ----->------------------------------------
*   
*   
*/

public class ThreadTest13 {
	
	


	

	public static void main(String[] args) {
		
//		ArrayList<HashMap<String,String>> list1 = new ArrayList<HashMap<String,String>>();
//		HashMap<String,String> map2 = new HashMap<String,String>();
//		
//		for(int i=0; i<50; i++) {
//			map2 = new HashMap<String,String>();
//			map2.put("1번말","-");
//			map2.put("2번말","-");
//			map2.put("3번말","-");
//		}
//		System.out.print("1번말");
//		for(int i=0; i<=50; i++) {
//		System.out.print(map2.get("1번말"));
//		}
//		System.out.print("\n2번말");
//		for(int i=0; i<=50; i++) {
//		System.out.print(map2.get("2번말"));
//		}
//		System.out.print("\n3번말");
//		for(int i=0; i<=50; i++) {
//		System.out.print(map2.get("3번말"));
//		}
		
		
		DisplyCharacter1[] ths = new DisplyCharacter1[] {
				new DisplyCharacter1("1번말"),
				new DisplyCharacter1("2번말"),
				new DisplyCharacter1("3번말")
		};
		
		
		
		
		
		for(DisplyCharacter1 dc: ths) {
			dc.start();
		}
		
		//모든 사람의 출력이 끝날때까지 기다린다.
		for(DisplyCharacter1 dc: ths) {
			try {
				dc.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println();
		System.out.println("경기결과");
		System.out.println("순위: "+ DisplyCharacter1.setRank);
		

	}

}



//A~Z까지 출력하는 스레드
class DisplyCharacter1 extends Thread {
	//출력이 끝난 대로 이름이 추가될 변수
	public static String setRank ="";
	public String name;
	ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
	HashMap<String,String> map = new HashMap<String,String>();

	//생성자
	public DisplyCharacter1(String name) {
		super();
		this.name = name;
	}
//	for() {
//	String nameList[] = String name
//	}
	

	public void runlist() {
		
		
//		for(int i=0; i<50; i++) {
//			map = new HashMap<String,String>();
//			map.put("1번말","-");
//			map.put("2번말","-");
//			map.put("3번말","-");
//		}
//		for(int i=0; i<=50; i++) {
//		System.out.println("1번말"+map.get("1번말"));
//		System.out.println("2번말"+map.get("2번말"));
//		System.out.println("3번말"+map.get("3번말"));
//		}

	}
	
	
	@Override
	public void run() {
		
		
		
		
		for(int ch=0; ch<=50; ch++) {
//			if(name.equals("1번말")) {
//				 map.put("1번말",">");
//				 map.put("2번말","-");
//				 map.put("3번말","-");
//			}else if(name.equals("2번말")) {
//				 map.put("1번말","-");
//				 map.put("2번말",">");
//				 map.put("3번말","-");
//			}else if(name.equals("3번말")) {
//				 map.put("1번말","-");
//				 map.put("2번말","-");
//				 map.put("3번말",">");
//			}
//		
			
			
			//만약 name가 1번 말이면서 ch가 0번이면 >를 출력한다.

//				System.out.print(name);
//				for(int i=0; i<50; i++) {
//					//만약 i가 ch라면 > 출력
//					if(i == ch) {
//						System.out.print(">");
//					}else if(i != ch){
//						System.out.print("-");
//					}
//				}
//				System.out.println();
				

			
			if(name.equals("1번말")) {
				System.out.print(name);
				//- 50개 출력
				for(int i=0; i<50; i++) {
					//만약 i가 ch라면 > 출력
					if(i == ch) {
						System.out.print(">");
					}else {
						System.out.print("-");
					}
					
				}
				System.out.println();

			}
			

			if(name.equals("2번말")) {
				System.out.print(name);
				//- 50개 출력
				for(int i=0; i<50; i++) {
					//만약 i가 ch라면 > 출력
					if(i == ch) {
						System.out.print(">");
					}else {
						System.out.print("-");
					}
					
				}
				System.out.println();

			}
			

		
			
			if(name.equals("3번말")) {
				System.out.print(name);
				//- 50개 출력
				for(int i=0; i<50; i++) {
					//만약 i가 ch라면 > 출력
					if(i == ch) {
						System.out.print(">");
					}else {
						System.out.print("-");
					}
					
				}
				System.out.println();

			}
			
//			System.out.print("1번말");
//			for(int i=0; i<=50; i++) {
//			System.out.print(map.get("1번말"));
//			}
//			System.out.print("\n2번말");
//			for(int i=0; i<=50; i++) {
//			System.out.print(map.get("2번말"));
//			}
//			System.out.print("\n3번말");
//			for(int i=0; i<=50; i++) {
//			System.out.print(map.get("3번말"));
//			}
	
			
			try {
				
				//일시정지 값을 난수로 지정한다.
				Thread.sleep((int)(Math.random()*(500-200+1)+200));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		
		}
		System.out.println(name+"출력끝.....");
		//출력을 끝낸 순서대로 이름을 배치한다.
		DisplyCharacter1.setRank += name + " ";
		
		
		
	}
	
	

	
}