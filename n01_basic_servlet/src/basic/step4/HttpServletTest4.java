package basic.step4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *  Client가 요청을 하면 서블릿에서 요청을 수행하기 위해서 이전까지는 service()를 구현했다.
 *  하지만 HttpServlet을 상속받은 서블릿은 service() 대신에 doPost() / doGet()을 이용해서
 *  요청을 처리한다. 결과는 동일하게 나온다. 그러나 둘다 한번에 수행할 수 없고 둘 중 하나만 사용 가능하다.
 *  이중에서 기본적인 요청을 처리하는 메소드는 doGet()이다.
 *  http://127.0.0.1:7777/web01_BasicServlet/HttpServletTest4 --> (기본요청) 서버가 doGet()을 호출해준다.
 */
public class HttpServletTest4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 이곳으로 요청이 들어간다..
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);		//doPost()로 재호출.
	}
	
	// 실제 로직은 여기서 작성..
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("안녕? 서블릿..");
		
		out.close();
	}
}
