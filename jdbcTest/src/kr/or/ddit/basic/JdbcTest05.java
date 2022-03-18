package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * Lprod테이블에 새로운 데이터를 추가하기
 * lprod_gu와 lprod_nm은 직접 입력받아서 처리하고,
 * lprod_id는 현재의 lprod_id중에서 제일 큰 값보다 1크게 한다.
 * 
 * 그리고 lprod_gu가 이미 등록되어있으면 다시 입력 받아서 처리한다.
 * 
*/

public class JdbcTest05 {

	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","LSG9","java" );
			
			String lprodGu;
			String lprodNm;
			

				System.out.println("lprod_gu를 입력해주세요");
				lprodGu = scan.next();
				
				System.out.println("lprod_nm을 입력해주세요");
				lprodNm = scan.next();
	
				
	
				
				String sql0="select LPROD_GU from LPROD";
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql0);
				while(rs.next()) {
					if( lprodGu != rs.getString(1) ) {
						break;
					}
				}
			
			
			String sql="insert into LPROD(LPROD_ID, LPROD_GU, LPROD_NM)"
					+ "	values(((select max(LPROD_ID) FROM LPROD)+1),?,?)";
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,lprodGu);
			pstmt.setString(2,lprodNm);
			
			int cnt = pstmt.executeUpdate();
			System.out.println("반환값: "+cnt);
			
			
		} catch (Exception e) {
			System.out.println("이미등록된 산업입니다.");
		}finally {
			if(rs!=null) try {rs.close(); }catch(SQLException e){}
			if(stmt!=null) try {stmt.close(); }catch(SQLException e){}
			if(pstmt!=null) try {pstmt.close(); }catch(SQLException e){}
			if(conn!=null) try {conn.close(); }catch(SQLException e){}
			
		}
		

	}

}








