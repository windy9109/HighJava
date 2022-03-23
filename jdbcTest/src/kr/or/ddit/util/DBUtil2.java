package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



//jdbc 드라이버를 로딩하고 Connection 객체를 생성하여 반환하는 메서드로 구성된 class
//(dbinfo.properties 파일의 내용을 읽어와 설정하기)


public class DBUtil2 {
	
	static Properties prop; //properties 객체 변수 선언
	
	
	//static 초기화 블럭
	static {
		prop = new Properties(); // Properties객체생성
		File f = new File("res/kr/or/ddit/config/dbinfo.properties");
		FileInputStream fin = null;
		
		try {
			
			fin = new FileInputStream(f); //스트림객체생성
			prop.load(fin);
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(prop.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패~~~");
			e.printStackTrace();
		}catch(IOException e){
			System.out.println("입출력오류 ~~ 드라이버 로딩 실패....");
			e.printStackTrace();
		}
		
	}
	
	//-------------------------------------------
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pass")
					);
		} catch (SQLException e) {
			System.out.println("DB 연결 실패!!!");
			return null;
		}
		
	}
	
	

}
