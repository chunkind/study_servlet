package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.model.MemberDAO;
import context.model.MemberDTO;

public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성..
		/*
		 * 1. 폼에 입력된 ID 값 받는다.
		 * 2. MemberDAO 받아와서 
		 * 3. 비지니스 로직 호출.. 이때 DTO를 리턴 받는다.
		 * 4. ServletRequest에 바인딩
		 * 5. RequestDispatcher를 리턴받는다.
		 * 		: RequestDispatcher rdp = request.RequestDispatcher("ResultMemberServlet");
		 * 6. 포워딩
		 * 		: rdp.forward(request, response);
		 */
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		MemberDAO dao = MemberDAO.getInstance();
		try{
			MemberDTO rdto = dao.findMemberById(id);
			
			request.setAttribute("rdto", rdto);
			
			out.println("<h2>RequestDispatcher Returning</h2><p>");
			//RequestDispatcher rdp = request.getRequestDispatcher("ResultMemberServlet");
			//RequestDispatcher rdp = request.getRequestDispatcher("viewResult.jsp");
			//rdp.forward(request, response);
			
			//include test..
			RequestDispatcher rdp = request.getRequestDispatcher("include.jsp");
			rdp.include(request, response);
			
			out.println("<h1>forwarding..</h1>");
			out.close();
			
		}catch(Exception e){
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

/*
 * 	forward
 * ::
 * RequestDispatcher 의 forward()를 이용하면 현재 페이지(서블릿)의 모든 제어권
 * (요청, 응답)이 View page(ResultMemberServlet)로 넘어가 버린다.
 * 그리고 최종적인 ResultMemberServlet에서 마무리 되지만 실제 주소창에는 SearchMemberServlet이 뜬다.
 * 
 * SearchMemberServlet의 PrintWriter 부분은 전혀 출력되지 않는다.
 * 이유는 PrintWriter 객체의 출력은 응답시 맨 마지막에 한꺼번에 이뤄지기 때문이다.
 * 
 * 위에 나타난 현상처럼, 서버 상에는 실제로 두개의 Component가 존재하고 있다.
 * SearchMemberServlet / ResultMemberServlet
 * 이전까지의 방식이라면 각각 두번의 요청과 두번의 응답이 있었겠지만
 * 그런데 RequestDispatcher 방식을 이용하면 한번의 요청으로 SearchMemberServlet로 갔다가 여기서 응답하지 않고
 * 바로 서버상에서 ResultMemberServlet으로 연결되기 때문에 결국엔 한번의 요청과 한번의 응답으로 이뤄진다.
 * 이런 요청~응답 흐름으로 이때 우리가 사용해야할 Attribute는 바로 ServletRequest가 가장 적합한 것이다.
 * 
 * 
 * 	include
 * ::
 * SearchMemberServlet에서 PrintWriter를 이용한 출력을 하고 싶다면 include를 사용해야 한다.
 * rdp.include(req, res)가 작성된 코드 부분으로 정확하게 페이지가 include가 된다.
 * 그리고 include되는 부분의 앞이나 뒷부분도 함께 출력된다.
 * 
 * --> forward() / include() 방식의 잇점.
 * 서버상에서 직접적으로 다른 페이지를 호출하는 방식.
 * 서버상에서의 이동 속도가 빠르다.
 * 
 * RequestDispatcher rdp = request.getRequestDispatcher("이동할 페이지");
 * --> 이동할 페이지의 경로가 (절대경로) or 상대경로
 * 
 * RequestDispatcher rdp = context.getRequestDispatcher("이동할 페이지");
 * --> 이동할 페이지의 경로가 절대경로
 * 
 */
