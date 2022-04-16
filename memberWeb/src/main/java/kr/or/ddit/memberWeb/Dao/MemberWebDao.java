package kr.or.ddit.memberWeb.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.memberWeb.VO.MemberWebVO;

public interface MemberWebDao {

	
	public List<MemberWebVO> selectAll() throws SQLException;
	
	
}
