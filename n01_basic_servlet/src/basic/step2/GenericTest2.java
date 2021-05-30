package basic.step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class GenericTest2 extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor = 'yellow'><h2>Hello..Servlet2!!..</h2></body>");
		
		out.close();
	}
}
