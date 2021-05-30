package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;

public class CheckIdController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String id = request.getParameter("id");
		MemberDTO rdto = null;
		boolean idExist = false;
		String path = "id_check.jsp";
		
		try {
			rdto = MemberDAO.getInstance().findMemberById(id);
			if(rdto != null){
				idExist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("idExist", idExist);
		
		return new ModelAndView(path);
	}
}
