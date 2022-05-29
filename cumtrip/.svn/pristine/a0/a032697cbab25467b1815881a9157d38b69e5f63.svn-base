package cumtrip.main.service;

import java.util.List;
import java.util.Map;

import cumtrip.vo.BoardVo;
import cumtrip.vo.MemberVO;

public interface IBoardService {
	
	//리스트출력
	public List<BoardVo> selectList( Map<String, Object> map);

	//전체글 갯수 가져오기
	public int totalCount(Map<String,String> map);
	
	//페이지 정보 구하기
	public Map<String, Object> getPageInfo(int page, String type, String word);
	
	//글삭제
	public int deleteBorad(BoardVo vo);
	
	
	//업데이트
	public int updateHit(BoardVo vo);

	//1:1문의 글쓰기
	public Object insertQnaMypage(BoardVo vo);

	
	
}
