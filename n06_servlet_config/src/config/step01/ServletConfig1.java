package config.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfig1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name, addr, email;

	// 이부분에서 서블릿 초기화 로직을 작성할 수 없다.
	public ServletConfig1() {
		System.out.println("서블릿이 생성됨.");
	}

	// servletConfig 객체를 이용한 초기화
	// servletConfig의 getInitParameter()를 이용한다.
	// getInitParameter()는 값을 form이 아닌, Container차원의 정보를 끌어당긴다.
	// Container차원의 정보는 D.D 파일에 매핑된 정보를 말한다.
	// D.D파일의 매핑을 먼저 해야한다.
	public void init() throws ServletException {
		System.out.println("init()... 호출됨");
		// getInitParameter()를 이용해서 컨테이너 차원에서 설정한 정보를 받아온다.
		name = getInitParameter("name");
		addr = getInitParameter("addr");
		email = getInitParameter("email");
		System.out.println("DD파일에서 가져온 정보 : " + name + ", " + addr + ", " + email);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 받아온 정보를 웹으로도 출력해 보세요.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<h2>A Servler Intialization..Using ServletConfig..</h2><p>");
		out.println("당신의 이름" + name + "<br>");
		out.println("당신의 주소" + addr + "<br>");
		out.println("당신의 이메일" + email + "<br>");
	}
}
