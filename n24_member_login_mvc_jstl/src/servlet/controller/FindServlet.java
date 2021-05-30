package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		MemberDAO dao = MemberDAO.getInstance();
		String path = "index.jsp";
		try{
			MemberDTO rdto=dao.findMemberById(id);
			if(rdto != null){
				request.setAttribute("rdto", rdto);
				path = "find_ok.jsp";
			}else{
				path = "find_fail.jsp";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}












