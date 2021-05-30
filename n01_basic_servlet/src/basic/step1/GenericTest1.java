package basic.step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericTest1 extends GenericServlet{
	private static final long serialVersionUID = 1L;

	//클라이언트가 요청을 하면 (웹브라우저로) 수행되는 메소드..
	//컨테이너가 호출해준다.. 요청이 들어오면..(알아서) 
	//개발자는 이 안에다 클라이언트의 요청을 수행하는 로직을 작성하면 된다.
	//웹브라우저로 "Hello Servlet"을 뿌려주도록 하겠다.
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// 클라이언트로 출력을 하기위해서는 PrintWriter라는 객체를 하나 리턴받아야 한다.
		PrintWriter out = response.getWriter();	//웹브라우저로 뿌릴수 있는 기능
		
		out.println("<html><body><h2><b>Hello Servlet..!</b></h2></body></html>");
		
		out.close();
	}
}
