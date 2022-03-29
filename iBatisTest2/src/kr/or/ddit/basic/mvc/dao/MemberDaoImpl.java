package kr.or.ddit.basic.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.basic.mvc.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao{

	
	//1번
	private static MemberDaoImpl dao;
	
	//2번
	private MemberDaoImpl() {}
	
	//3번
	public static MemberDaoImpl getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}

	@Override
	public int insertMember(SqlMapClient smc, MemberVO memVo) throws SQLException {
		int cnt =0;
		Object obj = smc.insert("member.insertMember", memVo);
		if(obj == null) cnt =1;
		return cnt;

	}

	@Override
	public int deletMenber(SqlMapClient smc, String memId) throws SQLException {
		int cnt = smc.delete("member.deleteMember", memId);
		return cnt;
	}

	@Override
	public int updateMember(SqlMapClient smc, MemberVO memVo) throws SQLException {
		return smc.update("member.updateMember", memVo);
	}

	@Override
	public List<MemberVO> getAllMember(SqlMapClient smc) throws SQLException {
		

		//결과가 여러개일 때 형식) 
		// smc.queryForList("namespace값.id값, 파라미터클래스");
		// ==> 이 메서드는 여러개의 레코드 각각을 VO에 담은 후 이 VO데이터를
		// 		List에 추가해주는 작업을 자동으로 수행한다.
		// 반환값 ==> VO객체가 저장된 List객체
		
		return smc.queryForList("member.getAllMember");
	}

	@Override
	public int getMemberCount(SqlMapClient smc, String memId) throws SQLException {
		return (int)smc.queryForObject("member.getMemberCount",memId);
	}

	
	@Override
	public int updateMember2(SqlMapClient smc, Map<String, String> paramMap) throws SQLException {
		return smc.update("member.updateMember2", paramMap);
	}

	
	
//	@Override
//	public int updateMember2(SqlMapClient smc, Map<String, String> paramMap) throws SQLException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
	
	
	
	



}
