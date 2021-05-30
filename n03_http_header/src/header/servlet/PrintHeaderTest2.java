package header.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * html 의 form 태그의 method라는 속성의 값이 get이기 때문에
 * 이 서블릿에서 요청을 수행하는 메소드가 doGet()이 된다.
 */
public class PrintHeaderTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public PrintHeaderTest2() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성
		// 1. 한글처리.. 양방향
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 2. PrintWriter 리턴받고
		PrintWriter out = response.getWriter();
		/*
		 * 서블릿의 doGet() 안에서 html 테그가 부분적으로 들어가있다.
		 * 자바 코드 안에 태그가 부분적으로 들어가 있는 꼴이다.
		 * 완벽한 로직 중심의 형태가 아니다..
		 * jsp를 배워서 그쪼으로 태그를 다 빼야 겠다.
		 * jsp는 결과적으로 View(출력)를 담당하는 기술인 셈이다.
		 */
		out.println("<html><body bgcoloe = yellow>");
		out.println("<h2>Header Information Printing2..</h2><p>");
		
		// 3. Header에 들어있는 값 다 받아와서..
		Enumeration<String> en = request.getHeaderNames();	//getHeaderNames은 
		while(en.hasMoreElements()){
			String key= en.nextElement();	//map방식은 key넣으면 값이 나옴
			String value = request.getHeader(key);
			out.println(key + " : " + value + "<br>");
		}
		out.println("<hr>");
		
		// 4. 웹브라우저로 출력.. 이때 폼에 입력된 값도 받아서 함께 출력.
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		out.println("당신의 이름 : " + name +"<br>");
		out.println("당신의 주소는 : " + addr +"<br>");
		out.println("</body></html>");
		
		out.close();
		
	}
}