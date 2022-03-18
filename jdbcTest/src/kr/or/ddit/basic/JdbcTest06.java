package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 * 회원을 관리하는 프로그램을 작성하시오.
 * (MYMEMBER 테이블 이용)
 * 
 *  아래 메뉴의 기능을 모두 구현하시오(CRUD기능 구현하기)
 * 
 *  메뉴예시 )
 *  -------------------------
 *  	== 작업 선택 ==
 *   1. 자료추가		--> insert (c)
 *   2. 자료수정		--> update (r)
 *   3. 자료삭제		--> delete (d)
 *   4. 전체 자료 출력	--> select (r)
 *   0. 작업 끝...
 *   
 * -------------------------
 * 
 * 조건)
 * 1) 자료추가에서 '회원ID'는 중복되지 않는다.(중복되면 다시 입력받는다.)
 * 2) 자료삭제는 '회원ID'를 입력받아서 처리한다. 
 * 3) 자료수정에서 '회원ID'는 변경되지않는다.
 * 
 * 
*/


public class JdbcTest06 {
	Scanner scan = new Scanner(System.in);
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public int start() {
		System.out.println(" *  -------------------------\n"
				+ " *  	== 작업 선택 ==\r\n"
				+ " *   1. 자료추가		\n"
				+ " *   2. 자료수정		\n"
				+ " *   3. 자료삭제		\n"
				+ " *   4. 전체 자료 출력	\n"
				+ " *   0. 작업 끝...\n"
				+ " *   \n"
				+ " * -------------------------");
		int input = scan.nextInt(); 
		
		switch(input) {
		case 1: return insert(); 
		case 2: update(); break;
		case 3: delete(); break;
		case 4: select(); break;
		case 0: System.out.println("시스템을 종료합니다.");
				System.exit(0);
		default: start();
		}
		return start();
	}
	
	
	
	
	public int insert(){
		
		try {
			conn = DBUtil.getConnection();
			int count = 0;
			String MemId;
			do {
				System.out.println("등록할 아이디를 입력해주세요.");
				MemId = scan.next();
				String subSql1 = "select count(*) as cnt from MYMEMBER where MEM_ID = ?";
				pstmt = conn.prepareStatement(subSql1);
				pstmt.setString(1, MemId);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
				if(count>0) {
					System.out.println("입력한 아이디는 등록된 아이디입니다. 다시입력해주세요.");
				}
				
			}while(count>0);// 중복되면 반복처리
			System.out.println("등록할 이름을 입력해주세요.");
			String MemName = scan.next();
			System.out.println("등록할 비밀번호를 입력해주세요.");
			String MemPass = scan.next();
			System.out.println("등록할 전화번호를 입력해주세요.");
			String MemTel = scan.next();
			System.out.println("등록할 주소를 입력해주세요.");
			String MemAddr = scan.next();
			String sql1="insert into MYMEMBER ( MEM_ID, MEM_NAME, MEM_PASS, MEM_TEL, MEM_ADDR )"
					+ " values(?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql1);
			
			pstmt.setString(1, MemId);
			pstmt.setString(2, MemName);
			pstmt.setString(3, MemPass);
			pstmt.setString(4, MemTel);
			pstmt.setString(5, MemAddr);
			
			
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
			if(pstmt!=null) try {pstmt.close(); }catch(SQLException e){}
			if(conn!=null) try {conn.close(); }catch(SQLException e){}
		}

		return start();
		
	}
	
	
	
	public int update(){
		
		try {
			conn = DBUtil.getConnection();
			int count = 0;
			String MemId;
			do {
				System.out.println("수정할 아이디를 입력해주세요.");
				MemId = scan.next();
				String subSql1 = "select count(*) as con from MYMEMBER where MEM_ID = ?";
				pstmt = conn.prepareStatement(subSql1);
				pstmt.setString(1, MemId);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					count = rs.getInt("con");
				}
				if(count == 0) {
					System.out.println("등록되지 않은 아이디입니다. 다시입력해주세요.");
				}
				
			}while(count == 0);// 없으면 반복처리
			System.out.println("수정할 이름을 입력해주세요.");
			String MemName = scan.next();
			System.out.println("수정할 비밀번호를 입력해주세요.");
			String MemPass = scan.next();
			System.out.println("수정할 전화번호를 입력해주세요.");
			String MemTel = scan.next();
			System.out.println("수정할 주소를 입력해주세요.");
			String MemAddr = scan.next();
			String sql2="update MYMEMBER set MEM_NAME=?, MEM_PASS=?, MEM_TEL=?, MEM_ADDR=? where MEM_ID = ?";
			
			pstmt = conn.prepareStatement(sql2);
			
			
			pstmt.setString(1, MemName);
			pstmt.setString(2, MemPass);
			pstmt.setString(3, MemTel);
			pstmt.setString(4, MemAddr);
			pstmt.setString(5, MemId);
			
			int cnt2 = pstmt.executeUpdate();
			if(cnt2>0) {
				System.out.println("등록성공~");
			}else {
				System.out.println("등록실패~");
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close(); }catch(SQLException e){}
			if(pstmt!=null) try {pstmt.close(); }catch(SQLException e){}
			if(conn!=null) try {conn.close(); }catch(SQLException e){}
		}

		return start();
		
		
	}
	
	
	public int delete(){
	
		try {
			conn = DBUtil.getConnection();
			System.out.println("삭제할 아이디를 입력해주세요.");
			String MemId = scan.next();

			String sql2="delete from MYMEMBER where MEM_ID = ?";
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, MemId);
			
			int cnt2 = pstmt.executeUpdate();
			if(cnt2 == 0) {
				System.out.println("삭제성공~");
			}else {
				System.out.println("삭제실패~");
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close(); }catch(SQLException e){}
			if(pstmt!=null) try {pstmt.close(); }catch(SQLException e){}
			if(conn!=null) try {conn.close(); }catch(SQLException e){}
		}

		return start();
		
	}
	
	
	void select(){
		try {
			conn = DBUtil.getConnection();
			
			String sql1="select * FROM MYMEMBER";
			
			pstmt = conn.prepareStatement(sql1);
			//pstmt.setString(0, sql1);
				
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getString(5)+"\t");
				System.out.println();
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close(); }catch(SQLException e){}
			if(pstmt!=null) try {pstmt.close(); }catch(SQLException e){}
			if(conn!=null) try {conn.close(); }catch(SQLException e){}
		}

		
	}
	
	public static void main(String[] args) {
		
		new JdbcTest06().start();
		
		

	}

}
