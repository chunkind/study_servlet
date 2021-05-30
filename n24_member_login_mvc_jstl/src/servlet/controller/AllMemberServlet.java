package servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//결과 페이지는 allView.jsp로 이동한다.
		try{
			ArrayList<MemberDTO> list=MemberDAO.getInstance().showAllMember();
			request.setAttribute("list", list);
			request.getRequestDispatcher("allView.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}














