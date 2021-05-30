package servlet.context.step01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletContext servletContext;

	@Override
	public void init() throws ServletException {
		System.out.println("2.servlet init call..");
		//servlet Context를 초기화한다.
		servletContext = getServletContext();
		
		//1.하나하나 뽑기.
		String userName1 = servletContext.getInitParameter("userName1");
		String userName2 = servletContext.getInitParameter("userName2");
		String userName3 = servletContext.getInitParameter("userName3");
		String userFile = servletContext.getInitParameter("userFile");
		System.out.println("==================하나하나 뽑기=====================");
		System.out.println("userName1 : " + userName1);
		System.out.println("userName2 : " + userName2);
		System.out.println("userName3 : " + userName3);
		System.out.println("userFile : " + userFile);
		System.out.println();
		
		//2.Collection API를 이용하여 뽑기.
		System.out.println("===========Collection API를 이용하여 뽑기============");
		Enumeration<String> en = servletContext.getInitParameterNames();
		while (en.hasMoreElements()) {
			String key = en.nextElement();
			String value = servletContext.getInitParameter(key);
			System.out.println(key + " : " + value);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("3.servlet doGet call...");
		//한글설정.
		request.setCharacterEncoding("UTF-8");
		//방법1
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html");
		//방법2
		response.setContentType("text/html;charset=UTF-8");
		
		//문서객체 초기화
		PrintWriter out = response.getWriter();
		
		out.println("<h3><b>콘솔을 확인하세요.</b></h3>");
		out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("4.servlet destroy call..");
	}
}
