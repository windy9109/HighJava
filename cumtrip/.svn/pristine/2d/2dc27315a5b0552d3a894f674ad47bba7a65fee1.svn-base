package cumtrip.admin.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.admin.dao.MemberDao;
import cumtrip.util.SqlMapClientFactory;
import cumtrip.vo.A_adminVO;
import cumtrip.vo.BoardVo;
import cumtrip.vo.MemberVO;

public class MemberService {
	private MemberDao dao;
	private static MemberService service;
	SqlMapClient smc = null;
	private MemberService() {
		dao = MemberDao.getInstance();
		smc = SqlMapClientFactory.getsqlMapClient();
	}
	public static MemberService getInstance() {
		if(service == null) service = new MemberService();
		return service;
	}
	
	public List<MemberVO> selectMember(){
		List<MemberVO> list = null;
		
		try {
		list = dao.selectMember(smc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public MemberVO selectMemberone(String email){
		MemberVO vo = null;
		
		try {
		vo  = dao.selectMemberone(smc, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
	public int updatemember( MemberVO vo){
		int result = 0;
		try {
			result = dao.updatemember(smc, vo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	public int updatemember2( String email){
		int result = 0;
		try {
			result = dao.updatemember2(smc, email);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	public List<BoardVo> qselectall(){
		List<BoardVo> list = null;
		
		try {
			list = dao.qselectall(smc);
		} catch (SQLException e) {
			// TODO: handle exception
		}return list;
		
	}
	public BoardVo selectoneq(String qno) {
		BoardVo vo = null;
		
		try {
			vo = dao.selectoneq(smc, qno);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return vo;
	}
	public int uploadquestion(A_adminVO vo) {
		int result = 0;
		
		try {
			result = dao.uploadquestion(smc, vo);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
		
	}
}
