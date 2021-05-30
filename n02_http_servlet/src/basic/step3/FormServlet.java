package basic.step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @quickCode ##
* @project  dev03_web02_HttpServlet
* @path basic.step3.FormServlet.java
* @auth chunk
* @date 2017. 3. 4. 오전 1:21:01
* @other 
* TODO chunk
* doGet만 구현햇을경우 doPost 요청을 보내면 에러가 난다!!
 */
public class FormServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//요청은 일단 이리로 들어온다..method ="get"..doGet()으로 요청을 유도한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}
	
	// 로직은 여기서 작성.
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청시, 응답시 양방향 한글처리 .. utf-8
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 2. PrintWirter 객체 리턴받고
		PrintWriter out = response.getWriter();
		out.println("<h2>Form에 입력된 값을 받아옵니다..</h2><p>");
		
		// 3. 웹브라우저의 폼에 입력된 값을 name, addr, kisu 라는 변수로 각각 받는다.
		String name = request.getParameter("userName");
		String addr = request.getParameter("userAddr");
		String gender = request.getParameter("userGender");
		
		// 4. 응답시 다시 웹브라우저로 name, addr, kisu에 할당된 값을 출력
		out.println("당신의 이름 :" + name + "<br>");
		out.println("당신의 주소 :" + addr + "<br>");
		out.println("당신의 성별 :" + gender + "<br>");
		
		out.close();
	}
}
