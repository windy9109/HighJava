import java.util.HashSet;
import java.util.Objects;

public class EqualHashCodeTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setNum(1); //콜스택영역 //p1에 있는 00번지의 heep에 찾아가서 실행하라는뜻 
		p1.setName("홍길동");
		
		Person p2 = new Person();
		p2.setNum(2);
		p2.setName("이순신");
		
		p2.setNum(1);
		p2.setName("홍길동");
	
		Person p3 = p1;
		
		System.out.println(p1 == p2); //번지가 다르므로 false가 됨 
		//p1==>Person@1eb44e46
		//p2==>Person@6504e3b2
		
		System.out.println(p1 == p3);
		System.out.println(p1.equals(p2)); //false
		System.out.println(p1.equals(p3)); //true
		
		
		HashSet<Person> testSet = new HashSet<Person>();
		
		testSet.add(p1);
		testSet.add(p2);
		testSet.add(p3);
		
		System.out.println("Set의 size: "+testSet.size());
		System.out.println("p1: "+p1.hashCode());
		System.out.println("p2: "+p2.hashCode());
		System.out.println("p3: "+p3.hashCode());
		
		/*
		 * - equals() ==> 두객체의 내용이 같은지 검사하는 메서드
		 * - hashCode() ==> 두 객체의 동일성을 검사하는 메서드
		 * HashSet, Hashtable, HashMap과 같이 Hash로 시작하는 컬렉션 객체들은
		 * 객체의 의미상의 동일성을 비교하기 위해서 equals()와 hashCode()메서드를 호출해서 비교한다.
		 * 그러므로, 객체가 같은지 여부를 결정하려면 equals()메서드 뿐만 아니라 
		 * hashCode()메서드도 재정의 해야한다.
		 * 
		*/
	
		
		System.out.println("p1==>"+p1);
		System.out.println("p2==>"+p2);
		System.out.println("p3==>"+p3);

		
	}

}


class Person{
	private int num; //heep의 주소값 00번지를 나타냄
	private String name;
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, num);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name) && num == other.num;
	}
	

//	@Override
//	public boolean equals(Object obj) {
//		if(this == obj) { //참조값(주소값)이 같은지검사
//			return true;
//		}
//		if(obj == null) { //null인 객체와 비교
//			return false;
//		}
//		//같은 유형의 클래스 인지 검사
//		if(this.getClass() != obj.getClass()) {
//			return false;
//		}
//		//매개변수값을 현재 객체 유형으로 형변환 한다.
//		Person that = (Person) obj;
//		//null과 not null을 비교한다면
//		if(this.name == null && that.name!=null) {
//			return false;
//		}
//		if(this.num==that.num && this.name == that.name) {
//			return true;
//		}
//		if(this.num == that.num&& this.name.equals(that.name)) {
//			return true;
//		}else {
//			return false;
//			
//		}
//	}
	
	
	
	
	
//	@Override
//	public String toString() {
//		return "Person [num=" + num + ", name=" + name + "]";
//	}
	
	
	
	
}