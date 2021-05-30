package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;

public class AmountDownController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		
		String path  = "index.jsp";
		CartBiz.getInstance().downAmount(name, request);
		
		path="itemCartList.jsp";
		ModelAndView mv = new ModelAndView();
		mv.setUrl(path);
		mv.setRedirect(true);
		//System.out.println(mv);
		return mv;
	}

}
