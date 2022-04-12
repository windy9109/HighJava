package cumtrip.admin.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.vo.MemberVO;
import cumtrip.vo.MiddleVO;

public class PlaceDao {
	private static PlaceDao dao;
	private PlaceDao() {}
	public static PlaceDao getInstance() {
		if(dao == null) dao = new PlaceDao();
		return dao;
	}
	
	public int insertspace(SqlMapClient smc, MiddleVO vo) throws SQLException{
		int result = 0;
		Object temp = null;
		temp = smc.insert("middle.insertspace");
		if(temp == null) {
			result = 1;
		}else {
			result =0;
		}
		
		return result;
	}
}
