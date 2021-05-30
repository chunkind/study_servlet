package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;

public class FindController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		MemberDTO rdto = null;
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		
		try {
			rdto = MemberDAO.getInstance().findMemberById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rdto != null){
			request.setAttribute("rdto", rdto);
			path = "find_ok.jsp";
		}
		
		return new ModelAndView(path);
	}
}
