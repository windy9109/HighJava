package xml; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.DocumentBuilder; 
import org.w3c.dom.Document; 
import org.w3c.dom.NodeList; 
import org.w3c.dom.Node; 
import org.w3c.dom.Element; 
import java.io.File; 

public class DOMtest { 
	
	public static void main(String argv[]) { 
		
		try { 
			File fXmlFile = new File("d:/d_other/staff.xml"); 
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); 
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); 
			Document doc = dBuilder.parse(fXmlFile); 

			//*DOM 파서 구현
			// DOM방식은 메모리에 모두 로드 후 파싱
			
//			1. 처음 XML문서를 메모리에 모두 로드한 후 값을 읽는다.
//			2. XML문서가 메모리에 모두 로드되어있기 때문에 노드의 검색, 수정, 구조변경등이 빠르고 용이하다.
//			3. 직관적이고 SAX보다 파싱하기 단순하다.
			
			

			doc.getDocumentElement().normalize(); 
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());  //루트 엘리먼트의 이름을 출력
			NodeList nList = doc.getElementsByTagName("staff");  //문서에서 staff 노드를 전부 찾아 배열로 돌려줌.
			
			
			System.out.println("----------------------------"); 
			for (int i = 0; i < nList.getLength(); i++) { 
				//Node nNode = nList.item(temp); //nList의 노드를 추출 
				System.out.println("\nCurrent Element :" + nList.item(i).getNodeName()); //감싸고있는 i번째 staff tag를 출력
				
				//if (nNode.getNodeType() == Node.ELEMENT_NODE) { 
					Element eElement = (Element) nList.item(i); //nNode의 i번째 Element를 eElement에 넣는다.
					System.out.println("Staff id : " + eElement.getAttribute("id")); //i번째 eElement의 속성값 id를 찾아 출력함
					System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());  //i번째 eElement의 TagName이 "firstname"인것의 0번째 내용을 출력함   
					System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());  //감싸고있는 staff tag들의 내용이 모두 0번째만 존재하므로 .item(0)만 출력하게 한다.
					System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent()); 
					System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent()); 
					//}
				} 
			} catch (Exception e) { 
				//e.printStackTrace(); 
				}
		
		
		
		} 
	
		
	}


