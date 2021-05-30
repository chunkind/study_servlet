package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;

public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
	
		boolean idExist = false;
		try{
			MemberDTO rdto=MemberDAO.getInstance().findMemberById(id);
			if(rdto != null){
				idExist = true;						
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("idExist", idExist);		
		request.getRequestDispatcher("idcheck.jsp").forward(request, response);
	}
}









