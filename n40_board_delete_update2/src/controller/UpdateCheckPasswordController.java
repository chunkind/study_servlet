package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;

public class UpdateCheckPasswordController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		String password = request.getParameter("password");
		
		boolean flag=BoardDao.getInstance().checkPassword(no, password);
		
		request.setAttribute("flag", flag);
		 
		return new ModelAndView("update_checkpass_result.jsp");
	}
}


















