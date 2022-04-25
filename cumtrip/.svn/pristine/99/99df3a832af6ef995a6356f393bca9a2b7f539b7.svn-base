package cumtrip.detail.service;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapException;

import cumtrip.admin.service.MainService;
import cumtrip.detail.dao.DetailDao;
import cumtrip.util.SqlMapClientFactory;
import cumtrip.vo.CartVO;
import cumtrip.vo.M_commentVO;
import cumtrip.vo.M_reviewVO;
import cumtrip.vo.M_reviewVO2;
import cumtrip.vo.MiddleVO;
import cumtrip.vo.MiddleinfoVO;
import cumtrip.vo.Mr_likesVO;
import cumtrip.vo.PhotoVO;
import cumtrip.vo.RoomVO2;
import cumtrip.vo.S_commentVO;
import cumtrip.vo.S_reviewVO;
import cumtrip.vo.S_reviewVO2;
import cumtrip.vo.StayVO;

public class DetailService {

	private DetailDao dao;
	private static DetailService service;
	SqlMapClient smc = null;
	private DetailService() {
		dao = DetailDao.getInstance();
		smc = SqlMapClientFactory.getsqlMapClient();
	}
	public static DetailService getInstance() {
		if(service == null) service = new DetailService();
		return service;
	}
	
	public MiddleVO seletectdetail(String midno) {
		
		MiddleVO vo  = null;
		
		try {
			
			vo = dao.seletectdetail(smc, midno);
		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return vo;
		
	}
	public List<String> selectonephoto(String midno) {
		 List<String> list = null;
		try {
			list= dao.selectonephoto(smc, midno);
		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
	}
	public List<MiddleinfoVO> aroundspacephoto(Map<String,String> map){
		List<MiddleinfoVO> list = null;
		try {
			list= dao.aroundspacephoto(smc, map);
		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
		
	}
	public List<MiddleinfoVO> aroundrestaurantphoto(Map<String,String> map){
		List<MiddleinfoVO> list = null;
		try {
			list= dao.aroundrestaurantphoto(smc, map);
		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
	
	}
	public int insertmreview(M_reviewVO vo) {
		int result = 0 ;
		 
		try {
			result = dao.insertmreview(smc, vo);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
	}
	public int insertsreview(S_reviewVO vo) {
		int result = 0 ;
		
		try {
			result = dao.insertsreview(smc, vo);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
	}
	public int insertcomment(M_commentVO vo) {
		int result = 0 ;
		
		try {
			result = dao.insertcomment(smc, vo);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
	}
	public int insertstaycomment(S_commentVO vo) {
		int result = 0 ;
		
		try {
			result = dao.insertstaycomment(smc, vo);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public int insertphoto2(PhotoVO vo) {
		int result = 0 ;
		
		try {
			result = dao.insertphoto2(smc, vo);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
	}
	public List<M_reviewVO2> selectallreview(String midno){
		List<M_reviewVO2> list = null;
		
		try {
			list = dao.selectallreview(smc, midno);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
	}
	public List<S_reviewVO2> selectallstayreview(String stayno){
		List<S_reviewVO2> list = null;
		
		try {
			list = dao.selectallstayreview(smc, stayno);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
	}
	public List<M_commentVO> selectcomment(String mreno){
		List<M_commentVO> list = null;
		
		try {
			list = dao.selectcomment(smc, mreno);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
	}
	public List<S_commentVO> selectstaycomment(String sreno){
		List<S_commentVO> list = null;
		
		try {
			list = dao.selectstaycomment(smc, sreno);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
	}
	public int veiws(String midno) {
		int result = 0 ; 
		
		try {
			result = dao.veiws(smc, midno);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public StayVO detailstay(String stayno) {
		StayVO vo = null;
		
		try {
			vo = dao.detailstay(smc, stayno);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return vo;
	}
	public List<String> selectonestayphoto(String stayno){
		List<String> list = null;
		
		try {
			list = dao.selectonestayphoto(smc, stayno);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
	}
	public List<RoomVO2> selectallroom(String stayno){
		List<RoomVO2> list = null;
		
		try {
			list = dao.selectallroom(smc, stayno);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
	}
	
	// 리뷰 수정
	public int updatemreview(M_reviewVO vo) {
		int result = 0 ;
		try {
			result = dao.updatemreview(smc, vo);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
	}
	
	// 리뷰 삭제
	public int deletemreview(M_reviewVO vo) {
		int result = 0 ;
		try {
			result = dao.deletemreview(smc, vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 리뷰 좋아요
	public int insertmrlikes(Mr_likesVO vo) {
		int result = 0 ;
		try {
			result = dao.insertmrlikes(smc, vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int insertcart(CartVO vo) {
		int result = 0 ;
		try {
			result = dao.insertcart(smc, vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int insertpay(Map<String,String> map) {
		int result = 0 ;
		try {
			result = dao.insertpay(smc, map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int commentdel(String comno) {
		int result = 0; 
	
		try {
			result = dao.commentdel(smc, comno);
					
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
	}
	public int commentmod(M_commentVO vo) {
		int result = 0; 
		
		try {
			result = dao.commentmod(smc, vo);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
	}
	public int commentsdel(String scono) {
		int result = 0; 
		
		try {
			result = dao.commentsdel(smc, scono);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
	}
	public int commentsmod(S_commentVO vo) {
		int result = 0; 
		
		try {
			result = dao.commentsmod(smc, vo);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
	}
}
