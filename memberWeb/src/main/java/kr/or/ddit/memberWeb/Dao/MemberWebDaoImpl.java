package kr.or.ddit.memberWeb.Dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.memberWeb.VO.MemberWebVO;


public class MemberWebDaoImpl implements MemberWebDao{

	private SqlMapClient client;
	private static MemberWebDaoImpl dao;
	private MemberWebDaoImpl() { }
	
	public static MemberWebDaoImpl getInstance() {
		if(dao == null) dao = new MemberWebDaoImpl();
		return dao;
	} 
	
	
	@Override
	public List<MemberWebVO> selectAll() throws SQLException {
		
		return client.queryForList("memberList.selectList");
	}

}
