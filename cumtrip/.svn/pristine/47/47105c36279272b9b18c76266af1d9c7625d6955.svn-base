package cumtrip.admin.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.vo.A_adminVO;
import cumtrip.vo.BoardVo;
import cumtrip.vo.MemberVO;

public class MemberDao {
	private static MemberDao dao;
	private MemberDao() {}
	public static MemberDao getInstance() {
		if(dao == null) dao = new MemberDao();
		return dao;
	}
	
	public List<MemberVO> selectMember(SqlMapClient smc) throws SQLException{
		List<MemberVO> list = null;
		
		list = smc.queryForList("member.selectMember");
		
		return list;
	}
	public MemberVO selectMemberone(SqlMapClient smc, String email) throws SQLException{
		MemberVO vo = null;
		
		vo = (MemberVO) smc.queryForObject("member.selectMemberone", email);
		
		return vo;
		
	}
	public int updatemember(SqlMapClient smc, MemberVO vo) throws SQLException{
		int result = 0;
		
		result =  smc.update("member.updatemember",vo);
		
		return result;
		
	}
	public int updatemember2(SqlMapClient smc, String email) throws SQLException{
		int result = 0;
		
		result =  smc.update("member.updatemember2",email);
		
		return result;
		
	}
	public List<BoardVo> qselectall(SqlMapClient smc) throws SQLException{
		List<BoardVo> list = null;
		
		list = smc.queryForList("member.qselectall");
		
		return list;
		
	}
	public BoardVo selectoneq(SqlMapClient smc, String qno) throws SQLException{
		BoardVo vo = null;
		
		vo = (BoardVo)smc.queryForObject("board.selectoneq", qno);
		
		return vo;
	}
	public int uploadquestion(SqlMapClient smc, A_adminVO vo) throws SQLException{
		int result = 0; 
		Object temp = null;
		
		temp = smc.insert("board.uploadquestion", vo);
		
		if(temp== null) {
			result = 1;
		}
		
		return result;
	}

}
