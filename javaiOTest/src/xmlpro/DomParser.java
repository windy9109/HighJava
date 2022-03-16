package xmlpro;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * DOM은 Node의 계층 구조로 이루어져 있다. 
 * - 각 노드는 부모와 children을 가질 수 있다.
 * 
 * Element는 node의 특정 타입(Node.ELEMENT_NODE)
 * - 태그로 적은 노드들을 지칭
 * - Node.ELEMENT_NODE 외에도, 주석의 타입인 COMMENT_NODE와 전체 document tree를 표현하는 Node.DOCUMENT_NODE도 존재
 * - 주석이나 text node와 같은 것들은 태그로 표현된 것이 아니므로 element가 아니다.
 * 
 * Node는 태그 노드와 텍스트 노드 전체를 가리키고, 
 * Element는 텍스트 노드를 제외한 태그만 가리킨다. 
 */

public class DomParser {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// XML 문서
		File XmlFile = new File("D:/d_other/sample.xml");
		
		// XML 문서 파싱
		
		// 1. DocumentBuilderFactory : 파싱을 하는 파서 객체를 생성하기 위한 추상 클래스
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
		
		// 2. DocumentBuilder : 여러 종류의 parse() 메서드를 제공하는 추상 클래스, 이 클래스의 parse() 메서드를 호출하면 파싱을 실시한다.
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();  
		
		// 3. parse() 메서드 : 파싱 실시
		Document document = documentBuilder.parse(XmlFile);  // Document : SAX와 다르게 파싱을 처리한 결과를 저장하는 클래스

		
		// root 구하기
		Element root = document.getDocumentElement();
		
		// root의 속성
		System.out.println(root.getNodeName() + " : " + root.getAttribute("name"));
		NodeList childeren = root.getChildNodes();  // root의 자식 노드 목록 get
		
		for (int i = 0; i < childeren.getLength(); i++) {
			Node node = childeren.item(i);
			
			if (node.getNodeType() == Node.ELEMENT_NODE) {  // 해당 노드의 종류 판정(Element일 때)
				Element ele = (Element) node;
				
				String nodeName = ele.getNodeName();  // 노드의 이름 구하는 메서드
				System.out.println("\nnode name: " + nodeName);
				
				if (nodeName.equals("교수님")) {  // 노드 이름이 "교수님"일 경우
					System.out.println("node attribute: " + ele.getAttribute("name"));  //노드의 어트리뷰트를 구하는 메서드
					
					// 이름이 "교수님"인 노드의 자식노드는 <name>abc</name> 형식 ==> getTextContent() 메서드 사용
					System.out.println(ele.getElementsByTagName("전화번호").item(0).getTextContent());  //자식노드가 1개이므로 for문 없이 item(0)
					
				} else if (nodeName.equals("학생")) {  // 노드이름이 "학생"일 경우
					System.out.println("node attribute: " + ele.getAttribute("name"));
					
					// 이름이 "학생"인 노드의 자식노드는 <name id = "abc"></name> 형식 ==> getAttribute()메서드 사용
					NodeList childeren2 = ele.getChildNodes();  
					
					for (int j = 0; j < childeren2.getLength(); j++) {
						Node node2 = childeren2.item(j);  // 자식노드가 여러개이므로 for문 사용하여 item(j)
						
						if (node2.getNodeType() == Node.ELEMENT_NODE) { 
							Element ele2 = (Element) node2;
							
							String nodeName2 = ele2.getNodeName();  
							System.out.println(nodeName2 + " : " + ele2.getAttribute("id"));
						}
						
					}
					
				}
				
			}
			
		}
		
	}
}