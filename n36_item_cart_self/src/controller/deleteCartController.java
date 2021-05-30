package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;

public class deleteCartController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String path  = "index.jsp";
		//System.out.println("arr : ");
		//System.out.println(request.getParameterValues("arr"));
		String[] arr = request.getParameterValues("arr");
		//System.out.println(arr.length);
		/*for(String s: arr)
		{
			System.out.println(s);
		}*/
		CartBiz.getInstance().deleteCart(arr, request);
		
		path="itemCartList.jsp";
		ModelAndView mv = new ModelAndView();
		mv.setUrl(path);
		mv.setRedirect(true);
		System.out.println(mv);
		return mv;
		
	}

}
