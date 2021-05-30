package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.context.vo.PersonVO;

public class ViewServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private List<PersonVO> list;
    
    public ViewServlet(){
    	System.out.println("7.ViewServlet Constructor call...");
    }
    
	@Override
    public void init() throws ServletException {
		System.out.println("8.ViewServlet init call...");
	    System.out.println("ServletContext 주소값:: " + getServletContext());
	    list = (List)getServletContext().getAttribute("list");
	    System.out.println("List 주소값 확인2 :" + list.hashCode());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("9.ViewServlet doGet call...");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		out.println("<b>"+name+"</b> 님, 카페 가입을 축하드립니다..<p>");
		out.println("<hr width=90%>");
		out.println("<h2>===== Cafe All Member list =====</h2><p>");
		out.println("<table border=2>");
		for(int i=0; i<list.size(); i++){
			out.print("<tr>");
			out.print("<td>"+(i+1)+"</td>");
			out.print("<td>"+list.get(i).getName()+"</td>");
			out.print("<td>"+list.get(i).getAge()+"</td>");
			out.print("</tr>");
		}// for
		out.println("</table>");
		out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("11.ViewServlet destroy call...");
	}
}
