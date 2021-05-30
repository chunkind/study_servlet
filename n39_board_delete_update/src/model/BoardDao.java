package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BoardDao {
	private DataSource ds;
	private static BoardDao dao = new BoardDao();
	
	private BoardDao(){		
		//DataSource를 Lookup 해오는 로직이 여기 있었따...
		ds = DataSourceManager.getInstance().getConnection();
	}
	public static BoardDao getInstance(){
		return dao;
	}
	//이전에는 여기서 Connection을 리턴받아 사용했다...
	//여기서는 DataSourceManager에서 그 일을 전담하고 있따...달라진점..
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	////////////////// 공통적인 로직 /////////////////////////////////
	public void closeAll(PreparedStatement ps, Connection conn)throws SQLException{
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn)throws SQLException{
		if(rs != null) rs.close();
		closeAll(ps, conn);
	}
	
	///////////////////// 비지니스 로직 /////////////////////////////////
	
	//게시판 글 작성하기
	public void posting(BoardVO vo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			//이전에는 여기다 쿼리문을 일일이 작성...이 부분을 메타데이타화 시켰다
			//properties 파일 > 인터페이스 > xml 파일로 >@annotation
			ps = conn.prepareStatement(StringQuery.INSERT_POSTING);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getPassword());
			ps.setString(4, vo.getContent());
			
			int row=ps.executeUpdate();
			//System.out.println(row+" row INSERT ok!!");
			//System.out.println("작성한 posting :: "+vo);
			//디비사이드에서 증가된 시퀀스 값을 다시 가져와서 vo에 주입
			
			ps = conn.prepareStatement(StringQuery.CURRNET_NO);
			rs = ps.executeQuery();
			if(rs.next()){
				vo.setNo(rs.getInt(1));
			}
			System.out.println("dao..INSERT OK!!..No ::"+vo.getNo());
		}finally{
			closeAll(rs, ps, conn);
		}
	}
	
	public BoardVO getPostingByNo(int no) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;
		try{
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.SELECT_POSTING);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()){
				vo = new BoardVO(no,
						rs.getString("title"),
						rs.getString("writer"), 
						rs.getString("content"), 
						rs.getInt("hits"), 
						rs.getString("time_posted"));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		
		return vo;
	}
	
	public ArrayList<BoardVO> getPosting() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardVO>  list = new ArrayList<BoardVO>();
		try{
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.SELECT_ALLPOSTING);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new BoardVO(rs.getInt("no"),
						rs.getString("title"),
						rs.getString("writer"), 
						rs.getString("content"),  
						rs.getInt("hits"), 
						rs.getString("time_posted")));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		
		return list;
	}
}