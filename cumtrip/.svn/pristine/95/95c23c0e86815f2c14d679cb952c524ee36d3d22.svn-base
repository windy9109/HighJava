package cumtrip.admin.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.admin.dao.MainDao;
import cumtrip.admin.dao.PlaceDao;
import cumtrip.util.SqlMapClientFactory;
import cumtrip.vo.MiddleVO;

public class MainService {
	private MainDao dao;
	private static MainService service;
	SqlMapClient smc = null;
	private MainService() {
		dao = MainDao.getInstance();
		smc = SqlMapClientFactory.getsqlMapClient();
	}
	public static MainService getInstance() {
		if(service == null) service = new MainService();
		return service;
	}
	
	public List<String> spacemain(){
		List<String> list = null;
		
		try {
		
		list = dao.spacemain(smc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<String> restaurntmain(){
		List<String> list = null;
		try {
			list = dao.restaurantmain(smc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<String> staymain(){
	
		List<String> list = null;
		
		try {
			list = dao.staymain(smc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
