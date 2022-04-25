package cumtrip.main.dao;

import java.sql.SQLException;
import java.util.List;

import cumtrip.vo.ReplyVo;

public interface IReplyDao {
	
//	//댓글수정 - cont, redate
//	public int updateReply(ReplyVo vo)throws SQLException;
//	
//	//댓글삭제
//	public int deleteReply(int reply)throws SQLException;
	
	//댓글리스트
	public List<ReplyVo> replyList(int bonum)throws SQLException;
	
//	//댓글저장
//	public int insertReply(ReplyVo vo)throws SQLException;

	
}
