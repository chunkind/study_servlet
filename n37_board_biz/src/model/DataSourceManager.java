package model;

import java.sql.Connection;
import java.sql.DriverManager;

import config.OracleInfo;

/*
 * NamingService를 이용.. djqtek..
 * 싱글톤 방식으로 객체를 생성
 * --> DataSource를 리턴 받을 것이다. / DriverManager 방식으로 Connection을 일단 리턴받는다.
 * 나중에는 DataSource 방식을 쓸 것이다.. 서버에서 가동할때.
 */
public class DataSourceManager {
	private Connection conn;
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager() {
		try {
			Class.forName(OracleInfo.DRIVER_NAME);
			System.out.println("Driver Loading..");
			
			conn = DriverManager.getConnection(OracleInfo.URL, "scott", "tiger");
			System.out.println("Connection Conn...return..");
		}catch(Exception e){
			
		}
	}
	
	public static DataSourceManager getInstance() {
		return instance;
	}
	
	public Connection getConnection() {
		return conn;
	}
}
/*
 * oracleInfo ::
 * 				서버에 대한 정보를 상수값으로 인터페이스에 매핑
 * 				(서버 주소, 계정 이름, 계정 비번, 드라이버 FQCN)
 * StringQuery ::
 * 				게시판 글 작성하는 쿼리문을 여기서 매핑.. 상수값으로 등록
 * 
 */