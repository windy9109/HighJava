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


public class JdbcTest6_pro {
	private Scanner scan = new Scanner(System.in);
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public static void main(String[] args) {
		
		new JdbcTest6_pro().start();
		
		

	}
	
	//메뉴를 출력하고 선택한 작업번호를 반환하는 메서드
	private int displayMenu() {
		System.out.println(" *  -------------------------\n"
				+ " *  	== 작업 선택 ==\r\n"
				+ " *   1. 자료추가		\n"
				+ " *   2. 자료수정		\n"
				+ " *   3. 자료삭제		\n"
				+ " *   4. 전체 자료 출력	\n"
				+ " *   5. 자료수정2	\n"
				+ " *   0. 작업 끝...\n"
				+ " *   \n"
				+ " * -------------------------\n"
				+ " * 원하는 작업번호 >");
		int sc = scan.nextInt();
		return sc;
	}
	
	
	
	public int start() {
		
		while(true) {
			int chice = displayMenu();
			switch(chice) {
			case 1: insertMember();//추가
				break;
			case 2: updateMember();//수정
				break;
			case 3: deleteMember();//삭제
				break;
			case 4: displayMember();//전체출력
				break;
			case 5: updateMember2();//전체출력
				break;
			case 0: //작업끝
				System.out.println("작업끝...");
				System.exit(0);
				break;
			default: 
				System.out.println("번호를 잘못입력했습니다. 다시입력해주세요");
			}
		}

	}
	
	//회원정보를 삭제하는 메서드
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원정보를 입력하세요.");
		System.out.println("삭제할 회원 ID >> ");
		String memId = scan.next();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println(memId+"회원삭제성공!");
			}else {
				System.out.println(memId+"은(는) 없는 회원이거나 삭제에 실패했습니다.");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			disConnect();
		}
		
	}
	
	
	//전체 회원 정보를 수정하는 메서드
	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요...");
		System.out.println("회원 ID>> ");
		String memId = scan.next();
		
		int count = getMemberCount(memId);
		if(count == 0) {
			System.out.println(memId+"는 없은 회원 입니다.");
			System.out.println("수정작업을 마칩니다.");
			return;
		}
		System.out.println();
		System.out.println("수정할 내용을 입력하세요");
		System.out.println("새로운 비밀번호 >> ");
		String newMemPass = scan.next();
		
		System.out.println("새로운 회원이름");
		String newMemName = scan.next();

		System.out.println("새로운 회원 전화번호");
		String newMemTel = scan.next();
		
		System.out.println("새로운 회원주소");
		String newMemAddr = scan.next();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "update mymember set "
					+ " mem_pass =?, mem_name =? ,"
					+ " mem_tel= ?, mem_addr = ?"
					+ " where mem_id =? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newMemPass);
			pstmt.setString(2, newMemName);
			pstmt.setString(3, newMemTel);
			pstmt.setString(4, newMemAddr);
			pstmt.setString(5, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println(memId+"회원정보 수정 완료~!!");
			}else {
				System.out.println(memId+"회원정보 수정 실패~!!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
	}
	
	
	//회원정보를 수정하는 메서드 => 원하는 항목만 선택해서 수정하기
	private void updateMember2() {
		System.out.println();
		System.out.println("수정할 회원 아이디를 입력하세요");
		String memId = scan.next();
		int count = getMemberCount(memId);
		if(count == 0) {
			System.out.println(memId+"는 없은 회원 입니다.");
			System.out.println("수정작업을 마칩니다.");
			return;
		}
		System.out.println("수정을 원하는 항목을 입력해주세요.");
		System.out.println("1. 비밀번호  2.회원이름  3. 전화번호  4. 회원주소");
		int input = scan.nextInt();
		switch(input) {
		case 1: updateMember2_pass(memId);//비밀번호
			break;
		case 2: updateMember2_name(memId);//회원이름
			break;
		case 3: updateMember2_tel(memId);//전화번호
			break;
		case 4: updateMember2_addr(memId);//회원주소
			break;
		default: updateMember2();
		}
		
	}
	
	
	private void updateMember2_pass( String memId ) {
		System.out.println("수정할 회원 패스워드를 입력하세요");
		String newmemPass = scan.next();
		try {
			conn = DBUtil.getConnection();
			
			String sql = "update mymember set mem_pass = ? where mem_id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newmemPass);
			pstmt.setString(2, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt >0) {
				System.out.println("수정성공~");
			}else {
				System.out.println("수정실패~");		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}
	
	private void updateMember2_name( String memId ) {
		System.out.println("수정할 회원 이름을 입력하세요");
		String newmemName = scan.next();
		try {
			conn = DBUtil.getConnection();
			
			String sql = "update mymember set mem_pass = ? where mem_id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newmemName);
			pstmt.setString(2, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt >0) {
				System.out.println("수정성공~");
			}else {
				System.out.println("수정실패~");		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}
	
	
	private void updateMember2_tel( String memId ) {
		System.out.println("수정할 회원 전화번호를 입력하세요");
		String newmemTel = scan.next();
		try {
			conn = DBUtil.getConnection();
			
			String sql = "update mymember set mem_tel = ? where mem_id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newmemTel);
			pstmt.setString(2, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt >0) {
				System.out.println("수정성공~");
			}else {
				System.out.println("수정실패~");		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}
	
	
	private void updateMember2_addr( String memId ) {
		System.out.println("수정할 회원 주소를 입력하세요");
		String newmemAddr = scan.next();
		try {
			conn = DBUtil.getConnection();
			
			String sql = "update mymember set mem_addr = ? where mem_id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newmemAddr);
			pstmt.setString(2, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt >0) {
				System.out.println("수정성공~");
			}else {
				System.out.println("수정실패~");		
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}
	
	//회원 전체정보를 출력하는 메서드
	private void displayMember() {
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("ID   비밀번호 	회원이름		전화번호 		회원주소");
		System.out.println("-----------------------------");
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from mymember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String memId = rs.getString("mem_Id");
				String memPass = rs.getString("mem_pass");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				System.out.println(memId+"\t"+memPass+"\t"+memName+"\t"+memTel+"\t"+memAddr);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		
	}
	
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보 입력");
		
		//자료추가에서 '회원 id'는 중복되지 않는다.
		//(중복되면 다시 입력받는다.)
		int count = 0; //입력한 회원 id의 개수가 저장될 변수
		String memId; //회원 ID가 저장될 변수
		do {
			System.out.println("회원ID >> ");
			memId = scan.next();
			count = getMemberCount(memId);
			if(count>0) {
				System.out.println(memId+"는 이미 등록된 id입니다.");
				System.out.println("다른 회원 id를 입력하세요");
			}
			
		}while(count>0);
		
		System.out.println("비밀번호 >>");
		String memPass = scan.next();
		
		System.out.println("회원이름 >>");
		String memName = scan.next();
		
		System.out.println("전화번호>>");
		String memTel = scan.next();
		
		scan.nextLine(); //입력버퍼비우기
		System.out.println("회원주소>>");
		String memAddr = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into mymember"
					+ " (mem_id, mem_name, mem_pass, mem_tel, mem_addr)"
					+ " values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memPass);
			pstmt.setString(3, memName);
			pstmt.setString(4, memTel);
			pstmt.setString(5, memAddr);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(" 회원정보 추가성공~~~ ");
			}else {
				System.out.println(" 회원정보 추가 실패!!! ");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		
	}
	
	//회원 ID를 매개변수로 받아서 해당 회원 id의 개수를 반환하는 메서드
	private int getMemberCount(String memId) {
		int count = 0;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select count(*) cnt from mymember"
					+ " where mem_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return count;
	}
	
	//사용했던 자원을 반납하는 메서드
	private void disConnect() {
		if(rs!=null) try {rs.close(); }catch(SQLException e){}
		if(stmt!=null) try {stmt.close(); }catch(SQLException e){}
		if(pstmt!=null) try {pstmt.close(); }catch(SQLException e){}
		if(conn!=null) try {conn.close(); }catch(SQLException e){}
	}
	
	

	
	

}
