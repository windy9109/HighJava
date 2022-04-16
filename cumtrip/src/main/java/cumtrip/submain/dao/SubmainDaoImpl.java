package cumtrip.submain.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.util.SqlMapClientFactory;
import cumtrip.vo.PhotoVO;

//mapper접근 - SqlMapClient객체가 필요
//dao클래스 객체 생성 - 리턴 - service에서 사용
public class SubmainDaoImpl implements ISubmainDao{
	private SqlMapClient client;
	private static ISubmainDao dao;
	
	private SubmainDaoImpl() {
		client = SqlMapClientFactory.getsqlMapClient();
	}
	
	public static ISubmainDao getInstance() {
		if(dao == null) dao = new SubmainDaoImpl();
		return dao;
	}

	@Override
	public List<PhotoVO> tPhoto() throws SQLException {
		return client.queryForList("sub.tPhoto"); // namespace.id
	}

	@Override
	public List<PhotoVO> fPhoto() throws SQLException {
		return client.queryForList("sub.fphoto");
	}
	
	

}
