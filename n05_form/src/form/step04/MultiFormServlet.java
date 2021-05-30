package form.step04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultiFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 처리.
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1.getParameter 사용
//		step01(request, response);
		
		//2.getParameterMap 사용
		step02(request, response);
		
	}
	
	public void step01(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String number = request.getParameter("tel");
		String statement = request.getParameter("intro");
		
		out.println("ID : " + id + "<br>");
		out.println("hobby : <br>");
		for(int i=0; i<hobby.length; i++){
			out.println(hobby[i] + "  ");
		}
		out.println("gender : " + gender + "<br>");
		out.println("number : " + number + "<br>");
		out.println("statement : " + statement + "<br>");
	}
	
	public void step02(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		Map<String, String[]> map = request.getParameterMap();
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()){
			String key = it.next();
			String[] value = map.get(key);
			
			out.println(key + " :: ");
			for(int i=0; i<value.length; i++){
				out.println(value[i] + "  ");
				if(i == value.length-1)
					out.println("<br>");
			}
		}
	}
	
}