package test;

public class EnumTest {
	
	//열거형 출력하기
	
	//방법1
	public enum Season{봄, 여름,가을, 겨울};
	
	//방법2
	public enum Season2{
		봄1(1,"봄이 옵니다"),
		여름2(2,"여름이 옵니다"),
		가을3(3,"가을이 옵니다"),
		겨율4(4,"겨울이 옵니다"); //세미콜론 반드시
	
		//'값들'이 저장될 변수 선언
		private String span;
		private int num;
		
		//생성자
		private Season2(int num, String months){
			this.num = num;
			this.span = months;
					
		}

		public String getSpan() {
			return span;
		}

		public int getNum() {
			return num;
		}
	
	}
	




	public static void main(String[] args) {
		Season pro = Season.valueOf("봄");
		Season pro2 = Season.가을;
		
		System.out.println(pro.name());
		System.out.println(pro2.name());
		
		System.out.println(pro.ordinal());
		System.out.println(pro2.ordinal());
		
		
		for(Season2 time: Season2.values()) {
			System.out.println(time);
			System.out.println(time.getSpan());
			System.out.println(time.getNum());
		}
		
		

	}

}
