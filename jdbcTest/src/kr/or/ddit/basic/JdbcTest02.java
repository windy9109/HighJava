package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import util.JDBCUtil;
import util.ScanUtil;

//문제) 사용자로 부터 LPROD_ID값을 입력받아서 입력한 값보다 LPROD_ID가 큰 자료들을 출력하시오. 

public class JdbcTest02 {
	
//	public static Map<String, Object> select01(int boardNo){
//		String sql = "select *"
//				+ " from LPROD"
//				+ " where LPROD_ID > ?";
//		
//		List<Object> param = new ArrayList<Object>();
//		param.add(boardNo);
//		
//		return JDBCUtil.selectOne(sql, param);
//	}

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
			
			
			//3. sql문 작성하기
			//String sql = "select * from lprod";

			System.out.println("값을 입력해주세요");
			int sc = ScanUtil.nextInt();
			String L = "LPROD";
			String sql = "select *"
					+ " from "+L
					+ " where LPROD_ID >"+ sc;


			
			
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
				System.out.println("Lprod_NM: "+rs.getString(3));
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
