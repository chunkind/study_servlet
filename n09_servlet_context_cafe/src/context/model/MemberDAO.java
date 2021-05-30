package context.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.OracleInfo;

/*
 * 싱글톤패턴은 딱 세가지 규칙을 지켜서 코드가 만들어져야한다.
 * 생성자 앞에 private을 붙인다. 이전에 객체를 만들어야한다.
 * 만들어 놓은 것을 method를 호출하면 사용할 수 있도록
 * public으로 geter를 만들어야한다.
 * =======================================
 * 디비연결하는 비지니스로직을 담고 있는 클래스
 * MVC Pattern에서 M(Model)에 해당한다.
 * Model은 크게 두 가지로 나뉜다. (DTO / DAO)
 * =========================================
 * DAO :: 
 * Server Side에서 단 한개만 생성된다.
 * 즉 다른곳에서 해당 클래스 타입으로 DAO가 생성되지 못하도록 막아놓아야한다.
 * 그리고 DAO의 비지니스 로직이(registerMember(), findMember())필요한 서블릿들은
 * DAO메소드를 각각 호출해서 사용한다.
 * 이것을 바로 싱글콘 패턴이라 하고 서버사이드레서 MemberDAO가 여기에 해당한다.
 * ===============================================================
 * Singletone Pattern ::
 * 1) 일단 해당클래스에서 객체를 하나는 생성한다. : private static를 사용
 * 2) 다른 곳에서 헤당 클래서 타입으로 객체를 생성하지 못하게 한다 : 생성자 앞에 private
 * 2) 하나 생서왼 객체를 다른곳에서 가져가 쓸수 있게 한다. : public static Object getXxx()
 */
public class MemberDAO {
   private static MemberDAO dao = new MemberDAO(); // 1)
   private MemberDAO(){
      //나중에 이 부분 빼고 서버랑 붙이겠다.
      /*try{
         Class.forName(OracleInfo.DRIVER_NAME);
      }catch(ClassNotFoundException e){
         System.out.println("드라이버 로딩 실패");
      }*/
      System.out.println("Singletone Pattern..DAO Creating"); // 2)
   }
   public static MemberDAO getInstance(){ //3)
      return dao;
   }
   ///////////////// 공통적인 로직 부분 getConnection(), closeAll() ////////////////////
   public Connection getConnection() throws SQLException{
      System.out.println("디비 연결 성공");
      return DriverManager.getConnection(OracleInfo.URL, OracleInfo.USER, OracleInfo.PASS);
   }
   
   public void closeAll(PreparedStatement ps, Connection conn)throws SQLException{
      if(ps!=null) ps.close();
      if(conn!=null) conn.close();
   }
   
   public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException{
      if(rs!=null) rs.close();
      closeAll(ps, conn);
   }
   
   ///////////////////// 비지니스 로직 //////////////////////////
   public void registerMember(MemberDTO dto) throws SQLException{
      Connection conn = null;
      PreparedStatement ps=  null;
      try{
         conn = getConnection();
         String query = "INSERT INTO member_ex VALUES(?,?,?,?)";
         ps = conn.prepareStatement(query);
         ps.setString(1, dto.getId());
         ps.setString(2, dto.getPassword());
         ps.setString(3, dto.getName());
         ps.setString(4, dto.getAddress());
         System.out.println(ps.executeUpdate()+" 명 insert member...registerMember()");
      }finally{
         closeAll(ps, conn);
      }
   }

    public MemberDTO findMemberById(String id)throws SQLException{
         MemberDTO dto = null;
         Connection conn = null;
         PreparedStatement ps = null;
         ResultSet rs = null;
         conn = getConnection();   
         
         try{
         String query = "select * from member_ex where id=?";
         ps = conn.prepareStatement(query);
         ps.setString(1, id);
         rs = ps.executeQuery();
         
         if(rs.next()){
            dto = new MemberDTO(id, rs.getString(2), rs.getString(3), rs.getString(4));
         }   
         }finally{
            closeAll(rs, ps, conn);
         }
         return dto;
      }
   /*public static void main(String[] args) throws Exception{ // 단위테스트 한 다음, main은 지우겠다.
      MemberDAO dao = MemberDAO.getInstance();
      //dao.registerMember(new MemberDTO("111-111", "121212", "구유림", "수원"));
      //System.out.println(dao.findMemberById("111-111"));
   }
*/
}