package board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import board.vo.BoardVo;

//dao의 interface

public interface BoardDao {
	
	
	public int insertBoard(Connection conn, BoardVo boardVo ) throws SQLException;
	public int deleteBoard(Connection conn, int boardNo ) throws SQLException;
	public int updateBoard(Connection conn, BoardVo boardVo ) throws SQLException;
	public int getcount(Connection conn, int boardNo ) throws SQLException;
	public List<BoardVo> getAllView(Connection conn ) throws SQLException;
	
	
	
	

}
