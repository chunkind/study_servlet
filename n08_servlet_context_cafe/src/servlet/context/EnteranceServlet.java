package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.context.vo.PersonVO;

public class EnteranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<PersonVO> list = Collections.synchronizedList(new ArrayList<PersonVO>());
	
	public EnteranceServlet() {
		System.out.println("3.EnteranceServlet create...");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("4.EnteranceServlet init call...");
		System.out.println("ServletContext가 저장된 위치값 : " + getServletContext());
		
		//ServletContext에 가입자 명단을 저장할 List를 먼저 저장해 놓습니다.
		getServletContext().setAttribute("list", list);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("6.EnteranceServlet doPost call...");
		//양방향의 한글처리.. 이 부분을 생략..
		
		PrintWriter out= response.getWriter();
		//폼으로부터 값을 받아옴
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		//vo에 바인딩..
		PersonVO vo= new PersonVO(name, age);
		
		//vo를 List에 저장..
		list.add(vo);
		System.out.println("List주소값 확인 1 : " + list.hashCode());	//동일한지 확인..
		
		out.println(name+"님이 카페 가입 하셨습니다.<p>");
		out.println("<a href= ViewServlet?name="+name+"> viewServlet으로 이동하기.. 입장 명단 확인</a>");
		out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("10.EnteranceServlet destroy call...");
	}
}
