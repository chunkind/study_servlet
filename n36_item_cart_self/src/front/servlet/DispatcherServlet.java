package front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.HandlerMapping;
import controller.ModelAndView;

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
		// hidden을 사용하면 요청하는 모든 페이지에 hidden 태그를 일일이 넣어야 하는 번거로움이 있는데,
		// 다른 방법을 사용한다.
		
		String requestURI = request.getRequestURI();
		System.out.println("RequestURI : " + requestURI);
		String contextPath = request.getContextPath();
		System.out.println("ContextPath : " + contextPath);
		String command = requestURI.substring(contextPath.length());
		//System.out.println(request.getParameter("name"));
		ModelAndView mav = null;
		Controller controller = HandlerMapping.getInstance().createController(command);
		System.out.println(controller);
		try {
			mav = controller.handle(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(mav != null){
			if(mav.isRedirect() == true){
				
				response.sendRedirect(mav.getUrl());
			}else{
				request.getRequestDispatcher(mav.getUrl()).forward(request, response);
			}
		}else{
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}
