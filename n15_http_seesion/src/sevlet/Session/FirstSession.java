package sevlet.Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 세션을 하나 받아온다.
		/*
		 *클라이언트가 서버에 접속(요청)하면 세션은 자동적으로 서버에서 생성된다.
		 *이걸 프로그래머가 사용할려면 받아서 쓰면 된다.. request.getSession()
		 */
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		out.println("JSESSION ::" + session.getId());
		
		//2. 폼에 입력된 값 받아서..dto를 생성.. dto를 biz()인자값으로 넣고 호출.
		// 리턴되는 값을 session에 바인딩.
		session.setAttribute("name","habaree");
		out.println("<hr>");
		
		//3. 네비게이션 .. 페이지 이동..
		out.println("<a href='SecondSession'>두번째 페이지 이동..</a>");
	}
}