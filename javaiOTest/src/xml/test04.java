package xml;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


// 출저: https://sangwoo0727.github.io/java/JAVA-29_SAXParser/


//*SAX방식
//SAX는 순차적으로 읽어가며 파싱

//1. XML문서를 순차적으로 읽어들이면서 노드가 열리고 닫히는 과정에서 이벤트가 발생한다.
//2. XML문서를 메모리에 전부 로딩하고 파싱하는것이 아니라서 메모리 사용량이 적고 단순히 읽기만 할 때 속도가 빠름.
//3. 발생한 이벤트를 핸들링하여 변수에 저장,활용하는 것이기 때문에 복잡하고, 노드 수정이 어렵다.
//4. DOM보다 어렵다.



public class test04 {
	public static void main(String[] args) {
		
		File file = new File("d:/d_other/staff2.xml");
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		try {
			SAXParser parser = factory.newSAXParser();
			PeopleSaxHandler handler = new PeopleSaxHandler();
			parser.parse(file, handler);
			
			List<Person> list = handler.getPersonList();
			
			for(Person p:list) {
				System.out.println(p);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
	}

}



class PeopleSaxHandler extends DefaultHandler{
	
	//파싱한 사람객체를 넣을 리스트
	private List<Person> personList;
	//파싱한 사람 객체
	private Person person;
	//character 메소드에서 저장할 문자열 변수
	private String str;
	
	public PeopleSaxHandler() {
		personList = new ArrayList<>();
	}
	
	public void startElement(String uri, String localName, String name, Attributes att) {
		//시작 태그를 만났을 때 발생하는 이벤트
		if(name.equals("person")) {
			person = new Person();
			personList.add(person);
		}
	}
	public void endElement(String uri, String localName, String name) {
		//끝 태그를 만났을 때,
		if(name.equals("age")) {
			person.setAge(Integer.parseInt(str));
		}else if(name.equals("name")) {
			person.setName(str);
		}else if(name.equals("gender")) {
			person.setGender(str);
		}else if(name.equals("role")) {
			person.setRole(str);
		}
	}
	public void characters(char[] ch, int start, int length) {
		//태그와 태그 사이의 내용을 처리
		str = new String(ch,start,length);
	}
    public List<Person> getPersonList(){
		return personList;
	}
	public void setPersonList(List<Person> personList) {
		this.personList=personList;
	}
}





class Person {
	private int age;
	private String name;
	private String gender;
	private String role;
	public Person() {
	};
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "이름:"+name+" 나이:"+age+" 성별:"+gender+" 직책:"+role+"\n";
	}
}
