package context.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.model.MemberDAO;
import context.model.MemberDTO;
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성
		
		PrintWriter out = response.getWriter();
		/*
		 * 폼에 입력된 id값 받아서..
		 * DAO 리턴받아서 / 비지니스 로직 호출
		 * 리턴되는 값이 null이 아니면 id에 해당하는 회원정보를 웹으로 출력
		 * 리턴되는 값이 null이면 id에 해당하는 회원을 찾지 못했다는 메세지 웹으로 출력
		 */
		String id = request.getParameter("id");
		MemberDAO dao = MemberDAO.getInstance();
		try{
			//디비랑 연결된 dto여서 ReturnDTO 로 명을 지정
			MemberDTO rdto = dao.findMemberById(id);
			if(rdto!=null){
				out.println(id+" 에 해당하는 회원 정보 출력 :: <br>"+rdto);
			}else{
				out.println(id + " 에 해당하는 회원을 찾지 못했습니다.");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		out.close();
	}
}
