package kr.or.ddit.basic.mvc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import kr.or.ddit.basic.Log4jTest;
import kr.or.ddit.basic.mvc.dao.IMemberDao;
import kr.or.ddit.basic.mvc.dao.MemberDaoImpl;
import kr.or.ddit.basic.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberServiceImpl implements IMemberService {
	
	private static final Logger logger = Logger.getLogger(MemberServiceImpl.class);
	
	

	private IMemberDao dao;

	private static MemberServiceImpl service;
	
	private MemberServiceImpl() {
		//dao = new MemberDaoImpl();
		dao = MemberDaoImpl.getInstance();
	}

	public static MemberServiceImpl getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}

	
	
	
	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		int cnt = 0; //반환값변수
		try {
			conn = DBUtil3.getConnection();
			logger.info("connection객체 생성...");
			cnt = dao.insertMember(conn, memVo);
			logger.info("insert 작업성공!!");
		} catch (SQLException e) {
			logger.error("insert작업오류:"+ e);
			cnt =0;
			e.printStackTrace();
		}finally {
			if(conn != null) try { 
				conn.close(); 
				logger.info("connection객체 반납...");			
			}catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int deletMenber(String memId) {
		Connection conn = null;
		int cnt = 0; //반환값변수
		try {
			conn = DBUtil3.getConnection();
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
			conn = DBUtil3.getConnection();
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
			conn = DBUtil3.getConnection();
			count = dao.getMemberCount(conn, memId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	
	@Override
	public int updateMember2(Map<String, String> paramMap) {
		Connection conn = null;
		int cnt = 0; //반환값변수
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.updateMember2(conn, paramMap);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}finally {
			if(conn != null) try { conn.close(); }catch(SQLException e) {}
		}
		return cnt;
	}



	
	

	
}










