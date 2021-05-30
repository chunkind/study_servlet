package sevlet.Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ThirdSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 기존의 세션을 받아온다.
		 * 2. 세션 id값을 다시 웹으로 출력
		 * 3. 세션에 바인딩 된 객체가 있다면..	if..로그아웃.. 이때 세션을 죽인다.
		 * 4. 팝업창을 하나 띄워서 "로그아웃 하셨습니다"라는 메세지를 띄우고
		 * 5. 세션에 바인딩 된 객체가 없다면 ..else
		 * 	  네비게이션.. session1.html로 다시 돌아간다.
		 * 	  이때 (forword? / redirect?)
		 */
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		out.println("JSESSIONID ::" + session.getId() + "<br>");
		if(session.getAttribute("name") != null) {
			// 로그아웃
			session.invalidate();
			out.println("<script>");
			out.println("alert('로그아웃 하셨습니다!')");
			out.println("location.href='session1.html'");
			out.println("</script>");
		}else{
			response.sendRedirect("session1.html");
		}
	}
}