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
		/*
		 * 내생각 :(1.폼에 입력된 값을 받아온다. 2.doPost작성한다. 3.
		 *  1. 폼에 입력된 값을 받아온다.
		 */
		String id = request.getParameter("id");
		MemberDAO dao = MemberDAO.getInstance();
		String path = "index.jsp";
		try{
			MemberDTO rdto = dao.findMemberById(id);
			if(rdto != null) {
				request.setAttribute("rdto", rdto);
				path = "find_ok.jsp";
				//request.getRequestDispatcher("find_ok.jsp").forward(request, response);
			}else{
				path = "find_fail.jsp";
				//request.getRequestDispatcher("find_fail.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
