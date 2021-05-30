package config.step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InternationalGreetServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String greetMessage;
    public InternationalGreetServlet2() {
    	System.out.println("생성자 call..");
    }
	
    @Override
	public void init() throws ServletException {
    	System.out.println("init() call..");
    	//dd에 설정된 값을 끌어 당긴다.
    	greetMessage = getInitParameter("greeting");
    	System.out.println("init call... by getInitParameter()..greetMessage Setting.");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    	System.out.println("doGet() Call.");
    	//로직은 여기서 작성..
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
    	
    	PrintWriter out = response.getWriter();
    	
    	// 폼에 입력된 값 받고
    	String name = request.getParameter("name");
    	out.println("<h2>Welcome to the Winter Olymphics</h2><p>");
    	out.println("<b>"+name+"</b><p>");
    	
    	out.println(greetMessage);
    	out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
}
