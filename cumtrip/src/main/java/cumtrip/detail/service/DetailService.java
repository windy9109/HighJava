package cumtrip.detail.service;


import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.admin.service.MainService;
import cumtrip.detail.dao.DetailDao;
import cumtrip.util.SqlMapClientFactory;
import cumtrip.vo.MiddleVO;

public class DetailService {

	private DetailDao dao;
	private static DetailService service;
	
	private DetailService() {
		dao = DetailDao.getInstance();
	}
	public static DetailService getInstance() {
		if(service == null) service = new DetailService();
		return service;
	}
	
	public MiddleVO seletectdetail(String midno) {
		SqlMapClient smc = null;
		MiddleVO vo  = null;
		
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			vo = dao.
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return vo;
		
	}
	
	
}
