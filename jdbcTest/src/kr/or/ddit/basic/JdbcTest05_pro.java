package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 * Lprod테이블에 새로운 데이터를 추가하기
 * lprod_gu와 lprod_nm은 직접 입력받아서 처리하고,
 * lprod_id는 현재의 lprod_id중에서 제일 큰 값보다 1크게 한다.
 * 
 * 그리고 lprod_gu가 이미 등록되어있으면 다시 입력 받아서 처리한다.
 * 
*/

public class JdbcTest05_pro {

	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null; //보안수준이 낮은편 (내부 쿼리문에서 쓰는게 좋다.)
		PreparedStatement pstmt = null; //보안 수준이 높다
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			
//			String lprodGu;
//			String lprodNm;
//			
//
//				System.out.println("lprod_gu를 입력해주세요");
//				lprodGu = scan.next();
//				
//				System.out.println("lprod_nm을 입력해주세요");
//				lprodNm = scan.next();
	
				
	
				
				String sql1="select max(LPROD_ID) as maxnum FROM LPROD";
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql1);
				int maxNum = 0;
				
				if(rs.next()) {
					//컬럼의 alias가 없을때
//					maxNum = rs.getInt("max(LPROD_ID)"); //또는
//					maxNum = rs.getInt(1);
					
					//컬럼의 alias가 있을때
					maxNum = rs.getInt("maxnum");
				}
				maxNum++;
			//-------------------------------------------------------
			//그리고 lprod_gu가 이미 등록되어있으면 다시 입력 받아서 처리한다.
				
			String gu; //상품분류코드(lprod_gu)가 저장될 변수 선언
			int count = 0; //입력한 상품분류코드의 개수가 저장될 변수
			do{
				System.out.println("상품 분류코드 입력: ");
				gu = scan.next();
				String sql2 = "select count(*) as cnt from LPROD where LPROD_GU = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, gu);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
				if(count>0) {
					System.out.println("입력한 상품분류코드 "+gu+"는 이미 등록된 코드입니다.");
					System.out.println("다시입력하세요.");
				}
				
				
			}while(count>0); //중복되면 반복처리 되도록 한다.
				
			System.out.println("상품분류명 입력: ");
			String nm = scan.next();
			
			
			String sql3="insert into LPROD(LPROD_ID, LPROD_GU, LPROD_NM)"
					+ "	values(?,?,?)";
			
			
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1,maxNum);
			pstmt.setString(2,gu);
			pstmt.setString(3,nm);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println("등록성공~");
			}else {
				System.out.println("등록실패~");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close(); }catch(SQLException e){}
			if(stmt!=null) try {stmt.close(); }catch(SQLException e){}
			if(pstmt!=null) try {pstmt.close(); }catch(SQLException e){}
			if(conn!=null) try {conn.close(); }catch(SQLException e){}
			
		}
		

	}

}








