package life.servlet;
/*
 * 해당 코드에서는 서블릿의 라이프 사이클 메소드에 대해서 살펴보겠다.
 * 1) 호출 시점
 * 2) 해당 메소드에서 진행되어야 하는 로직
 * 3) 호출 횟수
 * 4) 호출 주체 : 컨테이너에 의해서 특정 시점이 되면 자동으로 호출된다.
 * ------------------------------------------------
 * 해당 코드에서 count는 필드로 선언되어 있다.
 * 요청이 아무리 반복되더라도, 브라우저가 닫히더라도 count에 저장된 값은
 * 계속 유지된다... 그러나 이 값도 영구적이지 않다.
 * 서버가 내려지면 서블릿도 메모리에서 해제되고 이렇게 되면 필드값은 사라지기 때문이다.
 * 영구적으로 저장하는 방법? --> 디비에 저장
 * Life Cycle 메소드 중에서
 * destroy() : 디비에 count값을 저장하는 로직을 담는다...14
 * init() : 디비에 저장된 count값을 다시 가지고 오는 로직을 담는다.. 15부터 다시 시작
 * 이때 반드시 destroy() / init()이 호출됨을 보장받을때 이 로직은 타당성을 지닌다.
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 이 값도 영구적으로 저장되는 값은 아니다.
	// 값을 영구적으로 저장해야 하는데,, 어떻게 해야하나?...디비...
	
	private int count = 0;
	public LifeCycleServlet1() {
		System.out.println("1. 서블릿 객체가 생성됩니다..By Container..자동호출");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("2. init() call.. By Container..");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. 요청이 들어오면 자동 호출됩니다.. By Container..자동호출");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 웹 브라우저로 출력하는 부분..
		out.println("<html><body>");
		out.println("<h3>Life Cycle Call Back Method..</h3><p>");
		out.println("<b>Count :: </b>" + ++count);
		out.println("</body></html>");
		
		out.close();
	}

	@Override
	public void destroy() {
		System.out.println("4. destroy() call.. By Container..");

	}
	
}
