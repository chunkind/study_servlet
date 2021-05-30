package basic.step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicHttpServlet1 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	// 클라이언트가 요청을 하면 컨테이너에 의해서 자동 호출되는 함수..
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 수행하고자 하는 내용을 작성.

		/*
		 * 웹브라우저로는 안녕하세요? 출력.
		 * 콘솔로는 왜왔니? 출력.
		 * 
		 * DD 파일 작성 조건 ::
		 * 서버 내부 이름 : BasicServlet
		 * 클라이언트가 url로 요청하는 이름 : Basic
		 */
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<h2>안녕하세요?</h2><br>");
		System.out.println("왜 왔니??");
		out.close();
	}
}
