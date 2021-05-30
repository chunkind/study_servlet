package context.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.model.MemberDAO;
import context.model.MemberDTO;

public class ShowAllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		/*
		 * DAO 리턴받아서 비지니스 로직 호출(showAllMember()를 추가).. LIST를 리턴 받아서
		 * 바인딩.. request 
		 * 페이지 이동.. showAll.jsp
		 */
		MemberDAO dao = MemberDAO.getInstance();
		System.out.println("연결되었습니다.");
		try{
			System.out.println("dao 메서드 접근 시도.");
			ArrayList<MemberDTO> returnList = dao.showAllMember();
			System.out.println("dao 메서드 접근 성공.");
			for(int i=0; i<returnList.size(); i++){
				System.out.println(returnList.get(i).getName());
			}
			request.setAttribute("returnList", returnList);
			System.out.println("request setAttribute 성공");
			RequestDispatcher rdp = request.getRequestDispatcher("showAll.jsp");
			System.out.println("rdp 디스패치 성공");
			rdp.forward(request, response);
			System.out.println("포워딩 성공");
		}catch(Exception e){
			System.out.println("전체 회원 명단을 가지고 오는데 실패했습니다..");
			
		}
	}
}
