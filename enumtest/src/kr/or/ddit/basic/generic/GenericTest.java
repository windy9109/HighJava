package kr.or.ddit.basic.generic;

/*
  Generic 클래스를 만드는 방법
  
  - 제네릭 타입글자는 보통 한글자로 사용한다.
  
  
  형식)
   class 클래스명<제네릭타입글자>{ 
  	  private 제네릭타입글자 변수명;  //변수 선언에 제네릭을 사용할 경우
   	...
   	
     제네릭타입글자 메서드명(){ //반환값이 있는 메서드에서 사용하기
       ...
       return 값;
     }
	
	void 메서드명(제네릭타입글자 변수명){ //메서드의 매개변수에 제네릭 사용하기 
		...
	  }
   
   }
   
   -- 제네릭타입글자 --
   T ==> Type의 약자
   K ==> Key
   V ==> Value
   E ==> Element
   
  
*/


class Mygeneric<T>{
	private T value;
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
}





class NonGenericCalss{
	private Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
}



public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NonGenericCalss ng1 = new NonGenericCalss();
		ng1.setValue("가나다라");
		
		NonGenericCalss ng2 = new NonGenericCalss();
		ng2.setValue(100);
		
		String rtnNg1 = (String)ng1.getValue(); //명시적 형변환
		System.out.println("문자열 반환값 rtnNg1: "+rtnNg1);
		
		Integer irtnNg2 = (Integer)ng2.getValue();
		System.out.println("정수형 반환 값 irtnNg2:"+irtnNg2);
		System.out.println("-------------------------------");
		
		
		Mygeneric<String> mg1 = new Mygeneric<>(); //String만 사용하는 객체됨
		mg1.setValue("안녕하세요.");
		Mygeneric<Integer> mg2 = new Mygeneric<>(); //String만 사용하는 객체됨
		mg2.setValue(500);
		
		//제네릭을 사용한 클래스에서 데이터를 꺼냇을때
		//형변환없이 사용할수있다는 장점이 있다.
		String rtnMg1 = mg1.getValue();
		Integer irtnMg2 = mg2.getValue();
		
		
		System.out.println("제네릭문자열 반환값: "+rtnMg1);
		System.out.println("제네릭정수형 반환값: "+irtnMg2);
		
		// -------------------------------------------------
		//제네릭을 사용했을때와 사용하지 않았을때의 오류가 발생하는 시점이 서로 다른 경우의 예
		
		
		//문법적으로는 문제가 없음
//		NonGenericCalss test = new NonGenericCalss();
//		test.setValue("우리나라");
//		
		//실행 단계에서 오류가 발생한다.
//		Integer num =(Integer)test.getValue();
//		System.out.println("num = "+num);
		
		
		
		//제네릭을 사용하면 에러를 미리 찾을수있는 장점이있다.
//		Mygeneric<String> test2 = new Mygeneric<>();
//		test2.setValue("대한민국");
//		
		//컴파일 단계에서 오류가 발생한다.
//		Integer num2 = test2.getValue(); 
//		System.out.println("num2 = "+num2);
		
		
		
		
		
	}

}









