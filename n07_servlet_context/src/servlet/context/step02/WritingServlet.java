package servlet.context.step02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 동적으로 context-param을 설정한다.
 */
public class WritingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletContext servletContext;
	private HashMap<String, String> userList;

	@Override
	public void init() throws ServletException {
		System.out.println("1-1. init()....call...");

		//servlet Context를 초기화한다.
		servletContext = getServletContext();
		
		userList = new HashMap<String, String>();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//한글설정
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("2-1. doPost()...call....");
		//html로부터 값 받아오기.
		String id = request.getParameter("userId");
		String pass = request.getParameter("userPass");
		String name = request.getParameter("userName");

		userList.put("id", id);
		userList.put("pass", pass);
		userList.put("name", name);

		servletContext.setAttribute("userList", userList);
		
		
		//문서객체 생성
		PrintWriter out = response.getWriter();
		
		out.println("<html><body bgcolor='pink'>");
		out.println("<b>======= The Communication between Servlets=========<br>");
		out.println("사용자의 정보가 ServletContext에 저장되었습니다...</b><br><br>");
		out.println("<a href='RS'>접속자 명단 보기</a></body></html>");
		out.close();

	}
	
	@Override
	public void destroy() {
		System.out.println("4-2.servlet destroy call..");
	}
}
