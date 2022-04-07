package kr.or.ddit.json;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.basic.session.MemberDao;
import kr.or.ddit.util.DBUtil3;

public class LprodDao {

	private static LprodDao dao;
	private LprodDao() { }
	
	public static LprodDao getInstance() {
		if(dao == null) dao = new LprodDao();
			return dao;
	}
	
	
	public List<LprodVO> getLprodList(){
		LprodVO lprod = null;
		List<LprodVO> lprodlist = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from lprod";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			 
			
			lprodlist = new ArrayList<LprodVO>();
			
			while(rs.next()) {
				lprod = new LprodVO();
				lprod.setLprod_id(rs.getInt("lprod_id"));
				lprod.setLprod_gu(rs.getString("lprod_gu"));
				lprod.setLprod_nm(rs.getString("lprod_nm"));
				lprodlist.add(lprod);
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			lprodlist = null;
			lprod = null;
		}finally {
			if(rs!=null) try {rs.close(); }catch(SQLException e){}
			if(pstmt!=null) try {pstmt.close(); }catch(SQLException e){}
			if(conn!=null) try {conn.close(); }catch(SQLException e){}
		}
		
		return lprodlist;
		
	}
	
	
	
}
