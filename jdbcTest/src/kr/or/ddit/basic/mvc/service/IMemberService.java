package kr.or.ddit.basic.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.basic.mvc.vo.MemberVO;


//Dao와 메소드 이름이 거의 같다고 보면됨
//메소드에서 Connection conn과 throws SQLException만 삭제해주면 됨.


/**
 * Service객체는 DAO에 설정된 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고, 
 * 받아온 결과 자료를 Controller에게 보내는 역할을 한다.
 * @author PC-10
 *
 */

public interface IMemberService {

	/**
	 * 
	 * MemberVo에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param memVo		DB에 insert할 자료가 저장된 MemberVO객체
	 * @return			INSERT작업성공 1, INSERT 작업실패:0
	 * @throws SQLException
	 */
	public int insertMember(MemberVO memVo);
	
	
	
	/**
	 * 회원 ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
	 * @param memId 삭제할 회원 ID
	 * @return	작업성공 1, 작업실패 0
	 * @throws SQLException
	 */
	public int deletMenber(String memId);
	
	
	
	/**
	 * MemberVO자료를 이용하여 DB에 update하는 메서드
	 * 
	 * @param memVo update할 회원정보가 저장된 MemberVO객체
	 * @return  작업성공 1, 작업실패 0
	 * @throws SQLException
	 */
	
	public int updateMember(MemberVO memVo);
	
	
	/**
	 * DB의 전체회원 정보를 가져와서 List에 담아서 반환하는 메서드
	 * @return  MemberVO객체가 저장된 List
	 * @throws SQLException 
	 */
	public List<MemberVO> getAllMember();
	
	
	/**
	 * 회원 ID를 매개변수로 받아서 해당 회원 ID의 개수를 반환하는 메서드
	 * 
	 * @param memId 검색할 회원 ID
	 * @return  검색된 회원 ID의 갯수
	 * @throws SQLException
	 */
	public int getMemberCount(String memId);



	public int updateMember2(Map<String, String> paramMap);
	

	
	
	
}
