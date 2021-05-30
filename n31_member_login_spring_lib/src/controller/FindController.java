package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FindController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		MemberDTO rdto = MemberDAO.getInstance().findMemberById(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("find_ok");
		mv.addObject("message", "Hello Spring Lib Test..:: " +rdto.getName());
		return mv;
	}
}
