package board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import board.vo.BoardVo;

public interface BoardService {

	
	
	public int insertBoard(BoardVo boardVo );
	public int deleteBoard(int boardNo );
	public int updateBoard(BoardVo boardVo, int boardNo );
	public int getcount(int boardNo );
	public List<BoardVo> serch(String word );
	public List<BoardVo> getAllView();
	
	//상세페이지
	public BoardVo getboard(int boardNo );
	
	//조회수
	public int setCountIncrement(int boardNo );

	
}
