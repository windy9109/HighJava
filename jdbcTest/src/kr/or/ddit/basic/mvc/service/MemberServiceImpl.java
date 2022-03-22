package kr.or.ddit.basic.mvc.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import kr.or.ddit.basic.mvc.dao.IMemberDao;
import kr.or.ddit.basic.mvc.dao.MemberDaoImpl;
import kr.or.ddit.basic.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil3;

public class MemberServiceImpl implements IMemberService {

	private IMemberDao dao;

	
	public MemberServiceImpl() {
		dao = new MemberDaoImpl();
	}

	
	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		int cnt = 0; //반환값변수
		try {
			conn = DBUtil.getConnection();
			cnt = dao.insertMember(conn, memVo);
		} catch (SQLException e) {
			cnt =0;
			e.printStackTrace();
		}finally {
			if(conn != null) try { conn.close(); }catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int deletMenber(String memId) {
		Connection conn = null;
		int cnt = 0; //반환값변수
		try {
			conn = DBUtil.getConnection();
			cnt = dao.deletMenber(conn, memId);
		} catch (SQLException e) {
			cnt =0;
			e.printStackTrace();
		}finally {
			if(conn != null) try { conn.close(); }catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		Connection conn = null;
		int cnt = 0; //반환값변수
		try {
			conn = DBUtil.getConnection();
			cnt = dao.updateMember(conn, memVo);
		} catch (SQLException e) {
			cnt =0;
			e.printStackTrace();
		}finally {
			if(conn != null) try { conn.close(); }catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		Connection conn = null;
		List<MemberVO> memList = null;

		try {
			conn = DBUtil3.getConnection();	
			memList = dao.getAllMember(conn);
			
	
			
		} catch (SQLException e) {
			memList = null;
		}finally {
			if(conn != null) try { conn.close(); }catch(SQLException e) {}
		}
		
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		Connection conn = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			count = dao.getMemberCount(conn, memId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	
	public int updateMember2( MemberVO memVo, int update) {
		Connection conn = null;
		int cnt = 0; //반환값변수
		try {
			conn = DBUtil.getConnection();
			cnt = dao.updateMember2(conn, memVo, update);
		} catch (SQLException e) {
			cnt =0;
			e.printStackTrace();
		}finally {
			if(conn != null) try { conn.close(); }catch(SQLException e) {}
		}
		return cnt;
		
	}
	
}










