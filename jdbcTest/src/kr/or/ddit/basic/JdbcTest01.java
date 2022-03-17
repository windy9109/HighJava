package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest01 {

	
	/*	
	//JDBC(Java DataBase Connectivity)라이브러리를 이용한 DB자료 처리하기
	  
	- 처리순서
	1. 드라이버 로딩 ==> 라이브러리를 사용할 수 있게 메모리로 읽어 들이는 방법
	 	Class.forName("oracle.jdbc.driver.OracleDriver");
	 	(JDBC API버전 4이상에서는 getConnection()메서드에서 자동으로 로딩해주기때문에 생략할수 있다. 그렇지만 생략하지 않고 사용할 예정임)
	 
	2. DB에 접속하기 ==> 접속이 완료되면 Connection객체가 반환된다.
		DriverManager.getConnection()메서드를 이용한다.
	
	3. 질의 ==> SQL문장을 DB서버로 보내서 결과를 얻어온다.
		(Statement객체 또는 PreparedStatement객체를 이용하여 작업한다.)
	
	4. 결과 처리 ==> 질의 결과를 받아서 원하는 작업을 수행한다.
		1) SQL문이 select일 경우
			==> select한 결과가 ResultSet객체에 저장되어 반환된다.
		2) SQL문이 select문이 아닐경우(insert, update, delete)
	 		==> 정수값 즉, 해당 명령이 실행에 성공한 레코드 수를 반환한다.
	 	
	5. 사용했던 자원을 반납하기 ==> close()메서드 이용
	
*/	
	
	public static void main(String[] args) {
			//DB작업에 필요한 객체변수 선언
		//Connection,Statement > java.sql 선택해서 가져오기
		Connection conn = null; 
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//1.드라이버로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DB연결 ==>  객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe" //url
					, "LSG9" //user
					, "java" // password
					);
			//3. sql문 작성하기
			//String sql = "select * from lprod";
			String sql = "select LPROD_ID,"
					+ " LPROD_GU,"
					+ " LPROD_NM as nm from LPROD";
			
			
			//4. Statement객체 생성 ==> 질의를 처리하는 객체생성
			stmt = conn.createStatement();
			
			//sql문을 db서버로 보내서 결과를 가져온다
			//	(실행할 sql문의 select문이기 때문에 결과가 resultSet에 저장되어 반환된다.)
			rs = stmt.executeQuery(sql);
			
			
			//6. 결과처리하기 ==> 한 레코드씩 화면에 출력하기
			// ResultSet의 저장된 데이터를 차례로 꺼내오려면 반복문과 next()메서드를 이용한다.
			System.out.println("===  쿼리문처리 결과  ===");
			
			//rs.next() ==> ResultSset객체의 데이터가 가리키는 포인터를 다음번째 위치로 이동시키고 
			//그 곳에 데이터가 있으면 true, 없으면 false를 반환한다.				
			while(rs.next()) {
				//포인터가 가리키는 곳의 자료를 가져오는 방법
				//형식1) rs.get 자료형이름 ("컬럼명")
				System.out.println("Lprod_ID: "+ rs.getInt("lprod_id"));
				//형식2) rs.get 자료형이름 ("컬럼번호") ==> 컬럼번호는 1번 부터시작
				System.out.println("Lprod_GU: "+ rs.getString(2));
				//형식3) rs.get 자료형이름 ("컬럼의 alias명")
				System.out.println("Lprod_NM: "+rs.getString("nm"));
				System.out.println("-----------------------------");
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){ 
			e.printStackTrace(); 
		}finally {
			//7.자원반납
			if(rs!=null)try {	rs.close(); } catch (SQLException e) { }
			if(stmt!=null)try {	stmt.close(); } catch (SQLException e) { }
			if(conn!=null)try {	conn.close(); } catch (SQLException e) { }
		}
		

	}

}
