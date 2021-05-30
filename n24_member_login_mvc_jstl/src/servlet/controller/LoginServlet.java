package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberDTO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberDAO dao = MemberDAO.getInstance();
		String path = "login_fail.jsp";
		try{
			MemberDTO rdto=dao.loginMember(id, password);
			if(rdto != null){ //인증 됬다면...
				HttpSession session= request.getSession();
				session.setAttribute("rdto", rdto);
				path = "login_ok.jsp";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}










