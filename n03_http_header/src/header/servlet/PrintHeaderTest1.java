package header.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrintHeaderTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실제 로직은 여기서 작성.
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body bgcolor ='yellow'>");
		out.println("<h2>Header Information Printing..</h2><p>");
		/*
		 *  클라이언트가 서버에 요청할때 모든 헤더의 정보를 모두 받아와서
		 *  웹으로 출력..
		 */
		Enumeration<String> en = request.getHeaderNames();
		while(en.hasMoreElements()){
			String key = en.nextElement();
			String value = request.getHeader(key);
			out.println(key+ " : " + value + "<br>");
		}
		
		out.println("</body></html>");
		out.close();
	}
}