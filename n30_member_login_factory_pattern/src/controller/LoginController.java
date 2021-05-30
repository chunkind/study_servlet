package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberDTO;

public class LoginController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) {

		MemberDTO rdto = null;
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		try {
			rdto = MemberDAO.getInstance().loginMember(id, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		String path = "login_fail.jsp";
		if(rdto != null){
			session.setAttribute("rdto", rdto);
			path = "login_ok.jsp";
		}
		
		return new ModelAndView(path);
	}
}
