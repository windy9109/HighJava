package kr.or.ddit.memberWeb.Service;

import java.sql.Connection;
import java.util.List;

import kr.or.ddit.memberWeb.VO.MemberWebVO;

public interface MemberWebService {
	
	public List<MemberWebVO> selectAll();

}
