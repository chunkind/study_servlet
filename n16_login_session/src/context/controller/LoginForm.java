package context.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import context.model.MemberDAO;
import context.model.MemberDTO;

public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 폼에 입력된 값을 받는다.. id, password
		 * 2. MemberDAO를 리턴 받는다.
		 * 3. loginMember( ) 호출... 반환값 받는다.
		 * 4. 세션을 반환받는다.
		 * 5. 세션에 바인딩.. 이때 jsessionid 값을 콘솔로 출력
		 * 6. 네비게이션..result_login.jsp 로 이동.
		 */
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberDAO dao = MemberDAO.getInstance();

		try{
			MemberDTO rdto = dao.loginMember(id, password);
			HttpSession session = request.getSession();
			System.out.println("JSESSIONID ::" + session.getId());	// 이걸 나중에 웹에서 확인.
			session.setAttribute("rdto", rdto);
			
			RequestDispatcher rdp = request.getRequestDispatcher("result_login.jsp");
			rdp.forward(request, response);
		}catch(Exception e){
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
