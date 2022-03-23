package board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import board.dao.BoardDao;
import board.dao.BoardDaoImpl;
import board.vo.BoardVo;
import kr.or.ddit.util.DBUtil;

public class BoardServiceImpl implements BoardService {

	private BoardDao dao;
	
	private static BoardServiceImpl service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(service == null) service = new BoardServiceImpl();
		
		return service;
	}

	@Override
	public int insertBoard(BoardVo boardVo) {
		Connection conn = null;
		int cnt = 0;
		
		try {
			conn = DBUtil.getConnection();
			cnt = dao.insertBoard(conn, boardVo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}finally {
			if(conn != null) try { conn.close(); }catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DBUtil.getConnection();
			cnt = dao.deleteBoard(conn, boardNo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}finally {
			if(conn != null) try { conn.close(); }catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DBUtil.getConnection();
			cnt = dao.updateBoard(conn, boardVo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}finally {
			if(conn != null) try { conn.close(); }catch(SQLException e) {}
		}
		return cnt;
	}
	
	

	@Override
	public int getcount(int boardNo) {
		Connection conn = null;
		int cnt =0;
		try {
			conn = DBUtil.getConnection();
			cnt = dao.getcount(conn, boardNo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}finally {
			if(conn != null) try { conn.close(); }catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public List<BoardVo> getAllView() {
		Connection conn = null;
		List<BoardVo> boardList = null;
		try {
			conn = DBUtil.getConnection();
			boardList = dao.getAllView(conn);
		} catch (SQLException e) {
			boardList = null;
		}finally {
			if(conn != null) try { conn.close(); }catch(SQLException e) {}
		}
		
		return boardList;
	}
	
	
	
	
	
	
	
	

}
