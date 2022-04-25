package cumtrip.admin.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapException;

import cumtrip.admin.dao.PlaceDao;
import cumtrip.admin.dao.RestaurantDao;
import cumtrip.util.SqlMapClientFactory;
import cumtrip.vo.MiddleVO;

public class RestaurantService {
	private RestaurantDao dao;
	private static RestaurantService service;
	SqlMapClient smc = null;
	private RestaurantService() {
		dao = RestaurantDao.getInstance();
		smc = SqlMapClientFactory.getsqlMapClient();
	}
	public static RestaurantService getInstance() {
		if(service == null) service = new RestaurantService();
		return service;
	}
	
	public int insertrestaurant(Map<String,Object> map){
	
		int result = 0;
		
		try {
	
		result = dao.insertrestaurant(smc, map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int insertphoto(Map<String,String> map){
		int result = 0;
		
		try {
		result = dao.insertphoto(smc, map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public List<MiddleVO> selectallrestaurant(){
		List<MiddleVO> list  = null;
		
		try {
			list = dao.selectallrestaurant(smc);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
		
	}
	public MiddleVO selectonerestaurant(String midno){
		MiddleVO vo  = null;
		
		try {
			vo = dao.selectonerestaurant(smc,midno);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return vo;
		
	}
	public int updaterestaurant(MiddleVO vo) {
		int result = 0;
		
		try {
			result = dao.updaterestaurant(smc,vo);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
		
	}
}
