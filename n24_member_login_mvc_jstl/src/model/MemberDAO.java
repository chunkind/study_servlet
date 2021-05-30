package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class MemberDAO {
	private DataSource ds;
	private static MemberDAO dao = new MemberDAO(); //1)
	private MemberDAO(){
		/*
		 * DataSource 방식으로 Connection을 Rent 해오는 로직을 작성...
		 * 1. Context 객체 생성...Naming Service의 가장 핵심적인 객체(bind(), lookup())
		 * 2. DataSource ds=lookup()으로 찾아옴...Context.xml에 이미 이름으로 바인딩 되어있다.
		 * 3. ds.getConnection()
		 */
		try{
			InitialContext ic = new InitialContext();
			ds=(DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource.....Lookup....");
			System.out.println("Singletone Pattern.....DAO Creating...."); //2)
		}catch(NamingException e){
			System.out.println("DataSource.....Lookup...Fail..");
		}
	}
	public static MemberDAO getInstance(){ //3)
		return dao;
	}
	/////////////// 공통적인 로직 부분 getConnection(), closeAll() ////////////////////////
	
	public Connection getConn() throws SQLException{
		System.out.println("디비 연결 성공....");
		return ds.getConnection();
	}
	public void closeAll(PreparedStatement ps, Connection conn)throws SQLException{
		if(ps!=null) ps.close();
		if(conn!=null)conn.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn)throws SQLException{
		if(rs!=null) rs.close();
		closeAll(ps, conn);	
	}
	///////////////////////// 비지니스 로직 //////////////////////////////////////
	public void registerMember(MemberDTO dto)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = getConn();
			String query = "INSERT INTO member VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPassword());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getAddress());
			
			System.out.println(ps.executeUpdate()+" 명 INSERT OK!!");
		}finally{
			closeAll(ps, conn);
		}
	}
	public MemberDTO findMemberById(String id)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberDTO dto=  null;
		try{
			conn = getConn();
			String query = "SELECT * FROM member WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				dto = new MemberDTO(id, 
								    rs.getString("password"), 
								    rs.getString("name"), 
								    rs.getString("address"));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return dto;
	}
	
	public ArrayList<MemberDTO> findMemberByAddress(String address)
									throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try{
			conn = getConn();
			String query = "SELECT * FROM member WHERE address=?";
			ps = conn.prepareStatement(query);
			ps.setString(1,address);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new MemberDTO(rs.getString(1), 
									   rs.getString(2), 
									   rs.getString(3), 
									   address));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<MemberDTO> showAllMember()throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try{
			conn = getConn();
			String query = "SELECT *  FROM member";
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()){
				list.add(new MemberDTO(rs.getString("id"), 
						rs.getString("password"), 
						rs.getString("name"), 
						rs.getString("address")));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
		
	}
	
	public MemberDTO loginMember(String id, String password)throws SQLException{
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
			if(rs.next()){
				dto =new MemberDTO(id, password,
						rs.getString("name"), 
						rs.getString("address"));
			}
		}finally{
			closeAll(rs, ps, conn);
		}		
		return dto;
	}
	
	public void updateMember(MemberDTO dto)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = getConn();
			String query = "UPDATE  member SET name=?, address=? WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getAddress());
			ps.setString(3, dto.getId());
			
			System.out.println(ps.executeUpdate()+" 명 수정됨..");
		}finally{
			closeAll(ps, conn);
		}
	}
	
	/*public boolean isExist(String id) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		
		return false;
	}*/
	/*public static void main(String[] args)throws Exception{ //단위테스트 한 다음, main은 지우겠다
		MemberDAO dao=MemberDAO.getInstance();
		//dao.registerMember(new MemberDTO("haha", "0071", "하바리", "서현동"));
		//System.out.println(dao.findMemberById("haha"));
	}*/
}






















