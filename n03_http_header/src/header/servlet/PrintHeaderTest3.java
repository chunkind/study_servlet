package header.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrintHeaderTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public PrintHeaderTest3() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성
		// 1. 한글처리.. 양방향
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 2. PrintWriter 리턴받고
		PrintWriter out = response.getWriter();
		
		out.println("<html><body bgcoloe = yellow>");
		out.println("<h2>Header Information Printing2..</h2><p>");
		
		// 3. Header에 들어있는 값 다 받아와서..
		Enumeration<String> en = request.getHeaderNames();
		while(en.hasMoreElements()){
			String key= en.nextElement();
			String value = request.getHeader(key);
			out.println(key + " : " + value + "<br>");
		}
		out.println("<hr>");
		
		// 4. 웹브라우저로 출력.. 이때 폼에 입력된 값도 받아서 함께 출력.
		String name = request.getParameter("name");
		out.println("당신의 이름 : " + name);
		out.println("</body></html>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
	}
}
