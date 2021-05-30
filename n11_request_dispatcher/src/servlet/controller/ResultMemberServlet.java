package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.model.MemberDTO;

public class ResultMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       // 왜 doPost()인지 중요합니다!
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		MemberDTO rdto =(MemberDTO)request.getAttribute("rdto");
		out.println("<h2>다음 정보는 ID에 해당하는 회원의 정보입니다.</h2><p>");
		out.println("ID : " + rdto.getId() + "</br>");
		out.println("NAME : " + rdto.getName() + "</br>");
		out.println("ADDRESS : " + rdto.getAddress() + "</br>");
		
		out.close();
	}
}
