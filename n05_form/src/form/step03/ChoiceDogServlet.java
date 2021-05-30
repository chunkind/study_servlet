package form.step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChoiceDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 1. 체크박스에 선택된 값들을 받아오기
		String[] dogs = request.getParameterValues("dog");

		// 2. 받아온 값들은 개들의 이미지를 뜻하는 스트링이다.
		// 이미지를 웹으로 표현할려면 html태그가 여기서 필요하다.. table>tr>td
		
		out.println("<html><body bgcolor='block'><p>");
		out.println("<h2 align=center><font color='white'>다음은 당신이 선택한 강아지 입니다.</h2>");
		out.println("<table align='center' bgcolor='yellow' width='80%'>");
		out.println("<tr>");
		
		//선택한 개의 숫자만큼.. td가 나올것이다.
		for(int i=0; i<dogs.length; i++){
			out.println("<td>");
			out.println("<img src=' " + dogs[i] + "'/>");
			out.println("</td>");
		}
		
		out.println("</tr></table></body></html>");
		out.close();
	}
	
}
