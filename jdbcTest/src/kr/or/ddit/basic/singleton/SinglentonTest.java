package kr.or.ddit.basic.singleton;

public class SinglentonTest {

	public static void main(String[] args) {
		
		//private로 선언했으므로 생성자가 보이지 않는다.
		//따라서 아래와 같이 외부에서 new명령어를 사용할수없다.
		//MySingleton test1 = new MySingleton();
		
		MySingleton test2 = MySingleton.getInstance();
		MySingleton test3 = MySingleton.getInstance();
		
		
		
		System.out.println("test2 => "+test2);
		System.out.println("test3 => "+test3);
		
		//결과
		//객체가 1번만 생성됨
//		생성자입니다. 
//		test2 => kr.or.ddit.basic.singleton.MySingleton@6fb554cc
//		test3 => kr.or.ddit.basic.singleton.MySingleton@6fb554cc
		
		//결과 => true
		//똑같은 참조값을 사용하기 때문에
		System.out.println(test2 == test3);
		
		//결과 => true
		//똑같은 참조값을 사용하기 때문에
		System.out.println(test2.equals(test3));
		
		
		//결과
		//싱글톤 클래스의 메서드 호출입니다...
		test2.displayTest();
		

	}

}
