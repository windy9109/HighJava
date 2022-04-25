package cumtrip.main.service;

import java.sql.SQLException;
import java.util.List;

import cumtrip.main.dao.IReplyDao;
import cumtrip.main.dao.ReplyDaoImpl;
import cumtrip.vo.BoardVo;
import cumtrip.vo.ReplyVo;


public class ReplyServiceImpl implements IReplyService{

	private IReplyDao dao;
	private static IReplyService service;
	
	
	private ReplyServiceImpl() {
		dao = ReplyDaoImpl.getInstance();
	}
	
	//getInstance()메소드 service객체 생성, 리턴
	public static IReplyService getInstance() {
		if(service== null) service = new ReplyServiceImpl();
		return service;
	}
	
	
	
	
	
//	@Override
//	public int updateReply(ReplyVo vo) {
//		int res = 0;
//		
//		try {
//			res = dao.updateReply(vo);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return res;
//	}
//
//	@Override
//	public int deleteReply(int reply) {
//		int res = 0;
//		
//		try {
//			res = dao.deleteReply(reply);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return res;
//	
//	}

	@Override
	public List<ReplyVo> replyList(int bonum) {
		List<ReplyVo> list = null;

		try {
			list = dao.replyList(bonum);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

//	@Override
//	public int insertReply(ReplyVo vo) {
//		int res = 0;
//		
//		try {
//			res = dao.insertReply(vo);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return res;
//	}

}
