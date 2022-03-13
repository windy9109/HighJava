package xml;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

class SAXSampleParser{
	
//	*파싱방법
//	클래스 선언에서 DefaultHandler를 상속받아 아래 함수들을 오버라이드 하여 사용해야 한다.

	  // 문서의 시작시 발생하는 이벤트 입니다.
	  public void startDocument() throws SAXException {
	    super.startDocument();
	  }
	  
	  // 문서의 끝

	  public void endDocument() throws SAXException {

	    super.endDocument();

	    System.out.println("End Document");

	  }
	  
	  

	  // 파서가 xml을 읽는 도중 엘리먼트 시작테그를 만날 때마다 발생하는 이벤트

	  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

	 //qName 엘리먼트의 이름

	// 엘리먼트 속성

	    for (int i = 0; i < attributes.getLength(); i++) {

	      //System.out.println(“Attribute: ” + attributes.getQName(i) + “=” + attributes.getValue(i));

	    }

	  }



	  // 엘리먼트 끝

	  public void endElement(String uri, String localName, String qName) throws SAXException {

	    //System.out.println(“End Element: ” + qName);

	  }



	  // 엘리먼트 이벤트 중간중간 텍스트를 만났을때 발생

	  public void characters(char ch[], int start, int length) throws SAXException {

	    //System.out.println(“Character: ” + new String(ch, start, length));

	  }
	
	
}

public class test03 {


	  
	  
	
	public static void main(String[] args) {
		
		//*SAX방식
		//SAX는 순차적으로 읽어가며 파싱
		
//		1. XML문서를 순차적으로 읽어들이면서 노드가 열리고 닫히는 과정에서 이벤트가 발생한다.
//		2. XML문서를 메모리에 전부 로딩하고 파싱하는것이 아니라서 메모리 사용량이 적고 단순히 읽기만 할 때 속도가 빠름.
//		3. 발생한 이벤트를 핸들링하여 변수에 저장,활용하는 것이기 때문에 복잡하고, 노드 수정이 어렵다.
//		4. DOM보다 어렵다.


		
		try {
			
			
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			File xmlFile = new File("d:/d_other/staff.xml");
			parser.parse(xmlFile, new SAXSampleParser());

			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
