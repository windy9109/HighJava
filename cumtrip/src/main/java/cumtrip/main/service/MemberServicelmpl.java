package cumtrip.main.service;

import java.sql.SQLException;
import java.util.List;

import cumtrip.main.dao.IMemberDao;
import cumtrip.main.dao.MemberDaolmpl;
import cumtrip.vo.Lo_searchVO;
import cumtrip.vo.MemberVO;


//dao에 접근 - dao객체가 필요
//service객체 생성 리턴 - controller가 사용

public class MemberServicelmpl implements IMemberService {
	
	
	private IMemberDao dao;
	private static IMemberService service;
	
	private MemberServicelmpl() {
		dao = MemberDaolmpl.getInstance();
		
	}
	
	public static IMemberService getInstance() {
		if(service == null) service = new MemberServicelmpl();
		return service;
		
	}


	@Override
	public List<MemberVO> Count(String id) {
		List<MemberVO> vo = null;
		try {
			vo = dao.Count(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}
	

//	@Override
//	public List<ZipVo> search(String data) {
//		// TODO Auto-generated method stub
//		return dao.search(data);
//	}
	

	@Override
	public String insert(MemberVO vo) {
		String count = null;
		try {
			count = dao.insert(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	//로그인
	@Override
	public List<MemberVO> getMember(MemberVO memVo) {
		List<MemberVO> vo = null;
		
		try {
			vo = dao.getMember(memVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public List<Lo_searchVO> getSido(Lo_searchVO sidoVo) {
		List<Lo_searchVO> vo = null;
		
		  try {
			vo= dao.getSido(sidoVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	//아이디찾기
	@Override
	public List<MemberVO> idFind(MemberVO vo) {
		List<MemberVO> volist = null;
		
		try {
			volist = dao.idFind(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return volist;
	}
	
	//패스워드 찾기
	@Override
	public List<MemberVO> passFind(MemberVO vo) {
		List<MemberVO> volist = null;
		
		try {
			volist = dao.passFind(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return volist;
	}

	//패스워드변경
	@Override
	public int PassSetFind(MemberVO vo) {
		int count = 0;
		
		try {
			count = dao.PassSetFind(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	

	
	
}
