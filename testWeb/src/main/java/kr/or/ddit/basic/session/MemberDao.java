package kr.or.ddit.basic.session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.ddit.util.DBUtil3;

public class MemberDao {

	private static MemberDao dao;
	private MemberDao() {}
	
	public static MemberDao getInstance() {
		if(dao == null) dao = new MemberDao();
			return dao;
	}
	
	public MemberVO getMember(MemberVO memVo)throws SQLException{
		MemberVO returnMemberVo = null;
		Connection conn = DBUtil3.getConnection();
		/*
		 * select * from mymember
			where mem_id='입력한ID' and mem_pass='입력한 pass';
			
			위의 쿼리문을 처리한 결과를 반환하도록 구현한다.
		 * 
		*/
		
		
		
		String sql = "select * from mymember where mem_id=? and mem_pass=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memVo.getMem_id());
		pstmt.setString(2, memVo.getMem_pass());

		
		
		
		return returnMemberVo;
	}
	
}
