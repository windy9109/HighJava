package kr.or.ddit.basic;

/*
 * 3개의 스레드가 각자 알파벳을 A~Z까지 출력하는데
 * 출력을 끝낸 순서대로 결과를 나타내는 프로그램 작성하기.
 * 
*/

public class ThreadTest12 {

	public static void main(String[] args) {
		DisplyCharacter[] ths = new DisplyCharacter[] {
				new DisplyCharacter("홍길동"),
				new DisplyCharacter("이순신"),
				new DisplyCharacter("강감찬")
		};
		
		for(DisplyCharacter dc: ths) {
			dc.start();
		}
		
		//모든 사람의 출력이 끝날때까지 기다린다.
		for(DisplyCharacter dc: ths) {
			try {
				dc.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println();
		System.out.println("경기결과");
		System.out.println("순위: "+ DisplyCharacter.setRank);
		
		

	}

}



//A~Z까지 출력하는 스레드
class DisplyCharacter extends Thread {
	//출력이 끝난 대로 이름이 추가될 변수
	public static String setRank ="";
	public String name;

	//생성자
	public DisplyCharacter(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public void run() {
		for(char ch='A'; ch<='Z'; ch++) {
			System.out.println(name+"의 출력문자: "+ ch);
			
			try {
				
				//일시정지 값을 난수로 지정한다.
				Thread.sleep((int)(Math.random()*(500-201+1)+201));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		
		}
		System.out.println(name+"출력끝.....");
		//출력을 끝낸 순서대로 이름을 배치한다.
		DisplyCharacter.setRank += name + " ";
		
		
		
	}
	
}