package context.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.SetAllPropertiesRule;

import context.model.MemberDAO;
import context.model.MemberDTO;

public class FindAddressMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * dao 얻어와서
		 * 비지니스 로직 호출
		 * ArrayList 리턴받고
		 * 동일한 주소에 사는 사람이 몇명인지도 출력
		 * 테이블 형식으로 동일한 주소에 사는 사람의 id, name, address를 웹으로 출력.
		 */
		/*PrintWriter out = response.getWriter();*/
		String address = request.getParameter("address");
		System.out.println("주소 :" + address);
		MemberDAO dao = MemberDAO.getInstance();
		try{
			System.out.println("trying binding in FAMS.");
			ArrayList<MemberDTO> returnList = dao.findMemberByAddress(address);
			for(int i=0; i<returnList.size(); i++){
				System.out.println(returnList.get(i));
			}
			// 바인딩, 페이지 이동(네비게이션 과정이 생략)
			/*out.println(address + " 에 사는 사람은 " + returnList.size()+"명 입니다.<br><hr>");

			if(!returnList.isEmpty()){
				out.println("<html><body align='center'><table border=2>");
				for(int i = 0; i<returnList.size(); i++){
					out.print("<tr><td>"+(i+1)+"</td>");
					out.print("<td>"+returnList.get(i).getName()+"</td>");
					out.print("<td>"+returnList.get(i).getAddress()+"</td></tr>");
				}	//for
				out.print("</table></body></html>");
			}else{
				out.println("<b>해당 주소에 거주하는 회원은 없습니다...</b>");
			}*/

			/*
			 * 바인딩 / 네비게이션(showFindByAddress.jsp)
			 */
			request.setAttribute("returnList", returnList);
			RequestDispatcher rdp = request.getRequestDispatcher("showFindByAddress.jsp");
			rdp.forward(request, response);
		}catch(Exception e){

		}
	}
}
