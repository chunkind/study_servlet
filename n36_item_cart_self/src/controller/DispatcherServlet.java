package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이전에는 여기서 hidden으로 넘어온 값을 command라는 이름으로 받았다.
		// hidden을 사용하면 요청하는 모든 페이지에 hidden 태그를 일일이 달아야 하는
		// 번거로움이 있다. 다른 방법을 사용해 보겠다...두 가지 방법중에 선택은 여러분이~~
		String requestURI=request.getRequestURI();
		System.out.println("RequestURI :: "+requestURI); //web39_ItemCart/DispatcherServlet
		
		String contextPath=request.getContextPath();
		System.out.println("getContextPath :: "+contextPath); //web39_ItemCart
		
		//    DispatcherServlet이 추출되도록 substring()을 사용하세요..
		String command = requestURI.substring(contextPath.length());
		System.out.println("command ::"+command);
		
		ModelAndView mv = null;
		Controller controller=HandlerMapping.getInstance().createController(command);
		
		try{
			mv=controller.handle(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(mv != null){
			if(mv.isRedirect())
				response.sendRedirect(mv.getUrl());		
			else
				request.getRequestDispatcher(mv.getUrl()).forward(request, response);
		}//if		
	}//doProcess()
}//class










































