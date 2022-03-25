package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.vo.LprodVO;

/*
 * Lprod테이블에 새로운 데이터를 추가하기
 * lprod_gu와 lprod_nm은 직접 입력받아서 처리하고,
 * lprod_id는 현재의 lprod_id중에서 제일 큰 값보다 1크게 한다.
 * 
 * 그리고 lprod_gu가 이미 등록되어있으면 다시 입력 받아서 처리한다.
 * 
 * ( SQL문에 저장되는 XML문서의 파일명: jdbc.xml )
 * 
*/



public class LprodIbatisTest2 {
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);		
		
		try {
			
			
			Charset charset = Charset.forName("utf-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/iBatisTest/config/sqlMapConfig.xml");
			
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
			//---------------------------------------------------------
			
			//insert작업
			System.out.println("insert작업시작...");

	
			int lvo1;
			
			//id값을 받아옴(int)
			int nextId = (int)smc.queryForObject("lprod2.countLprod1");
			nextId++;

			String gu;
			int count = 0;
			
			do {
				System.out.println("Lprod_gu입력: ");
				gu = scan.next();
				count = (int) smc.queryForObject("lprod2.countLprod2", gu);
				
				if(count > 0) {
					System.out.println("입력한 상품분류코드" + gu
							+"는 이미등록된 상품입니다.");
					System.out.println("다시 입력하세요");
				}
				
			}while( count > 0 );	
			
			
			System.out.println("Lprod_nm입력: ");
			String nm = scan.next();
			
			
			
			//저장할 데이터를 vo에 담는다.
			LprodVO lvo = new LprodVO();
			lvo.setLprod_id(nextId);
			lvo.setLprod_gu(gu);
			lvo.setLprod_nm(nm);
			
			
			Object obj = smc.insert("lprod2.insertLprod2", lvo);
			if(obj == null) {
				System.out.println("insert성공");
			}else {
				System.out.println("insert실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
