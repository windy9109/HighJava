package kr.or.ddit.memberWeb.Dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.memberWeb.VO.MemberWebVO;
import kr.or.ddit.util.SqlMapClientFactory;


public class MemberWebDaoImpl implements MemberWebDao{

	private SqlMapClient client;
	private static MemberWebDao dao;
	
	private MemberWebDaoImpl() { 
		client = SqlMapClientFactory.getSqlMapClient();
		
	}
	
	
	public static MemberWebDao getInstance() {
		if(dao == null) dao = new MemberWebDaoImpl();
		return dao;
	} 
	

	@Override
	public List<MemberWebVO> selectAll()throws SQLException {
//		List<MemberWebVO> list = null;
//			
//		list = client.queryForList("memberList.selectList");
//		
//		return list;
		
		
		return client.queryForList("memberList.selectList");
		
		
//		List<MemberWebVO> list = null;
//		try {
//			list = client.queryForList("memberList.selectList");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
		
		
		
	}

}
