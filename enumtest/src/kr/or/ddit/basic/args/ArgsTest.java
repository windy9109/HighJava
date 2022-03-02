package kr.or.ddit.basic.args;

public class ArgsTest {
	//메서드를 호출할때 사용되는 데이터의 개수가 실행될 때마다 다를때...
	
	// 1. 배열을 이용한 메서드
	// 예) 매개변수로 받은 정수들의 합계를 구하는 메서드
	// (이 정수들의 개수는 상황에 따라 다르다.)
	
	public int sumArr(int[] data) {
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	
	
	//가변형 인수 ==> 메서드의 매개변수의 개수가 실행될때마다 다를때 사용한다.
	// - 가변형 인수에 사용되는 매개변수는 메서드 안에서 배열처리된다.
	// - 가변형 인수는 한가지 자료형만 사용할수있다.
	public int sumArg(int...data) {
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	
	//가변형 인수와 일반적인 인수를 같이 사용할 경우에는 가변형 인수를 제일 뒤쪽에 배치해야한다.
	public String sumArg2(String name, int...data) {
		int sum =0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return name +"씨 총점: "+ sum;
	}
	
	
	
	
//	public void ttt(int a) {
//		
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArgsTest test = new ArgsTest();
		
		int[] nums = {100, 200, 300};
		int[] num2;
//		num2 = {100, 200, 300}; => 불가능하므로 
//		System.out.println(test.sumArr({100, 200, 300}));도 불가능	
		
		num2 = new int[] {100,200,300}; //가능
//		System.out.println(test.sumArr(new int [] {1,2,3,4,5})); 가능
		
		System.out.println(test.sumArr(nums));
		System.out.println(test.sumArr(new int [] {1,2,3,4,5}));
		
//		int k =0;
//		test.ttt(k);
//		test.ttt(300);
		
		System.out.println(test.sumArg(100,200,400));
		System.out.println(test.sumArg(1,2,3,4,5));
		System.out.println(test.sumArg2("홍길동",1,2,3,4,5,6));
		
		
	}

}
