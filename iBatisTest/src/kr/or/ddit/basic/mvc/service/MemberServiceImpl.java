package kr.or.ddit.basic.mvc.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.basic.mvc.dao.IMemberDao;
import kr.or.ddit.basic.mvc.dao.MemberDaoImpl;
import kr.or.ddit.basic.mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {

	private IMemberDao dao;

	private static MemberServiceImpl service;
	
	private MemberServiceImpl() {
		//dao = new MemberDaoImpl();
		dao = MemberDaoImpl.getInstance();
	}

	public static MemberServiceImpl getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletMenber(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> getAllMember() {
		
		List<MemberVO> memList = null;
		
		try {
			//1-1문자 인코딩 케릭터셋 설정
			Charset charset = Charset.forName("utf-8");
			//1-2환경 설정파일을 읽어올 스트림객체 생성
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/iBatisTest/config/sqlMapConfig.xml");
		
		//1-3. 위에서 생성한 스트림 객체를 이용하여 환경설정 파일을 읽어서 실행한다.
		//iBatis를 처리할 객체가 반환된다.
		SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
		
		memList = dao.getAllMember(smc);
		

		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

	
}










