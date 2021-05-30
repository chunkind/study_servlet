package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;

public class showAllMemberController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) {

		ArrayList<MemberDTO> rList = null;
		String path = "index.jsp";
		
		try {
			rList = (ArrayList<MemberDTO>)MemberDAO.getInstance().showAllMember();
			request.setAttribute("rList", rList);
			path = "allView.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView(path);
	}

}
