package context.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.model.MemberDAO;
import context.model.MemberDTO;
public class RegisterMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성....한글처리 양방향은  Filter가 한다.
		PrintWriter out = response.getWriter();
		/*
		 * Controller의 기능을 여기서 정형화 시켜버립시다..
		 * 1. 폼에 입력된 값 받아서
		 * 2. DTO 생성...이때 값이 인자값으로 들어간다.
		 * 3. DAO의 비지니스 로직 호출...registerMember()
		 * 4. View page로 연결...여기서 바로 out.println("회원 등록됨...")
		 */
		String id=  request.getParameter("id");
		String password=  request.getParameter("password");
		String name=  request.getParameter("name");
		String address=  request.getParameter("address");
		
		//dto는 form이랑 연결된 dto.
		MemberDTO dto = new MemberDTO(id, password, name, address);
		
		MemberDAO dao=MemberDAO.getInstance();
		try{
			dao.registerMember(dto); 
			out.println(name+" 님이 Cafe 회원으로 등록 성공!!!");
		}catch(Exception e){
			out.println(name+" 님이 Cafe 회원으로 등록 실패!!!");
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
