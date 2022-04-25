package cumtrip.admin.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.admin.dao.RestaurantDao;
import cumtrip.admin.dao.StayDao;
import cumtrip.util.SqlMapClientFactory;
import cumtrip.vo.RoomVO;
import cumtrip.vo.StayVO;

public class StayService {
	private StayDao dao;
	private static StayService service;
	SqlMapClient smc = null;
	private StayService() {
		dao = StayDao.getInstance();
		smc = SqlMapClientFactory.getsqlMapClient();
	}
	public static StayService getInstance() {
		if(service == null) service = new StayService();
		return service;
	}
	
	public int insertstay(StayVO vo){
	
		int result= 0;
		
		try {
		
		result = dao.insertstay(smc, vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public String selectstayno(Map<String,String> map) {
		String stayno = null;
		
		try {
			stayno = dao.selectstayno(smc, map);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return stayno;
	}
	public int insertroom(Map<String,String> map) {
		int result= 0;
		
		try {
		result = dao.insertroom(smc, map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public List<StayVO> selectallstay(){
		List<StayVO> list = null;
		
		
		try {
			list = dao.selectallstay(smc);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
		
	}
	public int updatestay(StayVO vo ) {
		int result = 0; 
		try {
			result = dao.updatestay(smc, vo);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public List<RoomVO> selectroom(String stayno){
		List<RoomVO> list = null;
		
		try {
		 list = dao.selectroom(smc, stayno);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
	}
	public int updateroom(Map<String,String> map) {
		int result = 0;
		
		try {
			 result = dao.updateroom(smc, map);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
	}
	public StayVO selectonestay(String stayno) {
		StayVO vo = null;
		
		try {
			 vo = dao.selectonestay(smc, stayno);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return vo;
	}
}
