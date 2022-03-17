package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.ScanUtil;

public class JdbcTest03 {

//문제) LPROD_ID값을 2개를 입력 받아서 두 값들 중 작은 값부터 큰값사이의 자료들을 출력하시오
	
	
	public static void main(String[] args) {
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
			System.out.println("첫번째 값을 입력해주세요");
			int sc = ScanUtil.nextInt();
			System.out.println("두번째 값을 입력해주세요");
			int sc2 = ScanUtil.nextInt();
			
			//int min = Math.random()
			
			String sql;
			
			if(sc > sc2) {
				sql = "select *"
						+ " from LPROD"
						+ " where LPROD_ID >"+ sc2 +" and LPROD_ID <"+ sc;		
			}else {
				sql = "select *"
						+ " from LPROD"
						+ " where LPROD_ID >"+ sc +" and LPROD_ID <"+ sc2;
			}
		
			
			
			//4. Statement객체 생성 ==> 질의를 처리하는 객체생성
			stmt = conn.createStatement();

			//sql문을 db서버로 보내서 결과를 가져온다
			//	(실행할 sql문의 select문이기 때문에 결과가 resultSet에 저장되어 반환된다.)
			rs = stmt.executeQuery(sql);
			
			//6. 결과처리하기 ==> 한 레코드씩 화면에 출력하기
			// ResultSet의 저장된 데이터를 차례로 꺼내오려면 반복문과 next()메서드를 이용한다.
			System.out.println("===  쿼리문처리 결과  ===");
			
			
			
			
			while(rs.next()) {
				//포인터가 가리키는 곳의 자료를 가져오는 방법
				//형식1) rs.get 자료형이름 ("컬럼명")
				System.out.println("Lprod_ID: "+ rs.getInt("lprod_id"));
				//형식2) rs.get 자료형이름 ("컬럼번호") ==> 컬럼번호는 1번 부터시작
				System.out.println("Lprod_GU: "+ rs.getString(2));
				//형식3) rs.get 자료형이름 ("컬럼의 alias명")
				System.out.println("Lprod_NM: "+rs.getString(3));
				System.out.println("-----------------------------");
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
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
