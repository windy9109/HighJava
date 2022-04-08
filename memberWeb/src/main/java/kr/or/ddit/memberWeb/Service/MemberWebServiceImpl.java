package kr.or.ddit.memberWeb.Service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.memberWeb.Dao.MemberWebDao;
import kr.or.ddit.memberWeb.Dao.MemberWebDaoImpl;
import kr.or.ddit.memberWeb.VO.MemberWebVO;

public class MemberWebServiceImpl implements MemberWebService{
	
	private static MemberWebServiceImpl service;
	private MemberWebDao dao;
	

	private MemberWebServiceImpl() {
		dao = MemberWebDaoImpl.getInstance();
	}
	
	public static MemberWebServiceImpl getInstance() {
		if(service == null) service = new MemberWebServiceImpl();
		
		return service;
	}



	@Override
	public List<MemberWebVO> selectAll() {
		List<MemberWebVO> list = null;
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
