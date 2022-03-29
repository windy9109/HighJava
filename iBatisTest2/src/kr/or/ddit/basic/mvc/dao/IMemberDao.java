package kr.or.ddit.basic.mvc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.basic.mvc.vo.MemberVO;


/**
 * 
 *  * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성해서
 * Service에 전달하는 Dao의 interface
 * 
 * 메서드하나가 DB와 관련된 작업 1개를 수행하도록 작성한다.
 * 
 * @author PC-10
 *
 */


public interface IMemberDao {
	/**
	 * 
	 * MemberVo에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param conn  	java.sql.Connection객체
	 * @param memVo		DB에 insert할 자료가 저장된 MemberVO객체
	 * @return			INSERT작업성공 1, INSERT 작업실패:0
	 * @throws SQLException
	 */
	public int insertMember(SqlMapClient smc, MemberVO memVo) throws SQLException;
	
	
	
	/**
	 * 회원 ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
	 * @param conn Connection 객체
	 * @param memId 삭제할 회원 ID
	 * @return	작업성공 1, 작업실패 0
	 * @throws SQLException
	 */
	public int deletMenber(SqlMapClient smc, String memId) throws SQLException;
	
	
	
	/**
	 * MemberVO자료를 이용하여 DB에 update하는 메서드
	 * 
	 * @param conn Connection 객체
	 * @param memVo update할 회원정보가 저장된 MemberVO객체
	 * @return  작업성공 1, 작업실패 0
	 * @throws SQLException
	 */
	
	public int updateMember(SqlMapClient smc, MemberVO memVo) throws SQLException;
	
	
	/**
	 * DB의 전체회원 정보를 가져와서 List에 담아서 반환하는 메서드
	 * @param conn Connection 객체
	 * @return  MemberVO객체가 저장된 List
	 * @throws SQLException 
	 */
	public List<MemberVO> getAllMember(SqlMapClient smc) throws SQLException;
	
	
	/**
	 * 회원 ID를 매개변수로 받아서 해당 회원 ID의 개수를 반환하는 메서드
	 * 
	 * @param conn Connection 객체
	 * @param memId 검색할 회원 ID
	 * @return  검색된 회원 ID의 갯수
	 * @throws SQLException
	 */
	public int getMemberCount(SqlMapClient smc, String memId) throws SQLException;
	
	
	

	
	/**
	 * 
	 * Map의 정보를 이용하여 회원정보 중 원하는 컬럼을 수정하는 메서드
	 * 		key값 정보 ==> 회원ID(memid), 수정할 컬럼명(field), 수정할데이터(data)
	 * 
	 * @param conn  Cpnnection 객체
	 * @param paramMap  paramMap 수정할 회원 I, 수정할 컬럼명, 수정할 데이터가 저장된
	 * @return 작업성공 1, 작업실패 0
	 * @throws SQLException
	 * 
	 * 
	 */
	public int updateMember2(SqlMapClient smc, Map<String, String> paramMap) throws SQLException;
	
	
	
}











