package kr.or.ddit.basic.mvc.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.basic.mvc.dao.IMemberDao;
import kr.or.ddit.basic.mvc.dao.MemberDaoImpl;
import kr.or.ddit.basic.mvc.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class MemberServiceImpl implements IMemberService {

	private IMemberDao dao;
	private SqlMapClient smc;
	

	//1번
	private static MemberServiceImpl service;
	
	// 생성자 ==> 2번 
	private MemberServiceImpl() {
		//dao = new MemberDaoImpl();
		dao = MemberDaoImpl.getInstance();
		smc = SqlMapClientFactory.getSqlMapClient();
	}

	// 3번
	public static MemberServiceImpl getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		int cnt = 0;
		try {
			cnt = dao.insertMember(smc, memVo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return cnt;
	}

	@Override
	public int deletMenber(String memId) {
		int cnt = 0;
		try {
			
			cnt = dao.deletMenber(smc, memId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		int cnt = 0;
		try {
			
			cnt = dao.updateMember(smc, memVo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		
		List<MemberVO> memList = null;
		
		try {
			
			
//			//1-1문자 인코딩 케릭터셋 설정
//			Charset charset = Charset.forName("utf-8");
//			//1-2환경 설정파일을 읽어올 스트림객체 생성
//			Reader rd = Resources.getResourceAsReader("kr/or/ddit/iBatisTest/config/sqlMapConfig.xml");
//		
//		//1-3. 위에서 생성한 스트림 객체를 이용하여 환경설정 파일을 읽어서 실행한다.
//		//iBatis를 처리할 객체가 반환된다.
//		SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
//			
//		
		memList = dao.getAllMember(smc);
		

		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		int cnt = 0;
		try {
			
			cnt = dao.getMemberCount(smc, memId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;

	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		int cnt = 0;
		try {
			
			cnt = dao.updateMember2(smc, paramMap);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}


	
	

	
}










