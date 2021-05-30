package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>SetCookieTest에서 저장한 정보를 받아옵니다..</h2><p>");
		
		Cookie[ ] cs=request.getCookies();
		for(Cookie c : cs){
			out.println(c.getName()+"-"+c.getValue());
		}
		out.close();
	}
}