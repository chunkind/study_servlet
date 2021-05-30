package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * Cookie api를 살펴보겠다.
 */
public class SetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		Date now = new Date();	//쿠키값으로 now를 넣겠다.
		
		String title = "KOSTA";
		// 1. Cookie 생성.
		Cookie c1 = new Cookie("now", now+"");
		Cookie c2 = new Cookie("title", title);
		
		// 브라우저
		c1.setMaxAge(24*60*60);	//쿠키가 하루동안 저장되는 시간을 지정.
		c2.setMaxAge(0);
		
		// 2. 생성된 쿠키를 클라이언트로 보내는 로직.
		response.addCookie(c1);
		response.addCookie(c2);
		
		out.println("<h2>쿠키가 생성된 시점의 실행시간 : " +now+"<br>");
		out.println("Title :" + title+"<br>"); 
		out.println("<a href ='GetCookieTest'>GetCookieTest로 페이지 이동</a>");
	}
}
