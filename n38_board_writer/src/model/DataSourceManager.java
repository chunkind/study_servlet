package model;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/*
 * NamingService를 이용...
 * 싱글톤 방식으로 객체를 생성
 * -->DataSource를 리턴 받을 것이다.
 * 
 */
public class DataSourceManager {
	private DataSource ds;
	private static DataSourceManager instance=  new DataSourceManager();
	private DataSourceManager(){
		try{
			//Naming Service 로직....lookup()...Context
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource Lookup....");
		}catch(Exception e){
			System.out.println("DataSource를 찾아오지 못했습니다...");
		}
	}
	public static DataSourceManager getInstance(){
		return instance;
	}
	
	public DataSource getConnection(){
		return ds;
	}
}

/*
 * OracleInfo ::
 * 				서버에 대한 정보를 상수값으로 인터페이스에 매핑
 *              (서버주소, 계정이름, 계정 비번, 드라이버 FQCN)
 * StringQuery ::
 *              게시판 글 작성하는 쿼리문을 여기사 매핑..상수값으로 등록
 */













