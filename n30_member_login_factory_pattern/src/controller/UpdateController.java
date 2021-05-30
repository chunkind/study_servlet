package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberDTO;

public class UpdateController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String path = "update_result.jsp";
		
		MemberDTO rdto = new MemberDTO(id, password, name, address);
		try {
			MemberDAO.getInstance().updateInfo(rdto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("rdto", rdto);
		
		return new ModelAndView(path);
	}
}
