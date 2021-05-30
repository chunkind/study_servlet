package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	/*
	 * memberDAO는 businessLogic을 담고있는 클래스.
	 * MVC Pattern에서 M(Model)에 해당한다.
	 * Model :: 크게 2가지로 나뉜다.  DTO / DAO
	 * ---------------------------------------------------------
	 * Server Side 에서 단 한 개만 생성된다.
	 * 즉, 다른 곳에서 해당 클래스 타입으로 DAO가 성생되지 못하도록 막아놓아야 한다.
	 * 그리고 DAO의 비지니스 로직(regi(), find())이 필요한 서블릿들은
	 * DAO 메서드를 각각 호출해서 사용한다.
	 * 이것을 싱글톤 패턴이라하고 서버측에서 MemberDAO가 여기에 해당된다.
	 * ---------------------------------------------------------------------------------------------
	 * Singletone Pattern ::
	 * 1) 일단 해당 클래스에서 객체를 하나는 생성한다. : private static 을 사용.
	 * 2) 다른 곳에서 해당 클래스타입으로 객체를 생성하지 못하게 한다. : 생성자 앞에 private
	 * 3) 하나 생성된 객체를 다른 곳에서 가져다 쓸 수 있게 한다. : public static Object getInstance();
	 */
	private DataSource ds;

	private static MemberDAO dao = new MemberDAO(); //1번
	private MemberDAO(){ // 2번
			System.out.println("DAO class is created in the singleton pattern.");
			
			/*
			 * DataSource 방식으로 Connection을 Rent 해오는 로직을 작성.
			 * 1. Context 객체 하나 생성.
			 * 2. DataSource ds = ic.lookup()으로 찾아옴. Context.xml에 이름으로 이미 바인딩이 되어있다.
			 */
			try{
				Context ic = new InitialContext();
				ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
				System.out.println("DataSource lookup()");
			} catch(NamingException e){}
	}
	public static MemberDAO getInstance(){ // 3번
		return dao;
	}
	// 여기까지가 singleton.
	
	/////////////////////////////////// 공통적인 기능 ////////////////////////////////////////
	public Connection getConn() throws SQLException{
		System.out.println("DB연결 성공");
		
		Connection conn = ds.getConnection();
		
		return conn;
	}
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	public void closeAll(PreparedStatement ps, Connection conn, ResultSet rs) throws SQLException{
		closeAll(ps, conn);
		if(rs != null) rs.close();
	}
	//////////////////////////////////// 비지니스 로직 ////////////////////////////////////////
	public void registerMember(MemberDTO dto) throws SQLException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn = getConn();
			String query = "INSERT INTO member VALUES (?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, dto.getId());
			ps.setString(3, dto.getPass());
			ps.setString(2, dto.getName());
			ps.setString(4, dto.getAddr());
			
			System.out.println(ps.executeUpdate() + "줄 성공. 추가된 ID : " + dto.getId());
		}finally{
			closeAll(ps, conn);
		}
	}
	public MemberDTO findMemberById(String id) throws SQLException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberDTO dto = null;
		
		try{
			conn = getConn();
			String query = "SELECT * FROM member WHERE id = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				dto = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				System.out.println("1명 검색됨.");
			}
		}finally{
			closeAll(ps, conn, rs);
		}
		
		return dto;
	}
	
	public ArrayList<MemberDTO> findMemberByAddr(String addr) throws SQLException{
		System.out.println("Conducting findMemberByAddr().");
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			System.out.println("starting Query.");
			conn = getConn();
			String query = "SELECT * FROM member WHERE address=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, addr);
			
			rs = ps.executeQuery();
			System.out.println("executing Query.");
			while(rs.next()){
				list.add(new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		}finally{
			closeAll(ps, conn, rs);
		}
		return list;
	}
	
	public ArrayList<MemberDTO> showAllMember() throws SQLException{
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			conn = getConn();
			String query = "SELECT * FROM member";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				list.add(new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		}finally{
			closeAll(ps, conn, rs);
		}
		
		return list;
	}
	
	public MemberDTO loginMember(String id, String password) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberDTO dto = null;
		
		try{
			conn = getConn();
			String query = "SELECT * FROM member WHERE id=? AND password=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, id);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			if(rs.next())
				dto = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}finally{
			closeAll(ps, conn, rs);
		}
		return dto;
	}
	
	public void updateInfo(MemberDTO dto) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn = getConn();
			String query = "UPDATE member SET password=?, address=? WHERE id=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, dto.getPass());
			ps.setString(2, dto.getAddr());
			ps.setString(3, dto.getId());
			
			System.out.println(ps.executeUpdate() + "줄 성공. 수정된 ID : " + dto.getId());
		}finally{
			closeAll(ps, conn);
		}
	}
	/*public boolean isExist(String id) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		
		try{
			
		}catch(Exception e){
			
		}
	}*/
}
