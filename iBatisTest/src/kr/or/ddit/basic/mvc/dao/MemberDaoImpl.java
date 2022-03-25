package kr.or.ddit.basic.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.basic.mvc.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao{

//	private static MemberDaoImpl single;
//	
//	public static MemberDaoImpl getInstance() {
//		if(single == null) single = new MemberDaoImpl();
//		
//		return single;
//	}
	
	//1번
	private static MemberDaoImpl dao;
	
	//2번
	private MemberDaoImpl() {}
	
	//3번
	public static MemberDaoImpl getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}

	@Override
	public int insertMember(SqlMapClient smc, MemberVO memVo) throws SQLException {
		return 0;

	}

	@Override
	public int deletMenber(SqlMapClient smc, String memId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(SqlMapClient smc, MemberVO memVo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> getAllMember(SqlMapClient smc) throws SQLException {
		

		//결과가 여러개일 때 형식) 
		// smc.queryForList("namespace값.id값, 파라미터클래스");
		// ==> 이 메서드는 여러개의 레코드 각각을 VO에 담은 후 이 VO데이터를
		// 		List에 추가해주는 작업을 자동으로 수행한다.
		// 반환값 ==> VO객체가 저장된 List객체
		
		List<MemberVO> memist = smc.queryForList("lprod.getAllLprod");
		
		for(MemberVO Mem : memist ) {
			
			
			System.out.print("ID : "+Mem.getMem_id());
			System.out.print("PASS : "+Mem.getMem_pass());
			System.out.print("NAME : "+Mem.getMem_name());
			System.out.print("TEL : "+Mem.getMem_tel());
			System.out.print("addr : "+Mem.getMem_addr());
			System.out.println();
		}
		
		
		
		return memist;
	}

	@Override
	public int getMemberCount(SqlMapClient smc, String memId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember2(SqlMapClient smc, Map<String, String> paramMap) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	



}
