package cumtrip.admin.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.admin.dao.MemberDao;
import cumtrip.admin.dao.PlaceDao;
import cumtrip.util.SqlMapClientFactory;
import cumtrip.vo.MemberVO;
import cumtrip.vo.MiddleVO;

public class PlaceService {
	private PlaceDao dao;
	private static PlaceService service;
	
	private PlaceService() {
		dao = PlaceDao.getInstance();
	}
	public static PlaceService getInstance() {
		if(service == null) service = new PlaceService();
		return service;
	}
	
	public int insertspace(Map<String,Object> map){
		SqlMapClient smc = null;
		int result = 0;
		
		try {
		smc = SqlMapClientFactory.getsqlMapClient();
		result = dao.insertspace(smc, map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public List<MiddleVO> selectallspace(){
		SqlMapClient smc = null;
		List<MiddleVO> list  = null;
		
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			list = dao.selectallspace(smc);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
	}
	public MiddleVO selectonespace(String midno){
		SqlMapClient smc = null;
		MiddleVO vo  = null;
		
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			vo = dao.selectonespace(smc, midno);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return vo;
	}
}
