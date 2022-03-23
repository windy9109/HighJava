package board.service;

import java.util.List;

import board.vo.BoardVo;

public interface BoardService {

	
	
	public int insertBoard(BoardVo boardVo );
	public int deleteBoard(int boardNo );
	public int updateBoard(BoardVo boardVo );
	public int getcount(int boardNo );
	public List<BoardVo> serch(String word );
	public List<BoardVo> getAllView();
	
	
	
}
