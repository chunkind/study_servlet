package sevlet.Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 앞에서 만들어진 세션을 하나 받아온다.
		 * 2. 세션에 바인딩 된 값이 있다면 찾아온다.
		 * 3. 값이랑 jsessionid값이랑 웹으로 출력.
		 * 4. 네비게이션.. ThirdSession 페이지로 이동.
		 */
		//	  이때 만약에 받아온 값이 없다면.. session1.html로 이동.

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		if(session.getAttribute("name") != null) {
			String name = (String)session.getAttribute("name");
			out.println("Session Binding Value ::" + name + "<br>");
			out.println("JSESSIONID Value ::" + session.getId() + "<br>");
			out.println("<hr>");	// '________' 줄 뜨는거
			out.println("<a href='ThirdSession'>세번째 페이지로 이동..</a>");
		}else{
			out.println("바인딩 된 객체가 없습니다..<br>");
			//session1.html
			response.sendRedirect("session1.html");
		}
	}
}