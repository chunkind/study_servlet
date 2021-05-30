package basic.step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//폼에 입력된 값을 받아온다.. String name에 할당.
		String name = request.getParameter("name");	//name이라는 변수에 민재짱이 할당됨.
		
		out.println("<html><body>");
		out.println("<h2><b>Hi~</h2></b><p>");
		out.println("<li>Your Name is " + name + "<br>");		//li는 '.' 하나 찍는 효과 br 은 엔터임.
		out.println("한글처리가 되야 합니다~~~");
		out.println("</body></html>");
		
		out.close();
	}

}
