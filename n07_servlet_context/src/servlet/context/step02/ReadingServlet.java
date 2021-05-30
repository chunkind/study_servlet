package servlet.context.step02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet context는 글로벌한 초기화이기 때문에
 * 다른 서블릿에서 참조가능하다.
 */
public class ReadingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletContext servletContext;
    private HashMap<String, String> userList;
    
    @Override
	public void init() throws ServletException {
		System.out.println("1-2. init()....call...");
		
		servletContext = getServletContext();
		System.out.println("Context Path :: "+servletContext.getContextPath());
	}

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2-2. doGet()...call....");
		userList = (HashMap<String, String>)servletContext.getAttribute("userList");
		System.out.println("userList : " + userList.toString());
		
		//한글설정
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//문서객체 생성
		PrintWriter out = response.getWriter();
		
		//리스트에 담긴 정보를 화면에 출력
		out.println("<h2>다음은 UserList안에 들어있는 접속자 정보입니다...</h2><p>");
		Set<String> set = userList.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = (String)userList.get(key);
			out.println(key+"  :  "+ value+"<br>");
		}
		out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("4-1.servlet destroy call..");
	}
}
















