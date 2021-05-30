package context.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.model.MemberDAO;
import context.model.MemberDTO;
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성...
		PrintWriter out=  response.getWriter();
		
		String id = request.getParameter("id");
		MemberDAO dao = MemberDAO.getInstance();
		try{
			MemberDTO rdto=dao.findMemberById(id);	// rdto 에서 r은 return 이다.
			if(rdto != null)
				out.println(id+"  에 해당하는 회원 정보 출력 :: <br>"+rdto);
			else
				out.println(id+"  에 해당하는 회원을 찾지 못했습니다...");
		}catch(Exception e){
			e.printStackTrace();
		}
		out.close();		
	}
}
