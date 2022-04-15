package cumtrip.detail.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.admin.dao.MainDao;
import cumtrip.vo.MiddleVO;

public class DetailDao {
	private static DetailDao dao;
	private DetailDao() {}
	public static DetailDao getInstance() {
		if(dao == null) dao = new DetailDao();
		return dao;
	}
	
	public MiddleVO seletectdetail(SqlMapClient smc, String midno) throws SQLException {
		
		
		return (MiddleVO)smc.queryForObject("middle.SqlMapClient smc", midno);
	}
}
