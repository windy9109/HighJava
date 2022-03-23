package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.vo.BoardVo;

public class BoardDaoImpl implements BoardDao {
	
	private static BoardDaoImpl dao;
	private BoardDaoImpl() {}
	public static BoardDaoImpl getInstance() {
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}
	

	@Override
	public int insertBoard(Connection conn, BoardVo boardVo) throws SQLException {

		String sql="insert into JDBC_BOARD"
				+ " (BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CNT, BOARD_CONTENT)"
				+ " values((select NVL(max(BOARD_NO), 0)+1 FROM JDBC_BOARD)"
				+ "  , ?, ?, SYSDATE, ?, ?)";
		//글번호, 글제목, 작성자, 작성날짜, 조회수, 내용		
		//BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CNT, BOARD_CONTENT
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardVo.getBorad_title());
		pstmt.setString(2, boardVo.getMem_id());
		pstmt.setString(3, boardVo.getBorad_viewCount());
		pstmt.setString(4, boardVo.getContent());
		
		int cnt = pstmt.executeUpdate();
		if(pstmt != null) pstmt.close();
		
		return cnt;
	}
	
	
	

	@Override
	public int deleteBoard(Connection conn, int boardNo) throws SQLException {
		String sql = "delete from JDBC_BOARD where BOARD_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);
		
		int cnt = pstmt.executeUpdate();
		
		if(cnt>0) {
			System.out.println(boardNo+"게시물 삭제성공!");
		}else {
			System.out.println(boardNo+"은(는)없는 게시물이거나 삭제에 실패했습니다.");
		}
		
		return cnt;
	}

	@Override
	public int updateBoard(Connection conn, BoardVo boardVo) throws SQLException {
		String sql ="update JDBC_BOARD set "
				+ " BOARD_TITLE = ? , BOARD_CONTENT = ? where BOARD_NO =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(5, boardVo.getBorad_title());
		pstmt.setString(5, boardVo.getContent());
		pstmt.setInt(5, boardVo.getBorad_no());
		
		int cnt = pstmt.executeUpdate();
		if(cnt>0) {
			System.out.println("게시글 수정완료!");
		}else {
			System.out.println("회원정보 수정 실패~!");
		}
		return cnt;
	}

	@Override
	public int getcount(Connection conn, int boardNo) throws SQLException {
		String sql =" select count(*) cnt from JDBC_BOARD"
				+ " where BOARD_NO =? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);
		
		ResultSet rs = pstmt.executeQuery();
		int count = 0;
		if(rs.next()) {
			count = rs.getInt("cnt");
		}
		if(rs != null)rs.close();
		if(pstmt != null)pstmt.close();
		
		return count;
	}

	
	
	
	@Override
	public List<BoardVo> getAllView(Connection conn) throws SQLException {
		//글번호, 글제목, 작성자, 작성날짜, 조회수, 내용		
		//BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CNT, BOARD_CONTENT	
		List<BoardVo> boradVo = new ArrayList<BoardVo>();
		String sql = "select * from JDBC_BOARD";
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			BoardVo boardVo = new BoardVo(); //개의 레코드가 저장될 객체변수
			boardVo.setMem_id(rs.getString("BOARD_NO"));
			boardVo.setMem_id(rs.getString("BOARD_TITLE"));
			boardVo.setMem_id(rs.getString("BOARD_WRITER"));
			boardVo.setMem_id(rs.getString("BOARD_DATE"));
			boardVo.setMem_id(rs.getString("BOARD_CNT"));
			boardVo.setMem_id(rs.getString("BOARD_CONTENT"));
			
			boradVo.add(boardVo);
			
		}
		
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		
		
		return boradVo;
	}
	
	

}
